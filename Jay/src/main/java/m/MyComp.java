package m;

import m.Task;
import java.util.Comparator;
/**
 * Class to compare two tasks by implementing comperator.
 * @author Henry
 */
public class MyComp implements Comparator<Task>{

/**
 * Method ovverides compare from the comperator class to be able
 * to compare two tasks. Compares its two arguments for order. Returns
 * a negative integer, zero, or a positive integer as the first argument
 * is less than, equal to, or greater than the second.This will be used for a TreeMap
 * @param  Task task1
 * @param  Task task2
 * @return
 */
    @Override
	public int compare(Task task1 ,Task task2){
		return task1.getName().compareTo(task2.getName());
	}
}
