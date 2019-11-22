package datastructs;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * A simple exercise using a TreeMap to create a dictionary with the potential for
 * words to have multiple definitions.
 * @author Todd A. Qualiano
 */
public class MapDictionary {
	
	Map<String, LinkedList<String>> dictionary = new HashMap<>();
	
	/**
	 * Adds either a key, value pair to the dictionary or simply updates the
	 * value by adding a new definition to the end of the definition list.
	 * @param word The key of the dictionary
	 * @param definition add or update definition of the dictionary
	 */
	public void add(String word, String definition) {
		if(dictionary.get(word) == null) {
			LinkedList<String> list = new LinkedList<>();
			list.add(definition);
			dictionary.put(word, list);
		}else {
			dictionary.get(word).add(definition);
		}
	}

    public static void main(String[] args) throws IOException {
        MapDictionary dictionary = new MapDictionary();

        String word1 = "Circle";
        String defn1 = "The set of points equadistant from the origin";
        String word2 = "Circle";
        String defn2 = "An object whos area is pi*r^2";
        String word3 = "Rectangle";
        String defn3 = "a quadrilateral with 4 right angles";
        String word4 = "Rectangle";
        String defn4 = "A quadrilateral with congruent diagonals which bisect";
        String word5 = "Box";
        String defn5 = "A 3D object with 6 rectangular faces";
        String word6 = "Box";
        String defn6 = "An object with three dimensions";

        dictionary.add(word1, defn1);
        dictionary.add(word2, defn2);
        dictionary.add(word3, defn3);
        dictionary.add(word4, defn4);
        dictionary.add(word5, defn5);
        dictionary.add(word6, defn6);

        System.out.println(dictionary);

      
    }
}
