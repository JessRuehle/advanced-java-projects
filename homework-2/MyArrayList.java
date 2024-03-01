package edu.bloomu.homework2;

/**
 * Creates an ArrayList that allows user to add, remove and manipulate
 * objects in the list.
 * @author Jessica Ruehle
 */
public class MyArrayList {

    // Object array field and a counter to keep track of how many
    // objects are in the list
    private Object[] list;
    private int elementCount = 0;

    // default constructor
    public MyArrayList() 
    {
        this(5);
    }

    /**
     * Constructor that allows user to decide length of array list
     * @param length the length of the array list to start.
     */
    public MyArrayList(int length) 
    {
        list = new Object[length];
    }

    /** 
     * Appends the specified element to the end of this list
     * @param e the element to be added to the list.
     */
    public void add(Object e) 
    {
        // first, check the length of the list. If it is the same length
        // as the number of elements in it, it needs to be doubled in size.
        if (list.length == elementCount) 
        {
            // creating an array that is double the size of the last one.
            Object[] doubleSize = new Object[elementCount * 2];
            for (int i = 0; i < list.length; i++) 
            {
                doubleSize[i] = list[i];
            }
            list = doubleSize;
            
        }
        // adding the element to the list and updating the counter
        list[elementCount + 1] = e;
        elementCount++;
    }

    /**
    * Inserts the element at the specified position in this list
    * @param index the index for the new element to be inserted into
    * @param element the object to be added to the list
    * @throws IndexOutOfBoundsException
    */
    public void addFrom(int index, Object element) throws 
            IndexOutOfBoundsException
    {
        // if the index is out of bounds it will throw an exception
        if (index > elementCount || index < 0) 
        {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        // if the array is the same size as the number of elements in it,
        // it is doubled in size
        if (list.length == elementCount) 
        {
            Object[] doubleSize = new Object[elementCount * 2];
            for (int i = 0; i < index; i++) 
            {
                doubleSize[i] = list[i];
            }
            doubleSize[index] = element;
            for (int i = index + 1; i < list.length; i++) 
            {
                doubleSize[i] = list[i];
            }
            list = doubleSize;
        } 
        // if the array is smaller than the number of elements in it,
        // the element can just be added at the corresponding index and 
        // the other elements are moved back by one
        else 
        {
            list[index] = element;
            for (int i = index + 1; i < list.length; i++) 
            {
                list[i] = list[i + 1];
            }
        }
        // update the number of elements
        elementCount++;
    }

    /**
     * Removes all the elements from this list.
     * @throws IndexOutOfBoundsException 
     */
    public void clear() throws IndexOutOfBoundsException{
        // iterates through the array and sets all values to null
        for (int i = 0; i < elementCount; i++) 
        {
            list[i] = null;
        }
        // resets counter to 0
        elementCount = 0;
    }

    /**
     * Returns true if this list contains the specified element
     * @param o object to be searched for in list.
     * @return true if the object is present in the list
     */
    public boolean contains(Object o) {
        // iterate through the array to search for the element the user is
        // looking for
        for (int i = 0; i < elementCount; i++) 
        {
            if (list[i] == o) 
            {
                return true; // return true if it is found
            }
        }
        return false; // return false if not found
    }

    // Returns the element at the specified position in this list
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index > elementCount || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return list[index];
    }

    /**
     * Returns the index of the first occurrence of the specified 
     * element in this list or -1 if this list does not contain the element
     * @param o the object to be searched for
     * @return the index the object is at.
     */
    public int indexOf(Object o) {
        
        //iterate through the array to search for object
        for (int i = 0; i < elementCount; i++) 
        {
            // return the index if it is found
            if(list[i].equals(o)) 
            {
                return i;
            }
        }
        // return -1 if object is not found
        return -1;
    }
    
