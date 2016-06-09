package com.nts.cleancode.collections;

public abstract class AbstractCollection{
	public void addAll(AbstractCollection c) {	
		if (c instanceof Set) {
			Set s = (Set)c;		
		}
	}
	public abstract boolean isEmpty();
	public abstract boolean remove(Object element);
	public abstract boolean contains(Object element);
	public abstract int size();	
	
	public void add(Object key, Object value) {
	}
}
