
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import m.People;
import m.Task;
import v.Panel3;
import v.Panel4;
import m.SomeDataClass;

/**
 * Class description
 * 
 * @author Samuel
 *
 */
public class ButtonListener4 implements ActionListener {

	private Panel4 panel4;
	private MainGUI mainGui;
	
	/**
	 * Constructor for ButtonListener4, Panel4 is a parameter in this constructor
	 * @param Panel4   panel4
	 * @param MainGui  mainGui
	 */
	public ButtonListener4(Panel4 panel4, MainGUI mainGui){
		 this.panel4=panel4;
		 this.mainGui=mainGui;
	}
	
	/**
	 * Method for the action of the button clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
			
		JButton button = (JButton) e.getSource();
		
		// TODO: check if fields are empty, check if user is sure.
		if(button.getName().equals("back")){
			
			mainGui.enterDashboard();
			
		}
	}
}