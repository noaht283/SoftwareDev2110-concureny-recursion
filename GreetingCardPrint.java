public class GreetingCardPrinter {

	public static void main(String[] args) {
		// Create a shared print queue
		PrintQueue d = new PrintQueue();
		
		// Create two card creators that will imagine their
		// ideas by reading the prompts from birthday.txt
		// and roses.txt.  (I.e. a little hard-coded
		// inspiration!)
		CardCreator r1 = new CardCreator(d, "birthday.txt");
		CardCreator r2 = new CardCreator(d, "roses.txt");
		
		// Printer will try to print the cards by checking the
		// print queue.
		Printer r3 = new Printer(d, 1000);
		Printer r4 = new Printer(d, 1000);
		
		
		// Create new threads to run each of the Runnables
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);
		
		// Start the threads
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
