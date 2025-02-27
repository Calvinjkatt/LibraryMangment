package project;

public class Book extends PhysicalItem
{
	public int textbookEdition;
	private BookSearch bookSearch;
	
	protected Book(String name, String location, BookSearch bookSearch) 
	{
		super(name, location);
		this.bookSearch = bookSearch;
		this.bookSearch.addBook(this);
	}
	
	public String getName()
	{
		return name;
	}
	
}
