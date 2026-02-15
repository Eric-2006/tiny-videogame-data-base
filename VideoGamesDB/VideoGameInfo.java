public class VideoGameInfo {

	private String title;
	private String series;
	private String publisher;
	private  short year;
	private    int sales;

	private static final int     TITLE_LIMIT = 24;
	private static final int    SERIES_LIMIT = 19;
	private static final int PUBLISHER_LIMIT = 18;

	public  static final int SIZE = -1; /* TO-DO:
		Establir valor en funció de les mides dels camps. */

	public VideoGameInfo (String title, String series, String publisher,
	                      short year, int sales) {
		this.title     = title;
		this.series    = series;
		this.publisher = publisher;
		this.year      = year;
		this.sales     = sales;
	}

	// Getters
	public String getTitle     () { return title;     }
	public String getSeries    () { return series;    }
	public String getPublisher () { return publisher; }
	public  short getYear      () { return year;      }
	public    int getSales     () { return sales;     }

	public byte[] toBytes() {
		throw new UnsupportedOperationException ("TO-DO");
	}

	public static VideoGameInfo fromBytes (byte[] record) {
		throw new UnsupportedOperationException ("TO-DO");
	}

	public String toString() {
		String ls = System.lineSeparator();
		String result = title;
		if (!series.isEmpty()) {
			result += " (sèrie " + series + ")";
		}
		if (!publisher.isEmpty() || year >= 0) {
			result += ls + "Publicat";
			if (!publisher.isEmpty()) {
				result += " per " + publisher;
			}
			if (year >= 0) {
				result += " en l'any " + year;
			}
			result += ".";
		}
		if (sales >= 0) {
			result += ls + "Ha venut aproximadament " + sales + " còpies.";
		}
		return result;
	}

}
