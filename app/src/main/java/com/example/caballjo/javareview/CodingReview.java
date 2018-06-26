package com.example.caballjo.javareview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class CodingReview {

    public static void main(String[] args){

        String newline = System.getProperty("line.separator");

        System.out.println(newline + "First Problem: " + newline);

        List<String> names = new ArrayList<String>();
        names.add("Object1");
        names.add("Object1");
        names.add("Object1");
        names.add("Object2");
        names.add("Object2");
        names.add("Object3");
        names.add("Object4");
        names.add("Object5");
        names.add("Object5");

        FindDuplicates(names);

        System.out.println(newline + "Second Problem" + newline);

        String possiblePalindrome1 = "ABCDEEDCBA"; //Pair palindrome
        String possiblePalindrome2 = "ABCDEDCBA"; //Unpair palindrome
        String possiblePalindrome3 = "ABCDECBA"; //Not a palindrome

        IsAPalindrome(possiblePalindrome1);
        IsAPalindrome(possiblePalindrome2);
        IsAPalindrome(possiblePalindrome3);

        System.out.println(newline + "Third Problem" + newline);

        DivisibleHelper(18); //fizz
        DivisibleHelper(50); //buzz
        DivisibleHelper(15); //fizz(both)
        DivisibleHelper(17); //print value

        System.out.println(newline + "Fourth Problem" + newline);

        String word1A = "ABCD", word1B = "BCDA";
        String word2A = "ABCD", word2B = "BCHA";

        AreAnagrams(word1A, word1B);
        AreAnagrams(word2A, word2B);

        System.out.println(newline + "Fifth Problem" + newline);

        MultiplicationTable();
    }

    //Problem 1
    private static void FindDuplicates(List<String> items){

        final Set<String> result = new HashSet();
        final Set<String> set = new HashSet();

        for (String value : items)
        {
            if (!set.add(value))
            {
                result.add(value);
            }
        }
        System.out.println(result);
    }

    //Problem 2
    private static void IsAPalindrome(String word){
        int rightCharPos = word.length()-1;
        for(int leftCharPos = 0; leftCharPos < word.length(); leftCharPos++){

            if(rightCharPos >= leftCharPos){
                if(word.charAt(leftCharPos) == word.charAt(rightCharPos)){
                    rightCharPos--;
                }else{
                    System.out.println("It is not a Palindrome");
                    break;
                }
            }else{
                System.out.println("It is a Palindrome");
                break;
            }
        }
    }

    //Problem 3
    private static void DivisibleHelper(int value){

        if(value%3==0 && value%5==0){
            System.out.println("fizz (both)");
        }
        else if(value%3==0){
            System.out.println("fizz");
        }
        else if(value%5==0){
            System.out.println("buzz");
        }
        else{
            System.out.println(value);
        }
    }

    //Problem 4
    private static void AreAnagrams(String word1, String word2){

        //Represents a Map of the characters and count of word1 and word2
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        List<Character> letters1 = new ArrayList<>();
        List<Character> letters2 = new ArrayList<>();

        //Building a list with all the characters that belongs to word1, also the count per each one of them
        for (int i = 0; i < word1.length(); i++){
            letters1.add(word1.charAt(i));
        }

        for (char letter : letters1){
            map1.put(letter, Collections.frequency(letters1, letter));
        }

        //Building the one that stands for the word2
        for (int i = 0; i < word1.length(); i++){
            letters2.add(word1.charAt(i));
        }

        for (char letter : letters1){
            map2.put(letter, Collections.frequency(letters2, letter));
        }

        if(map1.equals(map2)){
            System.out.println("It is an Anagram");
        }else{
            System.out.println("Sorry, that is not an Anagram");
        }
    }

    //Problem 5
    private static void MultiplicationTable(){
        int X = 10, Y = 10;

        int[][] matrix = new int[X][Y];
        for (int i = 0; i < X; i++){
            for (int e = 0; e < Y; e++){
                matrix[i][e] = (i+1)*(e+1);
            }
        }


        //Printing
        for (int i = 0; i < X; i++){
            String line = "";
            for (int e = 0; e < Y; e++){
                line += matrix[i][e] + ", ";
            }
            System.out.println(line);
        }
    }
}


//    Problem 1
//    Create a function to print the duplicates in a list of strings


//    Problem 2
//    Create function to check if the string is a palindrome

//    Problem 3
//    Create a function that will print
//      "fizz" is the number is divisible by 3
//      "buzz" is the number is divisible by 5
//      "fizz" is the number is divisible by both
//      and the integer for the rest
//     You can use a for loop for using the first 20 integers
