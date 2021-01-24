
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import m.People;
import m.Task;
import v.Panel3;
import m.SomeDataClass;

/**
 * Class listening for action events from the button named 'save', inside the add people tab
 *
 * @author Samuel, Henry
 *
 */
public class ButtonListener3 implements ActionListener {

	private Panel3 panel3;
	private MainGUI mainGui;
	private People people;
	private SomeDataClass someData;

	/**
	 * Constructor for ButtonListener3
	 * @param  Panel3        panel3
	 * @param  MainGUI       mainGui
	 * @param  People        people
	 * @param  SomeDataClass someData
	 */
	public ButtonListener3(Panel3 panel3, MainGUI mainGui , People people , SomeDataClass someData){
		 this.panel3=panel3;
		 this.mainGui=mainGui;
		 this.people=people;
		 this.someData = someData;
	}

	/**
	 * Method for the action of the button clicked
	 *creates a new person and adds it to the arrayList of People
	 *It sets back the values of the panel to its origin
	 * @param ActionEvent e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if(button.getName().equals("save")){
				People thePeople = new People(panel3.getFirst(), panel3.getSurname() , panel3.getNum() , panel3.getCapacity() , someData);
				people.add_People(thePeople);
				panel3.getFirstNameField().setText("");
				panel3.getSurnameField().setText("");
				panel3.getEmployeeNoField().setText("");
				panel3.getSkillSlider().setValue(5);
		}
	}
}
