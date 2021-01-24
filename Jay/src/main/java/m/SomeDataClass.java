package m;

import m.Task;
import m.MyComp;
import java.util.ArrayList;
import m.People;
import java.util.Observable;
import java.util.TreeMap;


/**
 * This class is used to compute an ordering of the tasks to people and compute
 * its time. It extends observable to get information from the people and the task class and to be able to update our view
 *
 * @author Henry
 *
 */
public class SomeDataClass extends Observable{

	private ArrayList<People> peoples = new ArrayList<People>();
	private ArrayList<Task> tasks = new ArrayList<Task>();
	private TreeMap<Task , ArrayList<People>> theEnd = new TreeMap<Task ,ArrayList<People>>(new MyComp());

	/**
 	* Empty Constructor to create instance of this class and supply values.
 	*/
	public SomeDataClass(){}


	/**
 	* Method to set the supplied ArrayList of persons to the peoples field.
 	* It also notifies the obervers that the essentially peoples ArrayList changed.
 	* @param ArrayList<People> persons
 	*/
	public void setPeoples(ArrayList<People> persons){
		peoples = persons;
		setChanged();
		notifyObservers(persons);
	}
	/**
 	* get the ArrayList of people created when the user used our manager
 	*/
	public ArrayList<People> getPeoples(){
		return peoples;
	}
	/**
	* Method to set the supplied ArrayList of tasks to the tasks field.
	* It also notifies the obervers that the essentially tassk ArrayList changed.
 	* @param ArrayList<Task> myTask
 	*/
	public void setTasks(ArrayList<Task> myTask){
		tasks = myTask;
		setChanged();
		notifyObservers(myTask);
	}
	/**
 	* get the ArrayList of tasks created when the user used our manager
 	*/
	public ArrayList<Task> getTasks(){
		return tasks;
	}
	/**
 	* get the TreeMap with a Task as a key and an ArrayList of people that could potentially work on the task assigned to it as a value
 	*/
	public TreeMap<Task , ArrayList<People>> getTheEnd(){
		return theEnd;
	}
	/**
 	* calculates and returns an TreeMap of which task has which persons and sets there timetable. Calls assignSTasks first and then assignRTasks second
 	*/
	public TreeMap<Task , ArrayList<People>> calculations() {
		theEnd = new TreeMap<Task ,ArrayList<People>>(new MyComp());
		
		if(getPeoples().isEmpty()==false && getTasks().isEmpty()==false){
			for(Task myTask : getTasks()){
				myTask.setStartTime(0);
				myTask.setEndTime(0);
				myTask.setIsDone(false);
			}
			for (People aPerson : getPeoples()){
				aPerson.setTime(0);
			}
			assignSTasks();
			assignRTasks();
		}
		return theEnd;
	}
	/**
 	* calculates and returns an TreeMap of which only the tasks that have no requirements are used to get assigned people working on each task and at what time
 	*/
	public void assignSTasks(){
		ArrayList<People> someRand = new ArrayList<People>();
		int someRandTime=9999;
		for(Task myTask : getTasks()){
			if(myTask.getRequirements().isEmpty()){
				if(myTask.isDone()==false){
					myTask.setIsDone(true);
					for(People aPerson : getPeoples()){
						if(aPerson.getTime()<=someRandTime){
							someRandTime=aPerson.getTime();
						}
					}
					for(People aPerson : getPeoples())
					{
						if(aPerson.getTime()== someRandTime){
							int aTime= myTask.getTime()+(myTask.getCapacity()-aPerson.getCapacity())/2;
							if(aTime<=aPerson.getTime()){
								aTime = 1;
							}
							int newTime = aPerson.getTime()+aTime;
							myTask.setStartTime(aPerson.getTime());
							aPerson.setTime(newTime);
							myTask.setEndTime(newTime);
							someRand.add(aPerson);
							someRandTime = 90000;
							theEnd.put(myTask , someRand);
							someRand = new ArrayList<People>();
							break;
						}
					}
				}
			}
		}
	}
	/**
 	* calculates and returns an TreeMap of which only the tasks that have requirements are used to get assigned people working on each task and at what time
 	*/
	public void assignRTasks(){
		ArrayList<People> someRand = new ArrayList<People>();
		int someRandTime=9999;
		for(Task myTask : getTasks()){
			if(!myTask.getRequirements().isEmpty()){
				if(myTask.isDone()==false){
					myTask.setIsDone(true);
					for(People aPerson : getPeoples()){
						if(aPerson.getTime()<=someRandTime){
							someRandTime=aPerson.getTime();
						}
					}
					for(Task requirements : myTask.getRequirements()){
						for(Task theTask : getTasks()){
							if(requirements.getName().equals(theTask.getName())){
								if(theTask.endTime() >= someRandTime){
										someRandTime = theTask.endTime();
								}
							}
						}
					}
					int myStartTime = someRandTime;
					for(People aPerson : getPeoples())
					{
						if(aPerson.getTime()== someRandTime || (aPerson.getTime()<=someRandTime+1 && aPerson.getTime()>= someRandTime-1)){
							if(someRand.size() < myTask.getPeople()){
							someRand.add(aPerson);
							}
						}

					}
					int capacities=0;
					for(People aPerson : someRand){
						capacities += aPerson.getCapacity();
						if(someRandTime<= aPerson.getTime()){
							someRandTime = aPerson.getTime();
						}
					}
					int newCapacity= capacities/someRand.size();
					int aTime= someRandTime + myTask.getTime()+(myTask.getCapacity()-newCapacity)/2;
					myTask.setStartTime(myStartTime);
							if(aTime-someRandTime<=someRandTime){
								aTime = someRandTime + 1;
							}
					for(People aPerson : someRand){
						aPerson.setTime(aTime);
					}
					myTask.setEndTime(aTime);					
					theEnd.put(myTask , someRand);
					someRandTime = 9000;
					someRand = new ArrayList<People>();
				}
			}
		}
	}
}
