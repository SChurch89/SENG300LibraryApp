package LibraryDesktopApp;

public class Book {
	private int book_id;
	private int goodreads_book_id;
	private int best_book_id;
	private int work_id;
	private int books_count;
	private String isbn;
	private String isbn13;
	private float original_publication_year;
	private String original_title;
	private String title;
	private String language_code;
	private float average_rating;
	private int ratings_count;
	private int work_ratings_count;
	private int work_text_reviews_count;
	private int ratings_1;
	private int ratings_2;
	private int ratings_3;
	private int ratings_4;
	private int ratings_5;
	private String image_url;
	private String small_image_url;
	private String authors;
	
	public Book(int book_id, int goodreads_book_id, int best_book_id, int work_id, int books_count, String isbn, String isbn13, float original_publication_year, String original_title, String title, String language_code, float average_rating, int ratings_count, int work_ratings_count, int work_text_reviews_count, int ratings_1, int ratings_2, int ratings_3, int ratings_4, int ratings_5, String image_url, String small_image_url, String authors) {
		this.book_id = book_id;
		this.goodreads_book_id = goodreads_book_id;
		this.best_book_id = best_book_id;
		this.work_id = work_id;
		this.books_count = books_count;
		this.isbn = isbn;
		this.isbn13 = isbn13;
		this.authors = authors;
		this.original_publication_year = original_publication_year;
		this.original_title = original_title;
		this.title = title;
		this.language_code = language_code;
		this.average_rating = average_rating;
		this.ratings_count = ratings_count;
		this.work_ratings_count = work_ratings_count;
		this.work_text_reviews_count = work_text_reviews_count;
		this.ratings_1 = ratings_1;
		this.ratings_2 = ratings_2;
		this.ratings_3 = ratings_3;
		this.ratings_4 = ratings_4;
		this.ratings_5 = ratings_5;
		this.image_url = image_url;
		this.small_image_url = small_image_url;
	}
	
	public Book() { }
	
	public int get_book_id() {
		return book_id;
	}
	
	public int get_goodreads_book_id() {
		return goodreads_book_id;
	}
	
	public int get_best_book_id() {
		return best_book_id;
	}
	
	public int get_work_id() {
		return work_id;
	}
	
	public int get_books_count() {
		return books_count;
	}
	
	public String get_isbn() {
		return isbn;
	}
	
	public String get_isbn13() {
		return isbn13;
	}
	
	public String get_authors() {
		return authors;
	}
	
	public float get_original_publication_year() {
		return original_publication_year;
	}
	
	public String get_original_title() {
		return original_title;
	}
	
	public String get_title() {
		return title;
	}
	
	public String get_language_code() {
		return language_code;
	}
	
	public float get_average_rating() {
		return average_rating;
	}
	
	public int get_ratings_count() {
		return ratings_count;
	}
	
	public int get_work_ratings_count() {
		return work_ratings_count;
	}
	
	public int get_work_text_reviews_count() {
		return work_text_reviews_count;
	}
	
	public int get_ratings_1() {
		return ratings_1;
	}
	
	public int get_ratings_2() {
		return ratings_2;
	}
	
	public int get_ratings_3() {
		return ratings_3;
	}
	
	public int get_ratings_4() {
		return ratings_4;
	}
	
	public int get_ratings_5() {
		return ratings_5;
	}
	
	public String get_image_url() {
		return image_url;
	}
	
	public String get_small_image_url() {
		return small_image_url;
	}
	
	public void set_book_id(int book_id) {
		this.book_id = book_id;
	}
	
	public void set_goodreads_book_id(int goodreads_book_id) {
		this.goodreads_book_id = goodreads_book_id;
	}
	
	public void set_best_book_id(int best_book_id) {
		this.best_book_id = best_book_id;
	}
	
	public void set_work_id(int work_id) {
		this.work_id = work_id;
	}
	
	public void set_books_count(int books_count) {
		this.books_count = books_count;
	}
	
	public void set_isbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void set_isbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
	public void set_authors(String authors) {
		this.authors = authors;
	}
	
	public void set_original_publication_year(float original_publication_year) {
		this.original_publication_year = original_publication_year;
	}
	
	public void set_original_title(String original_title) {
		this.original_title = original_title;
	}
	
	public void set_title(String title) {
		this.title = title;
	}
	
	public void set_language_code(String language_code) {
		this.language_code = language_code;
	}
	
	public void set_average_rating(float average_rating) {
		this.average_rating = average_rating;
	}
	
	public void set_ratings_count(int ratings_count) {
		this.ratings_count = ratings_count;
	}
	
	public void set_work_ratings_count(int work_ratings_count) {
		this.work_ratings_count = work_ratings_count;
	}
	
	public void set_work_text_reviews_count(int work_text_reviews_count) {
		this.work_text_reviews_count = work_text_reviews_count;
	}
	
	public void set_ratings_1(int ratings_1) {
		this.ratings_1 = ratings_1;
	}
	
	public void set_ratings_2(int ratings_2) {
		this.ratings_2 = ratings_2;
	}
	
	public void set_ratings_3(int ratings_3) {
		this.ratings_3 = ratings_3;
	}
	
	public void set_ratings_4(int ratings_4) {
		this.ratings_4 = ratings_4;
	}
	
	public void set_ratings_5(int ratings_5) {
		this.ratings_5 = ratings_5;
	}
	
	public void set_image_url(String image_url) {
		this.image_url = image_url;
	}
	
	public void set_small_image_url(String small_image_url) {
		this.small_image_url = small_image_url;
	}
	
	public String toString() {
		return String.format("%s, by %s, is id %s and rated %s", title, authors, book_id, average_rating);
	}
}
