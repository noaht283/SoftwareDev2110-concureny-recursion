mport java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Homework 6 Card Creator
 * 
 * This class defines the thread task that will "come up with" and submit
 * greeting card ideas to the print queue. We have added the code necessary to
 * read from the file, but it's up to you to handle turning off the printer
 * (keeping track of how many threads are open) and adding the read-in line from
 * the inspiration file to the queue.
 * 
 * @author
 *
 */
public class CardCreator implements Runnable {

	/**
	 * Print queue to add new card ideas
	 */
	private PrintQueue printQueue;

	public int threadCount = 0;

	/**
	 * Inspiration file name
	 */
	private String filename;

	public CardCreator(PrintQueue d, String filename) {
		printQueue = d;
		this.filename = filename;
	}

	/**
	 * Run method that is the main method for the thread
	 */
	@Override
	public void run() {
		Scanner s = null;
		threadCount++;
		try {
			s = new Scanner(new FileReader(filename));
			while (s.hasNextLine()) {
				this.printQueue.enqueue(s.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Could not read file");
		} finally {
			if (s.hasNextLine() == false && threadCount == 0) {
				s.close();
				printQueue.turnOff();
			}
		}

	}

}
