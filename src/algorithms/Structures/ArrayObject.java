/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.Structures;

/**
 * Hack to allow arrays to be passed by reference
 * 
 * @param <T> type of array
 */
public class ArrayObject<T> {

    /**
     * 
     * @param set 
     */
    public ArrayObject(T[] set) {
        this.content = set;
    }

    /**
     * Contents of the array
     */
    public T[] content;

    /**
     * Swap to items in the array
     * @param i First element
     * @param j Second Element
     */
    public void swap(int i, int j)
    {
        // Exchange a[i+1] with A[r]
        T swap = this.content[i];
        this.content[i] = this.content[j];
        this.content[j] = swap;
    }
}
