import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
 
import javax.swing.*;
import net.proteanit.sql.DbUtils;
 
public class main { 
   public static void main(String[] args) {
		List<Book> books;
		books = readBooks();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Libpp window = new Libpp(books);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static List<Book> readBooks() {
		List<Book> books = new ArrayList<Book>();
		//List<Book> books = new LinkedList<Book>();
		try {
			File bookFile = new File("books.csv");
		    Scanner myReader = new Scanner(bookFile);
		    myReader.nextLine();
		    while (myReader.hasNextLine()) {		        
		    	String[] bookInfo = myReader.nextLine().split(",", 23);
		    	books.add(new Book(Integer.parseInt(bookInfo[0]), Integer.parseInt(bookInfo[1]), Integer.parseInt(bookInfo[2]), Integer.parseInt(bookInfo[3]), Integer.parseInt(bookInfo[4]), bookInfo[5], bookInfo[6], Float.parseFloat(bookInfo[7]), bookInfo[8], bookInfo[9], bookInfo[10], Float.parseFloat(bookInfo[11]), Integer.parseInt(bookInfo[12]), Integer.parseInt(bookInfo[13]), Integer.parseInt(bookInfo[14]), Integer.parseInt(bookInfo[15]), Integer.parseInt(bookInfo[16]), Integer.parseInt(bookInfo[17]), Integer.parseInt(bookInfo[18]), Integer.parseInt(bookInfo[19]), bookInfo[20], bookInfo[21], bookInfo[22]));
		    }
		    myReader.close();
		} catch (FileNotFoundException e) {
		   	System.out.println("Could not find the file.");
	    	e.printStackTrace();
	    }
		
		return books;
	}
}
