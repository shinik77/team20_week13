package com.nts.cleancode.collections;

public abstract class AbstractCollection {
	private static int INITIAL_CAPACITY = 10;
	protected Object[] elements = new Object[INITIAL_CAPACITY];
	protected int size = 0;
    protected boolean readOnly;
    
	public void addAll(AbstractCollection collection) {
		for (int i=0; i < collection.size(); i++) {
			if (!contains(collection.get(i))) {
				add(collection.get(i));
			}
		}
	}

	public boolean isEmpty()
	{
    	return size == 0;
	}
	protected void addElement(Object element) {
        elements[size++] = element;
    }
	public void add(Object element)
	{
		if (readOnly)
    	    return;
    	
    	if (shouldGrow()) {
    	    grow();
    	}
    	
    	addElement(element);
	}
	protected boolean shouldGrow() {
        return size + 1 > elements.length;
    }
	protected void grow() {
        Object[] newElements =
                new Object[elements.length + INITIAL_CAPACITY];
        for (int i = 0; i < size; i++)
            newElements[i] = elements[i];
        elements = newElements;
    }
	public boolean remove(Object element)
	{
		if (readOnly)
    		return false;
    	else 	
    		for (int i = 0; i < size; i++)
    			if (elements[i].equals(element)) {
    				removeElementAt(i);
    				return true;
    			}
    	return false;
	}
	protected void removeElementAt(int i) {
        elements[i] = null;
        Object[] newElements = new Object[size - 1];
        int k = 0;
        for (int j = 0; j < size; j++) {
        	if (elements[j] != null)
        		newElements[k++] = elements[j];
        }
        size--;
        elements = newElements;
    }
	public boolean contains(Object element)
	{
		for (int i=0; i<size; i++) 
    		if (elements[i].equals(element))
    			return true;
    	return false;
	}
	public Object getElementAt(int index) {
    	return elements[index];
    }
	public int size()
	{
		return size;
	}

	public Object get(int i) {
		return elements[i];
	}
	public int capacity() {
    	return elements.length;
    }
	public void setReadOnly(boolean b) {
    	readOnly = b;
    }
}
