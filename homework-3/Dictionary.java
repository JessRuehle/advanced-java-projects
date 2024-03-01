package edu.bloomu.homework3;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *Allows user to create a list of 50,000 Words from the custom Word class
* Each item in the Dictionary is unique and cannot be repeated. Methods for
* manipulating items in the dictionary allow user to add, and look for any
* word they want.
 * 
 * @author Jessica Ruehle
 */
public class Dictionary {
    private final LinkedList<Word>[] list;

/**
 * Constructor that creates a new instance of the Dictionary class
 */
    public Dictionary() 
    {
        list = new LinkedList[50000];
    }

    /**
     * Allows user to retrieve hash code of any word in the dictionary.
     * @param word the word the user wants to find the hash code for.
     * @return the hash code of the word.
     */
    public static int hashCode(String word) 
    {
        // store the hashcode of the word the user wants to add
        int hash = word.hashCode();

        // if the hash is negative, updated hash with the absolute value of it
        if (hash < 0) 
        {
            hash = Math.abs(hash);
        }

        // if it is greater than the length of the array, modulate it
        if (hash > 50000) 
        {
            hash = (hash % 50000);
        }
        return hash;
    }

    /**
     * Allows user to add a word to Dictionary and a corresponding definition.
     * @param word the word the user wants to add.
     * @param description description to correspond with added word.
     */
    public void add(String word, String description) 
    {
        // store the hashcode of the word the user wants to add
        int hash = word.hashCode();

        // is the hash is negative, updated hash with the absolute value of it
        if (hash < 0) 
        {
            hash = Math.abs(hash);
        }

        // if it is greater than the length of the array, modulate it
        if (hash > 50000) 
        {
            hash = (hash % 50000);
        }

        // if the list item doesn't already exist...
        if (list[hash] == null) 
        {
            // ...create a new LinkedList at that array index
            LinkedList<Word> l = new LinkedList<>();
            l.add(new Word(word, description));
            list[hash] = l;
        }

        // searches the list for all words containing the same hashcode as
        // the one the user is attempting to add.
        for (Word w : list[hash]) 
        {
            // if the hash matches the hash of the word and the actual words
            // also mmatch, the the desired description will added to that
            // word object
            if (word.equals(w.word)) 
            {
                w.add(description);
            }

        }
    }

    /**
     * Allows user to search for any word in the Dictionary.
     * @param word the word to be searched for.
     * @return the definition(s) of the word.
     */
    public String lookFor(String word) 
    {
        // get the hash of the word to be searched
        int hash = hashCode(word);
        
        // create a string to display defintion(s) of word as well as a new
        // arraylist to store all the definitions in
        String info = word + "\n";
        ArrayList<String> definitions;

        // search the linked list for all words matching the hashcode of the
        // word the user is searching
        for (Word w : list[hash]) 
        {
            // if the word at that hash matches the word the user is searching,
            // all definitions will be added to the arraylist
            if (word.equals(w.word)) 
            {
                definitions = new ArrayList<>(w.getDefinition());
                for (int i = 0; i < definitions.size(); i++) {
                    info += definitions.get(i) + "\n";
                    break;
                }
            }
        }

        // method returns a string containing all the defintions of the word
        return info;
    }
}
