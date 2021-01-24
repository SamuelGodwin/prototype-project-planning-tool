package m;
import java.util.ArrayList;
import java.util.Observable;
import m.SomeDataClass;

/**
 * Class to represent a task.
 *
 * @author Henry
 */
public class Task extends Observable{

	private String name;
	private int capacity;
	private ArrayList<Task> requirements;
	private int time;
	private ArrayList<Task> tasks;
	private boolean isDone=false;
	private SomeDataClass someData;
	private int startTime=0;
	private int endTime=0;
	private int people;
	/**
	 * Constructor for Task
	 * @param  String           name
	 * @param  int              capacity
	 * @param  ArrayList<Task>  requirements
	 * @param  int              time
	 * @param  int              people
	 * @param  SomeDataClass    someData
	 */
	public Task(String name, int capacity, ArrayList<Task> requirements, int time , int people , SomeDataClass someData) {
		tasks = new ArrayList<Task>();
		this.name = name;
		this.capacity = capacity;
		this.requirements = requirements;
		this.time = time;
		this.someData=someData;
		this.people = people;
	}
	/**
	* gets the name of the task assigned to it when created
	*/
	public String getName(){
		return name;
	}
	/**
	* gets the complexity of a task assigned to it when created
	*/
	public int getCapacity(){
		return capacity;
	}
	/**
	* get the maximum amount of people possible to assign to a task 
	*/
	public int getPeople(){
		return people;
	}
	/**
	 * sets the maximum amount of people needed for a specific tasks when created
	 * @param  int  thePeople
	 */
	public void setPeople(int thePeople){
		people = thePeople;
	}
	/**
	* gets the normal time needed to get this task done
	*/
	public int getTime(){
		return time;
	}
	/**
	* gets an ArrayList of tasks that contains the requirement needed to finish to achieve the Task
	*/
	public ArrayList<Task> getRequirements() {
      return requirements;
    }

    /**
	 * sets  the name of the task when created
	 * @param  String  theName
	 */
	public void setName(String theName) {
		name=theName;
	}
	/**
	 * sets the complexity of the task when created
	 * @param  int  theCapacity
	 */
	public void setCapacity(int theCapacity) {
		capacity = theCapacity;
	}
	/**
	 * sets the normal time needed to achieve a task when created
	 * @param  int  theTime
	 */
	public void setTime(int theTime) {
		time = theTime;
	}
	/**
	 * sets the end time of the task when calculated in the someData class
	 * @param  int  sTime
	 */
	public void setStartTime(int sTime){
		startTime=sTime;
	}
	/**
	* gets the time at which the task starts
	*/
	public int getStartTime(){
		return startTime;
	}
	/**
	 * sets the end time of the task when calculated in the someData class
	 * @param  int  eTime
	 */
	public void setEndTime(int eTime){
		endTime=eTime;
	}
	/**
	* gets the time at which the task ends
	*/
	public int endTime(){
		return endTime;
	}

	/**
	 * sets the requirements needed to finish this task
	 * @param  ArrayList<Task>  theRequirements
	 */
	public void setRequirements(ArrayList<Task> theRequirements) {
		this.requirements = theRequirements;
	}
	/**
	 * this adds a task to our ArrayList of tasks , notifies the observer and tells that it got updated
	 * it sets the ArrayList of tasks in SomeDataClass to our current ArrayList of tasks
	 * @param  Task  task
	 */
 	public void add_Task(Task task) {
    	tasks.add(task);
   		someData.setTasks(tasks);
    	setChanged();
    	notifyObservers(tasks);
  	}
  	/**
	* gets the an ArrayList of tasks that contains all the tasks created for the moment
	*/
  	public ArrayList<Task> getTasks() {
  		return tasks;
  	}
  	/**
	 * tells that the task was done so that we don t have to check it again
	 * @param  boolean  done
	 */
  	public void setIsDone(boolean done){
    	isDone=done;
  	}
  	/**
	* checks if the task was done or not
	*/
	public boolean isDone() {
		return isDone;
	}
}
