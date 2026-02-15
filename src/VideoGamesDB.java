import java.io.RandomAccessFile;
import java.io.IOException;

public class VideoGamesDB {

    private RandomAccessFile videoGamesDB;
    private int numVideoGames;

    public VideoGamesDB (String fileName) throws IOException {
        videoGamesDB = new RandomAccessFile (fileName, "rw");
        numVideoGames = (int)videoGamesDB.length() / VideoGameInfo.SIZE;
    }

    public int getNumVideoGames() {
        return numVideoGames;
    }

    public void close() throws IOException {
        videoGamesDB.close();
    }

    public void reset() throws IOException {
        videoGamesDB.setLength (0);
        numVideoGames = 0;
    }

    public VideoGameInfo readVideoGameInfo (int n) throws IOException {
        byte[] record = new byte[VideoGameInfo.SIZE];
        videoGamesDB.seek(n * VideoGameInfo.SIZE);
        videoGamesDB.read(record);
        return VideoGameInfo.fromBytes(record);
    }

    public int searchVideoGame (String str) throws IOException {
        for (int i = 0; i < numVideoGames; i++) {
            VideoGameInfo vgi = readVideoGameInfo(i);
            String title = vgi.getTitle();

            title = title.toUpperCase();
            str = str.toUpperCase();

            if (title.equals(str)) {
                return i;
            }
        }
        for (int i = 0; i < numVideoGames; i++) {
            VideoGameInfo vgi = readVideoGameInfo(i);
            String title = vgi.getTitle();

            title = title.toUpperCase();
            str = str.toUpperCase();

            if (title.contains(str)) {
                return i;
            }
        }
        return -1;
    }

    public void writeVideoGameInfo (int n, VideoGameInfo vgi) throws IOException {
        byte[] record = vgi.toBytes();
        videoGamesDB.seek(n * VideoGameInfo.SIZE);
        videoGamesDB.write(record);
    }

    public void appendVideoGameInfo (VideoGameInfo vgi) throws IOException {
        writeVideoGameInfo (numVideoGames, vgi);
        numVideoGames++;
    }

    public boolean deleteVideoGame (String str) throws IOException {
        try {
            int n = searchVideoGame(str);
            VideoGameInfo lastVideoGame = readVideoGameInfo(numVideoGames - 1);
            writeVideoGameInfo(n, lastVideoGame);
            numVideoGames--;
            videoGamesDB.setLength(numVideoGames * VideoGameInfo.SIZE);
            return true;
        } catch (IOException ex) {
            System.err.println("Error al intentar eliminar el videojoc.");
            return false;
        }
    }

}