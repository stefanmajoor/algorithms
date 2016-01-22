/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.Sorting;

import algorithms.Structures.MaxHeap;
import java.util.Comparator;

public class HeapSort implements Sortable {

    @Override
    public <T> T[] sort(T[] set, Comparator<T> comparator) {
        MaxHeap<T> heap = new MaxHeap(set, comparator);
        
        System.out.println("------");
        for (int i = 0; i < set.length; i++) {
            set[i] = heap.extract();
            System.out.println(i + " " + set[i]);
        }
        
        return set;
    } 
}
