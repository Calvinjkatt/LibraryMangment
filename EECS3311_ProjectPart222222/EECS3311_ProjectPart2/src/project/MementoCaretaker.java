package project;

import java.util.ArrayList;

public class MementoCaretaker 
{
	ArrayList<Memento> savedItems = new ArrayList<Memento>();
	
	public void addMemento(Memento m)
	{
		savedItems.add(m);
	}
	
	public Memento getMemento(int index)
	{
		return savedItems.get(index);
	}
}
