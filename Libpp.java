package LibraryDesktopApp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Libpp {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=191,9
	 */
	private JTextField isbnField;
	private JTextField bookIdField;
	
	private JLabel bookLabel;
	private JLabel[] bookList;
	private static boolean typeArrayList;
	private static List<Book> books;
	
	private JLabel lblTitle;
	private JLabel lblAuthors;
	private JLabel lblRatings;
	private JLabel lblISBN;
	private JLabel lblBookCount;
	private JRadioButton rbAscending;
	private JRadioButton rbDecending;
	
	public static void main(String[] args) {
		typeArrayList = true;
		
		if (typeArrayList) {
			books = new ArrayList<Book>();
		} else {
			books = new LinkedList<Book>();
		}
		
		books = readFromFile(books);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Libpp window = new Libpp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Libpp() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setSize(900, 750);
		frame.setVisible(true);
		
		JButton btnSortAuthor = new JButton("Sort by Author");
		btnSortAuthor.setBounds(30, 280, 200, 30);
		btnSortAuthor.addActionListener(e -> {
			if (rbAscending.isSelected()) {
				books.sort((d1, d2) -> {
					return d1.get_authors().compareTo(d2.get_authors());
				});
			} else {
				books.sort((d1, d2) -> {
					return d2.get_authors().compareTo(d1.get_authors());
				});
			}
			displayBookList();
		});
		frame.getContentPane().add(btnSortAuthor);
		
		JButton btnSortPublicationYear = new JButton("Sort by Publication Year");
		btnSortPublicationYear.setBounds(30, 320, 200, 30);
		btnSortPublicationYear.addActionListener(e -> {
			if (rbAscending.isSelected()) {
				books.sort((d1, d2) -> {
					return (int) (d1.get_original_publication_year() - d2.get_original_publication_year());
				});
			} else {
				books.sort((d1, d2) -> {
					return (int) (d2.get_original_publication_year() - d1.get_original_publication_year());
				});
			}
			displayBookList();
		});
		frame.getContentPane().add(btnSortPublicationYear);
		
		rbAscending = new JRadioButton("Ascending Order");
		rbAscending.setBounds(250, 280, 200, 30);
		rbAscending.setSelected(true);
		frame.getContentPane().add(rbAscending);
		
		rbDecending = new JRadioButton("Decending Order");
		rbDecending.setBounds(250, 310, 200, 30);
		frame.getContentPane().add(rbDecending);
		
		ButtonGroup order = new ButtonGroup();
		order.add(rbAscending);
		order.add(rbDecending);
		
		bookLabel = new JLabel("Top Ten Results: ");
		bookLabel.setBounds(30, 360, 200, 20);
		frame.getContentPane().add(bookLabel);
		
		bookList = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			bookList[i] = new JLabel();
			bookList[i].setBounds(40, 20 * i + 380, 600, 20);
			frame.getContentPane().add(bookList[i]);
		}
		displayBookList();
		
		lblTitle = new JLabel();
		lblTitle.setBounds(400, 40, 300, 20);
		frame.getContentPane().add(lblTitle);
		
		lblAuthors = new JLabel();
		lblAuthors.setBounds(400, 70, 300, 20);
		frame.getContentPane().add(lblAuthors);
		
		lblISBN = new JLabel();
		lblISBN.setBounds(400, 100, 200, 20);
		frame.getContentPane().add(lblISBN);
		
		lblRatings = new JLabel();
		lblRatings.setBounds(400, 130, 200, 20);
		frame.getContentPane().add(lblRatings);
		
		lblBookCount = new JLabel();
		lblBookCount.setBounds(400, 160, 200, 20);
		frame.getContentPane().add(lblBookCount);
		
		JButton btnAddNew = new JButton("Add New book");
		btnAddNew.addActionListener(e -> {
				System.out.println("Added new book");
		});
		btnAddNew.setBounds(23, 159, 116, 23);
		frame.getContentPane().add(btnAddNew);
		
		JButton btnEdit = new JButton("Edit Book");
		btnEdit.setBounds(23, 193, 116, 23);
		frame.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete Book\r\n");
		btnDelete.setBounds(23, 227, 116, 23);
		frame.getContentPane().add(btnDelete);
		
		isbnField = new JTextField();
		isbnField.setBounds(122, 53, 157, 20);
		frame.getContentPane().add(isbnField);
		isbnField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Search ISBN");
		lblNewLabel.setLabelFor(isbnField);
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setBounds(23, 53, 81, 23);
		frame.getContentPane().add(lblNewLabel);
		
		bookIdField = new JTextField();
		bookIdField.setColumns(10);
		bookIdField.setBounds(122, 84, 157, 20);
		frame.getContentPane().add(bookIdField);
		
		JLabel lblSearchBookId = new JLabel("Search Book ID");
		lblSearchBookId.setBackground(Color.YELLOW);
		lblSearchBookId.setBounds(23, 84, 91, 23);
		frame.getContentPane().add(lblSearchBookId);
		
		JButton btnISBN = new JButton("Enter");
		btnISBN.setBounds(291, 52, 89, 23);
		btnISBN.addActionListener(e -> {
			int i = -1;
			if (typeArrayList) {
				books.sort((d1, d2) -> {
					return d1.get_isbn().compareTo(d2.get_isbn());
				});
				i = binarySearch(books, isbnField.getText());
			} else {
				i = linearSearch(books, isbnField.getText());
			}
			
			if (i == -1) {
				displayError("ISBN does not exist");
			} else {
				displayBookInfo(books.get(i));
			}
		});
		frame.getContentPane().add(btnISBN);
		
		JButton btnBookId = new JButton("Enter");
		btnBookId.setBounds(291, 83, 89, 23);
		btnBookId.addActionListener(e -> {
			int i = -1;
			try {
				if (typeArrayList) {
					books.sort((d1, d2) -> {
						return d1.get_book_id() - d2.get_book_id();
					});
					i = binarySearch(books, Integer.parseInt(bookIdField.getText()));
				} else {
					i = linearSearch(books, Integer.parseInt(bookIdField.getText()));
				}
				
				if (i == -1) {
					displayError("ID does not exist");
				} else {
					displayBookInfo(books.get(i));
				}
			} catch (NumberFormatException exception) {
				displayError("Invalid Format. Use only whole numbers");
			}
		});
		frame.getContentPane().add(btnBookId);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		performanceTest();
	}
	
	private static List<Book> readFromFile(List<Book> books) {
		try {
			File bookFile = new File("books.csv");
		    Scanner myReader = new Scanner(bookFile);
		    myReader.nextLine();
		    while (myReader.hasNextLine()) {
		    	String[] bookInfo = myReader.nextLine().split(",", 23);
		    	Book book = new Book();
		    	book.set_book_id(Integer.parseInt(bookInfo[0]));
		    	book.set_goodreads_book_id(Integer.parseInt(bookInfo[1]));
		    	book.set_best_book_id(Integer.parseInt(bookInfo[2]));
		    	book.set_work_id(Integer.parseInt(bookInfo[3]));
		    	book.set_books_count(Integer.parseInt(bookInfo[4]));
		    	book.set_isbn(bookInfo[5]);
		    	book.set_isbn13(bookInfo[6]);
		    	try { book.set_original_publication_year(Float.parseFloat(bookInfo[7])); } catch (NumberFormatException e) { book.set_original_publication_year(0000); }
		    	book.set_original_title(bookInfo[8]);
		    	book.set_title(bookInfo[9]);
		    	book.set_language_code(bookInfo[10]);
		    	book.set_average_rating(Float.parseFloat(bookInfo[11]));
		    	book.set_ratings_count(Integer.parseInt(bookInfo[12]));
		    	book.set_work_ratings_count(Integer.parseInt(bookInfo[13]));
		    	book.set_work_text_reviews_count(Integer.parseInt(bookInfo[14]));
		    	book.set_ratings_1(Integer.parseInt(bookInfo[15]));
		    	book.set_ratings_2(Integer.parseInt(bookInfo[16]));
		    	book.set_ratings_3(Integer.parseInt(bookInfo[17]));
		    	book.set_ratings_4(Integer.parseInt(bookInfo[18]));
		    	book.set_ratings_5(Integer.parseInt(bookInfo[19]));
		    	book.set_image_url(bookInfo[20]);
		    	book.set_small_image_url(bookInfo[21]);
		    	book.set_authors(bookInfo[22]);
		    	books.add(book);
		    }
		    myReader.close();
		} catch (FileNotFoundException e) {
		   	System.out.println("Could not find the file.");
	    	e.printStackTrace();
	    }
		return books;
	}
	
	private void displayBookList() {		
		for (int i = 0; i < 10; i++) {
			bookList[i].setText(String.format("%s  -  %s  -  %s", books.get(i).get_book_id(), books.get(i).get_title(), books.get(i).get_isbn()));
			frame.repaint();
		}
	}
	
	private void displayBookInfo(Book book) {
		lblTitle.setText(book.get_title());
		lblAuthors.setText("Written by " + book.get_authors());
		lblISBN.setText("ISBN: " + book.get_isbn());
		lblRatings.setText("Average Rating: " + book.get_average_rating());
		lblBookCount.setText("Number currently available: " + book.get_books_count());
		frame.repaint();
	}
	
	private void displayError(String msg) {
		lblTitle.setText(msg);
		lblAuthors.setText(null);
		lblISBN.setText(null);
		lblRatings.setText(null);
		lblBookCount.setText(null);
		frame.repaint();
	}
	
	private int binarySearch(List<Book> books, String givenISBN)
    {
        int l = 0, r = books.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            int res = givenISBN.compareTo(books.get(m).get_isbn());
 
            if (res == 0) {
                return m;
            }
 
            if (res > 0) {
                l = m + 1;
            } else {
                r = m - 1;
        	}
        }
 
        return -1;
    }
    
    private int binarySearch(List<Book> books, int givenID)
    {
        int l = 0, r = books.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            int id = books.get(m).get_book_id();

            if (givenID == id) {
                return m;
            }
            
            if (givenID > id) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
    
    private int linearSearch(List<Book> books, String givenISBN) {
    	for (int i = 0; i < books.size(); i++) {
    		if (books.get(i).get_isbn().equals(givenISBN)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    private int linearSearch(List<Book> books, int givenID) {
    	for (int i = 0; i < books.size(); i++) {
    		if (books.get(i).get_book_id() == givenID) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public void performanceTest() {
    	new Thread(() -> {   
    		System.out.println("Performance Test: ... ");
    		
	    	//create the same list of 2 different types
	    	List<Book> bookArray = new ArrayList<Book>();
	    	List<Book> bookLinked = new LinkedList<Book>();
	
	    	bookArray = readFromFile(bookArray);
	    	bookLinked = readFromFile(bookLinked);
	    	
	    	//sort them by something other than id so neither has an advantage
	    	bookArray.sort((d1, d2) -> {
				return d1.get_authors().compareTo(d2.get_authors());
			});
	    	bookLinked.sort((d1, d2) -> {
				return d1.get_authors().compareTo(d2.get_authors());
			});
	    	
	    	int numSearchValues = 500;
	    	
	    	long startTime = System.currentTimeMillis();
	    	for (int i = 0; i < numSearchValues; i++) {
	    		binarySearch(bookArray, i);
	    	}
			long endTime = System.currentTimeMillis();
			long processTime = endTime - startTime;
	    	
	    	long startTime2 = System.currentTimeMillis();
	    	for (int i = 0; i < numSearchValues; i++) {
	    		linearSearch(bookLinked, i);
	    	}
			long endTime2 = System.currentTimeMillis();
			long processTime2 = endTime2 - startTime2;

			System.out.format("Binary Search on ArrayList: %sms\nLinear Search on LinkedList: %sms", processTime, processTime2);
    	}).start();
    }
}
