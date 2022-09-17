package LibraryDesktopApp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
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
	private List<Book> books;
	
	private JLabel title;
	private JLabel authors;
	private JLabel ratings;
	private JLabel isbn;
	private JLabel books_count;

	/**
	 * Create the application.
	 */
	public Libpp(List<Book> books) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		this.books = books;
		
		displayBookList();
		
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
			for (Book book: books) {
				System.out.println(book.get_isbn() + "  -  " + isbnField.getText());
				if (book.get_isbn() == isbnField.getText()) {
					displayBookInfo(book);
					System.out.println(book.get_isbn() + "  -  " + isbnField.getText());
					break;
				}
			}
			
		});
		frame.getContentPane().add(btnISBN);
		
		JButton btnBookId = new JButton("Enter");
		btnBookId.setBounds(291, 83, 89, 23);
		frame.getContentPane().add(btnBookId);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void displayBookList() {
		bookLabel = new JLabel("Top Ten Results: ");
		bookLabel.setBounds(30, 290, 200, 20);
		frame.getContentPane().add(bookLabel);
		
		bookList = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			bookList[i] = new JLabel(String.format("%s  -  %s", books.get(i).get_isbn(), books.get(i).get_title()));
			bookList[i].setBounds(40, 20 * i + 310, 400, 20);
			frame.getContentPane().add(bookList[i]);
		}
	}
	
	private void displayBookInfo(Book book) {
		title = new JLabel(book.get_title());
		title.setBounds(400, 40, 300, 20);
		frame.getContentPane().add(title);
		
		authors = new JLabel("Written by " + book.get_authors());
		authors.setBounds(400, 70, 300, 20);
		frame.getContentPane().add(authors);
		
		isbn = new JLabel("ISBN: " + book.get_isbn());
		isbn.setBounds(400, 100, 200, 20);
		frame.getContentPane().add(isbn);
		
		ratings = new JLabel("Average Rating: " + book.get_average_rating());
		ratings.setBounds(400, 130, 200, 20);
		frame.getContentPane().add(ratings);
		
		books_count = new JLabel("Number currently available: " + book.get_books_count());
		books_count.setBounds(400, 160, 200, 20);
		frame.getContentPane().add(books_count);
		frame.repaint();
	}
}
