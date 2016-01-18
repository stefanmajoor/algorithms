/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Stefan
 */
public interface Sortable<T> {
    public List<T> sort(List<T> arrayList, Comparator comparator);
}
