
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import v.Panel1;

/**
 * This class is the controller for the 'Add new task' button within the 'Dashboard' tab
 * The purpose of this class is to handle the button click even, triggering another method from the 'Main GUI' class when the method is invoked.
 *
 * @author Samuel
 *
 */
public class ButtonListener1 implements ActionListener {

	private Panel1 panel1;
	private MainGUI mainGui;

	/**
	 * Constructor for ButtonListener1
	 * @param  Panel1  panel1        The panel containing the 'Dashboard' interface
	 * @param  MainGUI mainGui       The class for the main Frame contructing the ui
	 */
	public ButtonListener1(Panel1 panel1, MainGUI mainGui){
		 this.panel1=panel1;
		 this.mainGui=mainGui;

	}

	/**
	 * This method checks for the action event on a button, and invokes a class in the mainGUI method
	 * @param ActionEvent e looking for button press
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton) e.getSource();

		if(button.getName().equals("add new task")){

			mainGui.enterNewTask();

		}
		
		
		if(button.getName().equals("add people")){
			mainGui.enterAddPeople();
			
		}
		
		if(button.getName().equals("display managers")){
			System.out.println("Display managers page.");
			mainGui.enterDisplayMgrs();
			
		}
		
		if(button.getName().equals("delete")){
			
			
			System.out.println("UPDATE TABLES: DELETE SELECTED ROWS FROM MODEL AND UPDATE VIEW.");
			
		}
	}
}
