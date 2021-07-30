import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Homework 6 PrintQueue
 * 
 * Implement the class below as specified in the homework 6 document.
 * 
 * @author
 *
 */

// Don't forget to include the appropriate import statements

public class PrintQueue {

	private LinkedList<String> toPrint; // the printer's list
	private Lock documentChangeLock; // a ReentrantLock
	private Condition hasPrintTask; // a condition object
	private boolean isOn; // boolean variable
							// queue is on (accepting jobs)

	// TODO: Handle locking and conditions around the
	// enqueueing and dequeuing of documents
	// PrintQueue's document list (toPrint)
	// Note: See the BetterBestBank example in Bank.zip
	// or in zip folder 'Thread Example 6 - Bank Deadlock'
	// on Collab.
	// Bank.zip: http://tinyurl.com/cs2110bank

	/**
	 * Constructor
	 */
	public PrintQueue() {
		toPrint = new LinkedList<String>();
		isOn = true;
		documentChangeLock = new ReentrantLock();
		hasPrintTask = documentChangeLock.newCondition();
	}

	/**
	 * enqueue TODO: Write more comments
	 */
	public void enqueue(String s) {
		documentChangeLock.lock();
		try {
			this.toPrint.add(s);
		} finally {
			hasPrintTask.signalAll();
			documentChangeLock.unlock();
		}
	}

	/**
	 * dequeue TODO: Write more comments
	 */
	public String dequeue() {
		documentChangeLock.lock();
		try {
			while (toPrint.isEmpty() == true) {
				hasPrintTask.await();
			}
		} catch (InterruptedException e) {

		} finally {
			documentChangeLock.unlock();
		}
		return toPrint.remove();
	}

	public void turnOff() {
		this.isOn = false;
	}

	public boolean isOn() {
		if (this.isOn == true) {
			return true;
		} else {
			return false;
		}
	}
