/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.Sorting;

import algorithms.Structures.ArrayObject;
import java.util.Comparator;

/**
 *
 * @author Stefan
 */
public class MergeSort implements Sortable {

    @Override
    public <T> T[] sort(T[] set, Comparator<T> comparator) {
        ArrayObject<T> array = new ArrayObject<>(set);
        this.mergeSort(array, 0, set.length - 1, comparator);
        return array.content;
    }
    
    /**
     * Do the actual merge sort
     * 
     * @param <T> Type of array to be merged
     * @param set Array to be merged
     * @param p Start of the array to be merged
     * @param r End of the array to be merged
     * @param comparator Comparator to rank two elements of type T
     */
    protected <T> void mergeSort(ArrayObject<T> set, int p, int r, Comparator<T> comparator) {
        if (p < r) {
            int q = (p + r) / 2;
            this.mergeSort(set, p, q, comparator);
            this.mergeSort(set, q+1, r, comparator);
            this.merge(set, p, q, r, comparator);
        }
    }
    
    /**
     * Merges an array
     * 
     * @param <T> Type of array to be merged
     * @param set Set to be merged
     * @param p Fist element of set to be merged
     * @param q pivot points for the two subarrays that need to be merged
     * @param r last element in the array to be merged
     * @param comparator The comparator used to rank two elements of type T
     */
    protected <T> void merge(ArrayObject<T> set, int p, int q, int r, Comparator<T> comparator) {
        int n1 = q - p + 1;
        int n2 = r - q;
        T[] left = (T[]) new Object[n1];
        T[] right = (T[]) new Object[n2];
        
        for (int i = 0; i < n1; i++ ) {
            left[i] = set.content[p + i];
        }
        
        for (int i = 0; i < n2; i++) {
            right[i] = set.content[q + i + 1];
        }
        
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (j >= right.length || ( i < left.length && comparator.compare(left[i], right[j]) == -1)) {
                set.content[k] = left[i];
                i++;
            } else {
                set.content[k] = right[j];
                j++;
            }
        }
    }
}
