package com.nts.cleancode.collections;

public class Map {
	private static int INITIAL_CAPACITY = 10;
	protected Object[] keys = new Object[INITIAL_CAPACITY];
	protected Object[] values = new Object[INITIAL_CAPACITY];
	private int indexWhereKeyFound;
	private int size = 0;
	private boolean readOnly;

	public boolean isEmpty() {
		return size == 0;
	}
	public void addAll(Map m){
		for (int i=0; i<m.size(); i++) 
			add(m.keys[i], m.values[i]);	
	}
	public void add(Object key, Object value) {
		if (!readOnly) {
			for (int i = 0; i < size; i++)
                if (keys[i].equals(key)) {
                    values[i] = value;
                    return;
                }
			int newSize = size + 1;
			if (newSize > keys.length) {
				Object[] newKeys =
					new Object[keys.length + INITIAL_CAPACITY];
				Object[] newValues = new Object[keys.length + INITIAL_CAPACITY];
				System.arraycopy(keys, 0, newKeys, 0, size);
                System.arraycopy(values, 0, newValues, 0, size);
                keys = newKeys;
                values = newValues;
			}

			keys[size] = key;
            values[size] = value;
            size++;
		}
	}

	public boolean contains(Object value) {
		for (int i = 0; i < size; i++)
			if ((value == null && values[i] == null) || (values[i] != null && values[i].equals(value))){
				indexWhereKeyFound = i;
				return true;
			}
		return false;
	}

	public int size() {
		return size;
	}

	public boolean remove(Object key) {
		if (readOnly)
			return false;
		for (int i = 0; i < size; i++)
			if (keys[i].equals(key)) {
				keys[i] = null;
				values[i]=null;
				size--;
				return true;
			}
		return false;
	}
	public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++)
            if (keys[i] != null && keys[i].equals(key)) {
                indexWhereKeyFound = i;
                return true;
            }
        return false;
    }
	public Object get(Object key) {
        if (!containsKey(key))
            return null;
        return values[indexWhereKeyFound];
    }


	public int capacity() {
		return keys.length;
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}
}
