import java.util.ArrayList;

public class Library {
	
	public ArrayList<Book> books = new ArrayList<Book>();
	static String openHours = "Libraries are open daily from 9am to 5pm.";
	public String libraryAddress;

	public Library(String address){
		libraryAddress = address;
	}

	public void addBook(Book book){
		books.add(book);
	}

	static void printOpeningHours(){
		System.out.println(openHours);
	}

	public void printAddress(){
		System.out.println(libraryAddress);
	}

	public void borrowBook(String book){
		for (Book item : books){
			if (item.title.equals(book)){
				if (item.isBorrowed()){
					System.out.println("Sorry, this book is already borrowed.");
				} else {
					System.out.println("You successfully borrowed The Lord of the Rings.");
					item.borrowed();
				}
			}
		}
	}

	public void printAvailableBooks(){
		if (books.isEmpty()){
			System.out.println("No book in catalog");
		} else {
			for (Book item : books){
				if(item.borrowed == false){
					System.out.println(item.title);
				}
			}
		}
	}

	public void returnBook(String book){
		for (Book item : books){
			if(item.title == book){
				item.returned();
				System.out.println("You successfully returned " + item.title);
			}
		}
	}

public static void main(String[] args) {
	// Create two libraries
	Library firstLibrary = new Library("10 Main St.");
	Library secondLibrary = new Library("228 Liberty St.");
	
	// Add four books to the first library
	firstLibrary.addBook(new Book("The Da Vinci Code"));
	firstLibrary.addBook(new Book("Le Petit Prince"));
	firstLibrary.addBook(new Book("A Tale of Two Cities"));
	firstLibrary.addBook(new Book("The Lord of the Rings"));

// TEST 2 System.out.println(firstLibrary.books);

	// Print opening hours and the addresses
	System.out.println("Library hours:");
	printOpeningHours();
	System.out.println();
	System.out.println("Library addresses:");
	firstLibrary.printAddress();
	secondLibrary.printAddress();
	System.out.println();
	
	// Try to borrow The Lords of the Rings from both libraries
	System.out.println("Borrowing The Lord of the Rings:");
	firstLibrary.borrowBook("The Lord of the Rings");
	firstLibrary.borrowBook("The Lord of the Rings");
	secondLibrary.borrowBook("The Lord of the Rings");
	System.out.println();

	// Print the titles of all available books from both libraries
	System.out.println("Books available in the first library:");
	firstLibrary.printAvailableBooks();
	System.out.println();
	System.out.println("Books available in the second library:");
	secondLibrary.printAvailableBooks();
	System.out.println();

	// Return The Lords of the Rings to the first library
	System.out.println("Returning The Lord of the Rings:");
	firstLibrary.returnBook("The Lord of the Rings");
	System.out.println();

	// // Print the titles of available from the first library
	System.out.println("Books available in the first library:");
	firstLibrary.printAvailableBooks();
}
} 