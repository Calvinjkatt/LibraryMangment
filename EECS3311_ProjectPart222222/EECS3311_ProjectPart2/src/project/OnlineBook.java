package project;

import java.time.LocalDate;

public class OnlineBook 
{
	String onlineBookName;
	LocalDate courseEndDate;
	
	public OnlineBook(String onlineBookName)
	{
		this.onlineBookName = onlineBookName;
	}
	
	public void setCourseEndDate(LocalDate endDate)
	{
		this.courseEndDate = endDate;
	}
	
	public LocalDate getCourseEndDate()
	{
		return courseEndDate;
	}
	
	public String openOnlineBook(String bookName)
	{
		return "Online book " + bookName + " is open";
	}
}
