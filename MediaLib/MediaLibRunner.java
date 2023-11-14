/*************************************
 * Activity 2.5.7
 *  
 * The runner for the MediaLibrary program
 *  
 * Rohan Vij & Shrey Valia
 **************************************/
public class MediaLibRunner
{
  public static void main(String[] args)
  {
	System.out.println("Welcome to your Media Library");
	MediaLib myLib = new MediaLib();
 
	// Steps 1-6
	Book myBook = new Book("The Lord of the Rings", "Tolkien");
	System.out.println("Book created " + myBook);
	System.out.println("Library:\n" + myLib);
	myLib.addBook(myBook);
	System.out.println("Library:\n" + myLib);
 
	// Steps 8 - 9
	int myRating = 5;
	myBook.adjustRating(myRating);
	System.out.println(myBook);
	System.out.println("myRating=" + myRating);
	 
	// Steps 10
	myBook.adjustRating(15);
	System.out.println(myBook);
	myBook.adjustRating(-10);
	System.out.println(myBook);
	 
	// Steps 12-14
	System.out.println("Book changed!");
	myBook.setTitle("Fellowship of the Ring");
	myBook.adjustRating(5); // or myBook.setAuthor("JRR Tolkien");
	System.out.println("Book:" + myBook);
	System.out.println("Library: " + myLib);
  	 
	// Steps 15-17
	System.out.println("You have a NEW Library");
	MediaLib myLib2 = new MediaLib();
 
	Book newBook = new Book("To Kill a Mockingbird", "Lee");
	myLib2.addBook(newBook);
	System.out.println(myLib2);
	newBook = new Book("1984", "Orwell");
	System.out.println(myLib2);
	 
	 
	// new step 18 - 22
	/* test scenario
	System.out.println("before test " + newBook);
	myLib.testBook(newBook);
	System.out.println("after test" + newBook);
	*/
	 
	// Steps 25
	Book newBook2 = new Book("1984", "Orwell");
	System.out.println(newBook2 + " equal " + newBook + "? "  + newBook2.equals(newBook));
	newBook2.setAuthor("George Orwell");
	System.out.println(newBook2 + " equal " + newBook + "? "  + newBook2.equals(newBook));
 
	// Step 27 - 28
	// this statement will not compile: System.out.println(newBook2.title);   
 
  }
}

