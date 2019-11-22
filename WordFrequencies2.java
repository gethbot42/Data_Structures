package datastructs;

import java.util.Map;
import java.util.TreeMap;

/**
 * A simple program that counts the number of occurences words in a given array.
 * @author Todd Qualiano
 */
public class WordFrequencies2 {

    public static void main(String[] args) {
        String[] words = {"Namath", "Sauer", "Maynard",
            "Namath", "Bradshaw", "Namath", "Snell", "Sauer",
            "Todd", "Bradshaw"};
        
        Map<String, Integer> mapWords = new TreeMap<>();
        
        System.out.println("Use a for loop to read the values of the array into"
                + " the map and count the frequency of each word");
        
        for(String s : words){
            if(mapWords.get(s)==null){
                mapWords.put(s, 1);
            }else{
                mapWords.put(s, mapWords.get(s) + 1);
            }
        }
        
        //print out KeySet
        for(String s : mapWords.keySet()){
            System.out.println(s + " Frequency: " + mapWords.get(s));
        }
    }
}
