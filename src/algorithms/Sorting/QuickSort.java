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
public class QuickSort implements Sortable {
    
    @Override
    public <T> T[] sort(T[] set, Comparator<T> comparator) {
        ArrayObject<T> array = new ArrayObject(set);
        this.quickSort(array, 0, set.length - 1, comparator);
        return array.content;
    }
    
    /**
     * The actual quicksort algorithm with all the parameters
     * 
     * @param set The set to be sorted
     * @param p The lower bound of what needs to be sorted
     * @param r The upper bound of what needs to be sorted
     * @param comparator Comparator used to rank items of type T
     */
    protected <T> void quickSort(ArrayObject<T> set, int p, int r, Comparator<T> comparator) {
        if (p < r) {
            int q = this.partition(set, p, r, comparator);
            this.quickSort(set, p, q - 1, comparator);
            this.quickSort(set, q + 1, r, comparator);
        }
    }
    
    /**
     * Partition the array in to two parts, the first part being lower than r, and
     * the second part higher than r
     * 
     * @param <T> Type of things we need to partition
     * @param set Array to partition
     * @param p The lower bound of what needs to be partitioned
     * @param r The upper bound of what needs to be partitioned
     * @param comparator Comparator used to rank items of type T
     * @return 
     */
    protected <T> int partition(ArrayObject<T> set, int p, int r, Comparator<T> comparator)
    {
        T pivot = set.content[r];
        int i = p - 1;
        
        for (int j = p; j < r; j++) {
            if (comparator.compare(set.content[j], pivot) == -1) {
                i++;
                
                // Exchange a[i] and a[j]
                set.swap(i, j);
            }
        }
        set.swap(i + 1, r);
        
        return i + 1;
    }
}
