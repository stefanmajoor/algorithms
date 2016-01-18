package algorithms.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Interface for sorting arrays
 */
public interface Sortable {
    public <T> T[] sort(T[] set, Comparator<T> comparator);
}
