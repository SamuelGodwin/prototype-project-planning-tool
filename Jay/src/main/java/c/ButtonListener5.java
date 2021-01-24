
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import m.People;
import m.Task;
import v.Panel3;
import v.Panel5;
import m.SomeDataClass;

/**
 * Class description
 * 
 * @author Samuel
 *
 */
public class ButtonListener5 implements ActionListener {

	private Panel5 panel5;
	private MainGUI mainGui;
	
	/**
	 * Constructor for ButtonListener5, Panel5 is a parameter in this constructor
	 * @param Panel5   panel5
	 * @param MainGui  MainGui
	 */
	public ButtonListener5(Panel5 panel5, MainGUI mainGui){
		 this.panel5=panel5;
		 this.mainGui=mainGui;
	}
	
	/**
	 * Method for the action of the button clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
			
		JButton button = (JButton) e.getSource();
		
		
		if(button.getName().equals("back")){
			
			mainGui.enterDashboard();
			
		}
	}
}