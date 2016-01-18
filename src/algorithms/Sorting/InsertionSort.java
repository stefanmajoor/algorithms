/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.Sorting;

import java.util.Comparator;

/**
 *
 * @author Stefan
 */
public class InsertionSort implements Sortable {
    
    /**
     * Sort an array
     * 
     * @param <T> Type of array that needs to be sorted
     * @param set The array that needs to be sorted
     * @param comparator Method used to compare two items in an array
     * @return Sorted array
     */
    public <T> T[] sort(T[] set, Comparator<T> comparator)
    {
        for (int j = 1; j < set.length; j++) {
            T key = set[j];
            int i = j - 1;
            while (i >= 0 && comparator.compare(key, set[i]) == -1) {
                set[i+1] = set[i];
                i--;
            }
            
            set[i+1] = key;
        }
        
        return set;
    }
}
