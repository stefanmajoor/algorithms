package algorithms.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Interface for sorting arrays
 */
public interface Sortable {
    
    /**
     * Sort an array
     * 
     * @param <T> Type of array that needs to be sorted
     * @param set The array that needs to be sorted
     * @param comparator Method used to compare two items in an array
     * @return Sorted array
     */
    public <T> T[] sort(T[] set, Comparator<T> comparator);
}
