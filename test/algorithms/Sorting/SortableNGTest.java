/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.Sorting;

import org.testng.annotations.Test;
import java.util.Comparator;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 *
 * @author Stefan
 */
abstract public class SortableNGTest {
    
    // The instance that needs to be tested   
    Sortable sorter;
    
    public SortableNGTest() {
        sorter = this.createClass();
    }
    
    
    // Return the class that needs to be tested
    abstract public Sortable createClass();
    

    // UNIT TESTS
    
    /**
     * A first simple test that test if a set is sorted
     */
    @Test
    public void testSimpleSort() {
        Integer[] set = {5, 3, 1, 2, 4};
        Integer[] expected = {1, 2, 3, 4, 5};
        
        Comparator<Integer> comp = (Integer o1, Integer o2) -> {
            if (o1 < o2) {
                return -1;
            }
            if (o1 > o2) {
                return 1;
            }
            return 0;
        };
        
        Integer[] sorted = sorter.sort(set, comp);
        assertArrayEquals(expected, sorted);
    }
    
    /**
     * Test that the set is correctly sorted if the array needs to be sorted in reverse
     */
    @Test
    public void testSimpleSortReverse() {
        Integer[] set = {5, 3, 1, 2, 4};
        Integer[] expected = {5, 4, 3, 2, 1};
        
        Comparator<Integer> comp = (Integer o1, Integer o2) -> {
            if (o1 < o2) {
                return 1;
            }
            if (o1 > o2) {
                return -1;
            }
            return 0;
        };
        
        Integer[] sorted = sorter.sort(set, comp);
        assertArrayEquals(expected, sorted);
    }
    
    /**
     * Test if a set is sorted correctly if it was already sorted
     */
    @Test
    public void testSortedSet() {
        Integer[] set = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        
        Comparator<Integer> comp = (Integer o1, Integer o2) -> {
            if (o1 < o2) {
                return -1;
            }
            if (o1 > o2) {
                return 1;
            }
            return 0;
        };
        
        Integer[] sorted = sorter.sort(set, comp);
        assertArrayEquals(expected, sorted);
    }
    
    /**
     * Test if a set is sorted if the values are given in totally the reverse order
     */
    @Test
    public void testTotallyUnSortedSet() {
        Integer[] set = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};
        
        Comparator<Integer> comp = (Integer o1, Integer o2) -> {
            if (o1 < o2) {
                return -1;
            }
            if (o1 > o2) {
                return 1;
            }
            return 0;
        };
        
        Integer[] sorted = sorter.sort(set, comp);
        assertArrayEquals(expected, sorted);
    }
    
    /**
     * Test sorting the empty set
     */
    @Test
    public void testEmptySet() {
        Integer[] set = {};
        Integer[] expected = {};
        
        Comparator<Integer> comp = (Integer o1, Integer o2) -> {
            if (o1 < o2) {
                return -1;
            }
            if (o1 > o2) {
                return 1;
            }
            return 0;
        };
        
        Integer[] sorted = sorter.sort(set, comp);
        
        assertArrayEquals(expected, sorted);
    }
    
    /**
     * Test that sorting is correct if we sort on something else than numbers
     */
    @Test
    public void testNonInteger() {
        Foo one = new Foo(1);
        Foo two = new Foo(2);
        Foo three = new Foo(3);
        
        Foo[] set = {three, one, two};
        Foo[] expected = {one, two, three};
        
        Comparator<Foo> comp = (Foo o1, Foo o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return -1;
            }
            if (o1.getValue() < o2.getValue()) {
                return 1;
            }
            return 0;
        };
        
        Foo[] sorted = sorter.sort(set, comp);
        
        assertArrayEquals(expected, sorted);
    }
    
    /**
     * Test that the sorting algorithm sorts correctly if null values are present
     */
    @Test
    public void testNull() {
        Foo one = null;
        Foo two = new Foo(2);
        Foo three = new Foo(3);
        
        Foo[] set = {three, one, two};
        Foo[] expected = {one, two, three};
        
        Comparator<Foo> comp = (Foo o1, Foo o2) -> {          
            if (o2 != null && (o1 == null ||  o1.getValue() < o2.getValue())) {
                return -1;
            }
            if (o1 != null && (o2 == null || o1.getValue() < o2.getValue())) {
                return 1;
            }
            return 0;
        };
        
        Foo[] sorted = sorter.sort(set, comp);
        
        assertArrayEquals(expected, sorted);
    }
    
    class Foo
    {
        int i;
        
        Foo(int i)
        {
            this.i = i;
        }
        
        int getValue() {
            return i;
        };
    }
}
