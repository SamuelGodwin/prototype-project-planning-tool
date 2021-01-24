
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import m.Task;
import v.Panel2;
import m.SomeDataClass;

/**
 * Button listener for actions matching the button click named 'save', for the panel 'add task'
 *
 * @author Samuel, Henry
 *
 */
public class ButtonListener2 implements ActionListener {

	private Panel2 panel2;
	private MainGUI mainGui;
	private String name;
	private int capacity;
	private ArrayList<Task> requirements;
	private int time;
	private Task task;
	private SomeDataClass someData;

	/**
	 * Constructor for ButtonListener2
	 * @param  Panel2        panel2        Panel within the UI
	 * @param  MainGUI       mainGui       Main Frame UI
	 * @param  Task          task          A task item, as this method is to create a new task
	 * @param  SomeDataClass someData      The management class for tasks
	 */
	public ButtonListener2(Panel2 panel2, MainGUI mainGui , Task task , SomeDataClass someData){
		 this.panel2=panel2;
		 this.mainGui=mainGui;
		 this.someData=someData;
		 this.task=task;
	}

	/**
	 * Method for the action of the button clicked, passes the task with the correct values to the arrayList of tasks
	 *sets back the values of the panel to the original values
	 * @param ActionEvent e Searching for button press, from button matching name 'save'
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton) e.getSource();
		
		if(button.getName().equals("save")){
				Task theTask = new Task(panel2.getName(), panel2.getCapacity() , panel2.getRequirements() , panel2.getTime() , panel2.getPeople(),  someData);
				task.add_Task(theTask);
				panel2.getEffortSlider().setValue(5);
				panel2.getTheTime().setValue(1);
				panel2.getNameField().setText("");
				panel2.getThePeople().setValue(1);
		}
	}
}
