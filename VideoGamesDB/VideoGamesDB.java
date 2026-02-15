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
		throw new UnsupportedOperationException ("TO-DO");
	}

	public int searchVideoGame (String str) throws IOException {
		throw new UnsupportedOperationException ("TO-DO");
	}

	public void writeVideoGameInfo (int n, VideoGameInfo vgi) throws IOException {
		throw new UnsupportedOperationException ("TO-DO");
	}

	public void appendVideoGameInfo (VideoGameInfo vgi) throws IOException {
		writeVideoGameInfo (numVideoGames, vgi);
		numVideoGames++;
	}

	public boolean deleteVideoGame (String str) throws IOException {
		throw new UnsupportedOperationException ("TO-DO");
	}

}
