/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.Sorting;

import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Comparator;

/**
 *
 * @author Stefan
 */
abstract public class SortableNGTest {
       
    Sortable sorter;
    
    public SortableNGTest() {
        sorter = this.createClass();
    }
    
    abstract public Sortable createClass();

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testSimpleSort() {
        ArrayList<Integer> unsortedSet = new ArrayList();
        unsortedSet.add(3);
        unsortedSet.add(5);
        unsortedSet.add(1);
        unsortedSet.add(2);
        unsortedSet.add(4);
        
        Comparator<Integer> comp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
    }