    /**
     * Checks if the array is empty.
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        // returns whether or not any elements are present
        return elementCount == 0;
    }

    /**
     * Removes the element at the specified position in this list
     * @param index the index to remove an item from
     * @throws IndexOutOfBoundsException 
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        
        // if index is outside the bounds of the array, an exception is thrown
        if (index > elementCount || index < 0) 
        {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        
        // if the index is in bounds, it is set to null
        list[index] = null;

        // all the elements in the array are moved back one index
        for (int i = 0; i < elementCount; i++) 
        {
            list[i] = list[i + 1];
        }
        // the counter is subtracted from and the index at which it was at
        // is set to null
        elementCount--;
        list[elementCount] = null;
    }
 
    /**
     * Removes the first occurrence of the specified element from this list, 
     * if it is present. Return false if the object is not in the list
     * @param o the object to be removed
     * @return true if the object was successfully removed.
     * @throws IndexOutOfBoundsException 
     */
    public boolean remove(Object o) throws IndexOutOfBoundsException{

        // Iterates through list until object to be removed is found, 
        // or end of list is reached.
        for (int i = 0; i < elementCount; i++)
        {
            if (list[i].equals(o))
            {
                list[i] = null; // remove object.
                
                // iterate through rest of list and bump all elements back 1
                for (int j = i; j < elementCount - 1; j++)
                {
                    list[i] = list[i + 1];
                }
                // set the last element to null and subtract from the
                // counter.
                list[elementCount] = null;
                elementCount--;
                return true; // successfully removed
            }
        }
        
        // returns false if end of list was reached or object doesn't exist
        return false;
    }

    /**
     * Replaces the element at position i in this list with the 
     * specified object
     * @param i index to set object at
     * @param o object to set at index
     * @throws IndexOutOfBoundsException 
     */
    public void set(int i, Object o) throws IndexOutOfBoundsException{
        
        // if index is outside the bounds of the array, an exception is thrown
        if (i > elementCount || i < 0)
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // set the element at the index to that object
        list[i] = o;
    }

    /**
     * Finds the size of the list.
     * @return the number of elements in this list.
     */
    public int size() {
        // return the number of elemnts in the list
        return elementCount;
    }

    public MyArrayList subList(int fromIndex, int toIndex) {
        
        //if index is outside the bounds of the array, an exception is thrown
        if (fromIndex < 0 || toIndex > elementCount) 
        {
            throw new IndexOutOfBoundsException("Beginning index must be"
                    + " greater than 0 and ending index must be less than "
                    + "the size of array list");
        }


        // create a new ArrayList to hold sublist
        MyArrayList sublist = new MyArrayList(toIndex - fromIndex);
        
        // iterate through old list and add values to sublist
        for (int i = fromIndex; i < toIndex; i++)
        {
            sublist.add(list[i]);
        }
        // return the sublist
        return sublist;
    }

    /**
     * Adds two lists together
     * @param list2 the list to be added to the first one
     * @return a larger combined list
     */
    public MyArrayList add(MyArrayList list2) {
        
        // determine the size of the new list and create the list of that
        // size
        int size = elementCount + list2.elementCount;
        MyArrayList list3 = new MyArrayList(size);


        // add all elements of the first list to the new list
        for (int i = 0; i < elementCount; i++)
        {
            list3.list[i] = this.list[i];
        }
        
        // add all the elements of the second list ot the new list
        for (int i = 0; i < list2.elementCount; i++)
        {
            list3.list[i + elementCount] = list2.list[i];

        }
        
        // set the new list's element count to the size
        list3.elementCount = size;

        // return the new list
        return list3;
    }

    /**
     * ToString method that allows user to print list items
     * @return 
     */
    @Override
    public String toString() {
        // string to store output
        String output = "";
        // for loop to iterate through all items of the list
        for (int i = 0; i > elementCount; i++)
        {
            output += list[i] + "\n"; //concatinate all items onto string
        }
        
        // return the string
        return output;
    }
}


