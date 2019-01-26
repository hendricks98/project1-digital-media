// CMSC 256 Project 1
// Jamel Hendricks
// Part 1 - DigitalMedia SuperClass

import java.lang.Error;

public class DigitalMedia {

	// default fields
	private String name = "None given"; // contains the extension
	private long size = 0;;   // size of file in bytes

	public DigitalMedia(){
		name = name;
		size = size;
	}


	/* DigitalMedia base constructor
     * @param	n 	name of the media
	 * @param 	s 	size of the media
	*/
	public DigitalMedia(String n, long s) {
		name = n;
		size = s;
	}

	/* get the name of the  media
	 * @return name of the media
	*/
	public String getName(){
		return name;
	}

	/* get the size of the media
	 * @return size of the media
	*/
	public long getSize(){
		return size;
	}

	/* set the name of the media
	 * @param 	n 	specified name of media
	*/
	public void setName(String n){
		if (isValidName(n)){
			name = n;
		}	
	}

	/* checks for validity of the name of the media
	 * @param 	n 	name of the media
	 * @retrun 	true/false if name is valid/invalid
	*/
	private boolean isValidName(String n){
		boolean valid = true;

		// invalid if empty string
		if (n == ""){
			valid = false;
		}

		// invalid if null
		if (n == null){
			valid = false;
		}

		// invalid if more than one period
		char period = '.';
		int count = 0;

		for (int i = 0; i < n.length(); i++){
			if (n.charAt(i) == period){
				count++;
			} 
		}

		if (count > 1){
			valid = false;
		}

		if (valid == false){
			throw new Error("Invalid Name!");
		}

		return valid;
	}

	/* set the size of the media
	 * @param 	s 	size of the media
	*/
	public void setSize(long s){
		if (s >= 0){
			size = s;
		} else {
			throw new Error("Invalid size!");
		}
	}

	/* check if digital media object equals another digital media object
	 * @param 	other 	a comparable object
	 * @return 	boolean 	true if object is equal to other, false if not equal
	*/
	public boolean equals(Object other){
		if (this == other){
			return true;
		} else if (this == null){
			return false;
		} else if (!(other instanceof DigitalMedia)) {
			return false;
		}

		DigitalMedia another = (DigitalMedia) other;

		if ( (another.getName() == name) && (another.getSize() == size) ) {
			return true;
		}
		return false;
	}


	/* print out name and size of digital media
	 * @return name and size of media
	/*
	public String toString(){
		return ("Name: " + name + "\nSize: " + size);
	}
	
}