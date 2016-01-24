/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.Structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class MaxHeap<T> implements Heap<T> {
    
    /**
     * The items in our heap
     */
    protected ArrayList<T> array;
    
    /**
     * The comparator used in our heap
     */
    protected Comparator<T> comparator;
        
    /**
     * Create a maxheap from a list
     * 
     * @param array 
     */
    public MaxHeap(List<T> array, Comparator<T> comparator)
    {
        this.comparator = comparator;
        this.array = new ArrayList<T>(array);
        this.buildMaxHeap();
    }
    
    /**
     * create a maxheap from an array
     * 
     * @param array 
     */
    public MaxHeap(T[] array, Comparator<T> comparator) {
        this.comparator = comparator;
        this.array = new ArrayList<T>((List<T>) Arrays.asList(array));
        this.buildMaxHeap();
    }
    
    
    @Override
    public int getSize() {
        return this.array.size();
    }
    
    @Override
    public void insert(T item) {
        this.array.add(item);
        
        int i = this.array.size();
        while (i > 1)
        {
             T currentElement = this.array.get(i);
             T parentElement = this.array.get(this.parent(i));
             if (this.comparator.compare(parentElement, currentElement) != -1) {
                 break;
             }
             
             // Swap keys
             T swap = this.array.get(i);
             this.array.set(i, this.array.get(this.parent(i)));
             this.array.set(this.parent(i), swap);
             
             i = this.parent(i);        
         }
    }

    @Override
    public T extract() {
        if (this.getSize() < 1) {
            throw new ArrayIndexOutOfBoundsException("Heap underflow");
        }
        
        T max = this.array.get(0);
        this.array.set(0, this.array.get(this.getSize() - 1));
        this.array.remove(this.getSize() -1);
        this.maxHeapify(0);
        return max;
    }

    @Override
    public T peek() {
        return this.array.get(0);
    }
        
    
    /**
     * Makes sure that the subtree of i is obeys the max-heap property
     */
    protected void maxHeapify(int i)
    {
        // Get the children. However, note that 
        // they might be null if we are at the leaves
        int right = right(i);
        int left = left(i);
        
        // The largest element found so far
        int largest = i;
        
        if (left < this.getSize()) {
            T leftElement = this.array.get(left);
            T currentElement = this.array.get(i);
            if (this.comparator.compare(leftElement, currentElement) == -1) {
                largest = left;
            }
        }
        
        if (right < this.getSize()) {
            T largestElement = this.array.get(largest);
            T rightElement = this.array.get(right);
            
            if (this.comparator.compare(rightElement, largestElement) == -1) {
                largest = right;
            }
        }
        
        if (largest != i) {
            // exchange the item at i with the item at largest
            T swap = this.array.get(i);
            this.array.set(i, this.array.get(largest));
            this.array.set(largest, swap);
            
            // Now call the max-heapify recursive
            this.maxHeapify(largest);   
        }
    }
    
    
    /**
     * Build a max heap
     */
    protected void buildMaxHeap()
    {
        for (int i = this.getSize() / 2; i >= 0; i--) {
            this.maxHeapify(i);
        }
    }
    
    /**
     * Return the parent index of an item
     * 
     * @param i
     * @return 
     */
    protected int parent(int i) {
        return (i+1)/2 - 1;
    }
    
    /**
     * Return the left child of an item
     * s
     * @param i
     * @return 
     */
    protected int left(int i) {
        return 2*(i+1)-1;
    }
    
    /**
     * REturn the right child of an item
     * @param i
     * @return 
     */
    protected int right(int i) {
        return 2*(i+1);
    } 
}
