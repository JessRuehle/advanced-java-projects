package edu.bloomu.homework3;
import java.util.ArrayList;

/**
 * Creates an object that corresponds a word stored as a string to a 
 * definition stored as an ArrayList. A word can contain multiple definitions
 * and each one is stored as a new item in the ArrayList.
 * @author Jessica Ruehle
 */
public class Word {

    // parameters to store the word the user is creating and its defintion(s)
    public final String word;
    public ArrayList<String> definitions;

    /**
     * Constructor that creates a new instance of Word.
     * @param word word the user would like to add.
     * @param def definition to go with the word.
     */
    public Word(String word, String def) 
    {
        // assign the class field "word" to the word the user wants to create
        this.word = word;
        
        // a new ArrayList is created to store the defintion of the word
        definitions = new ArrayList();
        definitions.add(def);
    }

    /**
     * Allows user to add a definition to the current list of definitions
     * @param newDef the definition of the word.
     */
    public void add(String newDef) 
    {
        // adds the new defintion to the ArrayList
        definitions.add(newDef);
    }

    /**
     * Allows the user to get the definitions of a word.
     * @return the list of definitions.
     */
    public ArrayList<String> getDefinition()
    {
        // returns the ArrayList of definitions.
        return definitions;
    }

}
