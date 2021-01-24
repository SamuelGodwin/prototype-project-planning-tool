package m;

import java.util.ArrayList;
import java.util.Observable;
import m.SomeDataClass;

/**
 * Class to represent the People.
 * @author Henry
 */
public class People extends Observable{

	private String firstName;
	private String surname;
	private String employeeNum;
	private int capacity;
	private ArrayList<People> people;
	private SomeDataClass someData;
	private int hisTime=0;

	/**
	 * Constructor for People
	 * @param  String        firstName
	 * @param  String        surname
	 * @param  String        employeeNum
	 * @param  int           capacity
	 * @param  SomeDataClass someData
	 */
	public People(String firstName, String surname, String employeeNum, int capacity , SomeDataClass someData) {
		people = new ArrayList<People>();
		this.firstName = firstName;
		this.surname = surname;
		this.employeeNum = employeeNum;
		this.capacity = capacity;
		this.someData = someData;
	}
	/**
	 * getFirstName method. This method get the firstName of the person
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
 	* method that sets the first name of a person to the first name assigned to him when we created the him
 	* @param String firstName
 	*/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * getSurname method. This method get the surname of the person
	 */
	public String getSurname() {
		return surname;
	}
	/**
 	* method that sets the surname of a person to the surname assigned to him when we created the him
 	* @param String surname
 	*/
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * getEmployeeNum method. This method get the employe number of the person
	 */
	public String getEmployeeNum() {
		return employeeNum;
	}
	/**
 	* method that sets the employee number of a person to the employee Number assigned to him when we created the him
 	* @param String employeeNum
 	*/
	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}
	/**
	 * getCapacity method. This method get the caoacity of the person
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
 	* method that sets the capacity of a person to achieve a task to the capacity assigned to him when we created the person
 	* @param int capcacity
 	*/
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * getPeople method. This method get all the people that were created and stored in an ArrayList
	 */
	public ArrayList<People> getPeople(){
		return people;
	}
	/**
 	* Method to add a person to the arraylist and notify the observers.
 	* this method will as well set the arrayList of people to the ArrayList of people stored in the class SomeData
 	* @param People person
 	*/
	public void add_People(People person) {
		people.add(person);
		someData.setPeoples(people);
		setChanged();
		notifyObservers(person);
	}
	/**
 	* method that sets the time of the person to the current time the person finished a new task assigned to him
 	* @param int time
 	*/
	public void setTime(int time){
		hisTime = time;
	}
	/**
	 * getTime method. This method get the time the person currently is positionned at after finishing one task
	 */
	public int getTime(){
		return hisTime;
	}

}
