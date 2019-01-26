// CMSC 256 Project 1
// Jamel Hendricks
// Part 3 - MediaList SubClass

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.lang.Error;

public class MediaList {

	// create DigitalMedia ArrayList "mediaStorage" to store songs and images
	static ArrayList<DigitalMedia> mediaStorage = new ArrayList<DigitalMedia>();

	// keep running program while false
	static boolean exit = false;

	// keep track of scanned line
	static int lineNumber = 0;

	// constructor for media list
	public MediaList(){

	}

	/* prompt user for a file name 
	 * @return 	file path for input file 	
	*/
	private static String promptForFileName(){
		System.out.println("Enter a file name: ");
		Scanner keyIn = new Scanner(System.in);
		String n = keyIn.nextLine();

		return n;
	}


	/* open a passed file argument; prompt user for file if @param invalid
	 * @param 	file 	filepath of input file
	 * @return 	Scanner used to read in media from @param 
	*/
	private static Scanner openFile(String file){

		// create a new file object with the file path from @param
		File f = new File (file);

		// create a base scanner
		Scanner i = new Scanner(System.in);

		// attempt to create a scanner from the f file object
		try {

			i = new Scanner(f);
			return i;

		// if unable to find f file object, prompt user for a new file path
		} catch (FileNotFoundException e){

			System.out.println("File was not found.");
			f = new File(promptForFileName());

			// attempt to create a scanner with a user provided file path
			try {

				i = new Scanner(f);

			// if unable to find user provided file path, exit program
			} catch (FileNotFoundException ex){

				System.out.println("No such file " + f + ". Exiting.");
				System.exit(0);

			}
		}

		// return scanner
		return i;
	}

	// student/project identification
	public static void printHeading(){
		System.out.println("Jamel Hendricks");
		System.out.println("Project #1");
		System.out.println("CMSC 256");
		System.out.println("Spring 2019\n");
	}

	/* display digital media corresponding to user selection in the method parameter
	 * @param 	type 	user provided type of digital media
	*/
	public static void displayOptions(String type){

		// diplay all songs
		if (type.equals("S") || type.equals("s")){
			for (DigitalMedia s : mediaStorage){

				if (String.valueOf(s.getClass().getSimpleName()) == ("Song")){
					System.out.println("");
					System.out.println(s.toString());
				}
			}
		} else if(type.equals("I") || type.equals("i")){
			// display all images

			for (DigitalMedia i : mediaStorage){

				if (String.valueOf(i.getClass().getSimpleName()) == ("Image")){
					System.out.println("");
					System.out.println(i.toString());
				}
			}
		} else if (type.equals("Q") || type.equals("q")){
			// exit program 

			System.out.println("Exiting.");
			exit = true;
			System.exit(0);
		} else {
			System.out.println("Invalid input!");
		}
	}

	public static void main(String[] args) {

		// display project information
		printHeading();

		/* GETTING THE FILE */
		Scanner input;
		Scanner lineReader;

		// if there is a command line argument attempt to open it
		if (args.length > 0){
			input = openFile(args[0]);
			lineReader = openFile(args[0]);
		} else {

			// if the command line argument file was invalid prompt 
			// for a new filename
			input = openFile(promptForFileName());
			lineReader = openFile(promptForFileName());
		}


		// delimit by the ":" or by a new line
		input.useDelimiter(":|\n");

		// continously scan throughout entire file
		// ** each token must be trimmed because there are
		// ** random spaces throughout the file which can
		// ** throw off the input 

		while (input.hasNextLine()){
			// first determine the type of media (song or image)
			String type = input.next().trim();

			// read entire line to display in case of error
			String currentLine = lineReader.nextLine();

			// if media is a song, scan each instance var
			// and create a new song object
			if ( type.equals("S") || type.equals("s")){
				String n = input.next().trim();
				String ar = input.next().trim();
				String al = input.next().trim();
				String si = input.next().trim();

				// create empty song object
				Song s = new Song();

				// attempt to add attributes to the empty song object
				try {
					s.setTitle(s.removeExtension(n));
					s.setArtist(ar);
					s.setAlbum(al);
					s.setSize(Long.parseLong(si));

				// handle errors stemming from invalid attributes of song object
				} catch (NumberFormatException nfe) {

					System.out.println("Invalid input in line: ");
					System.out.println(currentLine + "\n");

					// do not add the object to the arraylist, continue loop
					continue;
				} catch (Error invalidInput) {

					System.out.println("Invalid input in line:");
					System.out.println(currentLine + "\n");

					// do not add the object to the arraylist, continue loop
					continue;
				}

				// check if the song is already in mediaStorage arraylist
				for (DigitalMedia anySong: mediaStorage){
					if (s.equals(anySong)){

						// do not add the duplicate
						// simply continue
						continue;
					}
				}

				// add song to the arraylist storing all media
				mediaStorage.add(s);

			// if media is an image, scan each instance var
			// and create a new image object
			} else if (type.equals("I") || type.equals("i")) {
				String n = input.next().trim();
				String w = input.next().trim();
				String h = input.next().trim();
				String si = input.next().trim();

				// create new empty image object
				Image i = new Image();

				// attempt to add attributes to the empty image object
				try {
					i.setName(n);
					i.setSize(Long.parseLong(si));
					i.setWidth(Integer.parseInt(w));
					i.setHeight(Integer.parseInt(h));
				
				// handle errors stemming from invalid attributes of song object
				} catch (NumberFormatException nfe){

					System.out.println("Invalid input in line: ");
					System.out.println(currentLine + "\n");

					continue;

				} catch (Error invalidInput) {

					System.out.println("Invalid input in line: ");
					System.out.println(currentLine + "\n");

					continue;
				}

				// check if the image is already in mediaStorage arraylist
				for (DigitalMedia anyImage: mediaStorage){
					if (i.equals(anyImage)){

						// do not add the duplicate
						// simply continue
						continue;
					}
				}

				// add image to the arraylist storing all media
				mediaStorage.add(i);
			}


		}
	
		// receive input from keyboard
		Scanner keyIn = new Scanner(System.in);

		// main program loop
		while (exit == false){

			// prompt user for action
			System.out.println("\nSelect from one of the following options by entering the character specified:");
			System.out.println("\tPress S to display a list of all of the songs.");
			System.out.println("\tPress I to display a list of all of the images.");
			System.out.println("\tPres Q to quit the program.\n");

			// receive user input and pass to displayOptions()
			String response = keyIn.next().trim();
			displayOptions(response);
		}
	}
}