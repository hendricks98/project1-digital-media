// CMSC 256 Project 1
// Jamel Hendricks
// Part 2 - Image SubClass

import java.lang.Error;

public class Image extends DigitalMedia{

	// default values for width and height 
	// to be used if no width/height provided
	private int width = 0;
	private int height = 0;

	// empty image object constructor
	public Image(){
		super();
	}

	/* a more complex image object constructor
	 * @param 	n 	image name
	 * @param 	s 	image size
	 * @param 	w 	image width
	 * @param 	h 	image height
	*/ 
	public Image(String n, long s, int w, int h){
		super(n,s);
		width = w;
		height =h;
	}

	/* get width of image object
	 * @return 	width 	width of the image object
	*/
	public int getWidth(){
		return width;
	}

	/* get height of image object
	 * @return 	height 	height of the image object
	*/
	public int getHeight(){
		return height;
	}

	/* set width of the image object
	 * @param 	w 	given width of image
	*/
	public void setWidth(int w){
		if (w >= 0){
			width = w;
		} else {
			throw new Error("Invalid width!");
		}
	}

	/* set height of the image object
	 * @param 	h 	given height of image
	*/
	public void setHeight(int h){
		if (h >= 0){
			height = h;
		} else {
			throw new Error("Invalid height!");
		}
	}

	/* check if image object equals another image object
	 * @param 	other 	a comparable object
	 * @return 	boolean 	true if object is equal to other, false if not equal
	*/
	public boolean equals(Object other){
		if (this == other){
			return true;
		} else if (this == null){
			return false;
		} else if (!(other instanceof Image)) {
			return false;
		}

		Image another = (Image) other;

		if ( (another.getName() == getName()) && (another.getSize() == getSize()) && (another.getWidth() == width) && (another.getHeight() == height) ) {
			return true;
		}
		return false;
	}

	/* print info about image
	 * @return 	return image title, width, and height
	*/
	public String toString(){
		return ("Title: " + getName() + "\nWidth: " + getWidth() + "\nHeight: " + getHeight());
	}
}