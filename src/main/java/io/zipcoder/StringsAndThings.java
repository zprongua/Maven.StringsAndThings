package io.zipcoder;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int counter = 0;
        for (String s : input.split(" ")) {
            if (s.charAt(s.length()-1)==('y') || s.charAt(s.length()-1)==('z')) {
                counter += 1;
            }
        }
        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        return base.replaceAll(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        int countIs = 0;
        int countNot = 0;
        int index = 0;
        while ((index = input.indexOf("is", index)) != -1) {
            countIs++;
            index++;
        } index = 0;
        while ((index = input.indexOf("not", index)) != -1) {
            countNot++;
            index++;
        }
        return (countIs==countNot);
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        boolean happy = false;
        int index = 0;
        while ((index = input.indexOf("g", index)) != -1) {
            if (index>1) {
                if (input.charAt(index + 1) == 'g' || input.charAt(index - 1) == 'g') {
                    happy = true;
                }
            }
            index++;
        }
        return happy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int theCount = 0;
        int index = 0;
        ArrayList<Integer> indices = new ArrayList<>();
        for (String s : input.split("")) {
            String threeWiseMen = s+s+s;
            while ((index = input.indexOf(threeWiseMen, index)) != -1) {
                if (!indices.contains(index)) {
                    indices.add(index);
                    theCount++;
                }
                index++;
            }

        }
        return theCount;
    }
}
