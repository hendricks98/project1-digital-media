// CMSC 256 Project 1
// Jamel Hendricks
// Part 2 - Song SubClass

public class Song extends DigitalMedia {
	
	// default values for artist and song 
	// to be used if no artist/album provided
	private String artist = "None given";
	private String album = "None given";


	// empty song object constructor
	public Song(){
		super();
	}

	/* simple song object constructor
	 * @param 	n 	song name
	 * @param 	s 	song size
	*/ 
	public Song(String n, long s){
		super(n,s);
	}

	/* a more complex song object constructor
	 * @param 	n 	song name
	 * @param 	s 	song size
	 * @param 	ar 	song artist
	 * @param 	al 	song album
	*/ 
	public Song(String n, long s, String ar, String al){
		super(n,s);
		artist = ar;
		album = al;
	}


	/* get name of song object
	 * @return 	getName() 	name of the digital media object
	*/
	public String getTitle(){
		return getName();
	}

	/* get artist of song object
	 * @return 	artist 	artist of the song object
	*/
	public String getArtist(){
		return artist;
	}

	/* get album of song object
	 * @return 	album 	album of the song
	*/
	public String getAlbum(){
		return album;
	}

	/* set title of the song object
	 * @param 	t 	given title of song
	*/
	public void setTitle(String t){
		// name is validated withing setName()
		setName(t);
	}

	/* set artist of the song object
	 * @param 	a 	given artist of song
	*/
	public void setArtist(String a){
		// if given no artist, will default to "None given"

		if ( (a != null) && (!a.equals("")) ) {
			artist = a;
		}
	}

	/* set album of the song object
	 * @param 	a 	given album of song
	*/
	public void setAlbum(String a){
		// if given no album, will default to "None given"

		if ( (a != null) && (!a.equals("")) ){
			album = a;
		} 
	}

	/* remove the file-type extension from song files
	 * @return 	n 	name of song without extension
	*/
	public String removeExtension(String n){
		if (n.contains(".mp3")){
			n = n.replace(".mp3", "");
		}

		if (n.contains(".m4a")){
			n = n.replace(".m4a", "");
		}

		return n;
	}

	/* check if song object equals another song object
	 * @param 	other 	a comparable object
	 * @return 	boolean 	true if object is equal to other, false if not equal
	*/
	public boolean equals(Object other){
		if (this == other){
			return true;
		} else if (this == null){
			return false;
		} else if (!(other instanceof Song)) {
			return false;
		}

		Song another = (Song) other;

		if ( (another.getTitle() == getName()) && (another.getSize() == getSize()) && (another.getArtist() == artist) && (another.getAlbum() == album) ) {
			return true;
		}
		return false;
	}

	/* print info about song
	 * @return 	return song title, artist, and album
	*/
	public String toString(){
		return ("Title: " + getTitle() + "\nArtist: " + artist + "\nAlbum: " + album);
	}


}