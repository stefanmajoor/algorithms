package algorithms.Structures;

/**
 * Common interface for heaps
 */
public interface Heap<T> {
    
    /**
     * Insert an item in the heap
     * 
     * @param item 
     */
    abstract public void insert(T item);
    
    
    /**
     * Extract the top item
     * 
     * @return Item at the top of the heap
     */
    abstract public T extract();
    
    /**
     * View the item at top
     * 
     * @return Item at the top of the heap
     */
    abstract public T peek();
    
    /**
     * Get the size of the heap
     * 
     * @return 
     */
    abstract public int getSize();
}
