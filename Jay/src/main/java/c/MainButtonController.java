/**
 *
 */
package c;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import m.SomeDataClass;
import v.Panel3;
import v.Panel1;
import v.Panel2;

/**
 * Class checking for action events matching buttons in the main ui tab bar:
 * Dashboard, New Task, Add People, Refresh
 * Invokes respective MainGUI methods.
 * @author Samuel
 *
 */
public class MainButtonController implements ActionListener {

	private MainGUI maingui;
	private SomeDataClass someData;
	private Panel1 firstPanel;
	private Panel2 panel2;
	private Panel3 panel3;

	/**
	 * Constructor method for MainButtonController. Sets fields in this class
	 * to object references passed as parameters.
	 * This class is passed a copy of someData, through which it accesses stored data.
	 * @param maingui
	 * @param someData
	 * @param panel2
	 * @param panel3
	 */
	public MainButtonController(MainGUI maingui, SomeDataClass someData, Panel2 panel2, Panel3 panel3){
		this.maingui = maingui;
		this.someData = someData;
		this.panel2 = panel2;
		this.panel3 = panel3;
		firstPanel = maingui.getPanel1();
	}

	/**
	 * Below are the events which take place when buttons in MainGUI are pressed.
	 */
	public void actionPerformed(ActionEvent e){

		JButton button = (JButton) e.getSource();

		if(button.getName().equals("dashboard")) {
			maingui.enterDashboard();
		}

		else if(button.getName().equals("new task")) {
			maingui.enterNewTask();
		}

		else if(button.getName().equals("add people")) {
			maingui.enterAddPeople();
		}

		else if(button.getName().equals("help")) {
			maingui.enterOther();
		    JOptionPane.showMessageDialog(null, "instructions as pop-up :D");
		}

//		else if(button.getName().equals("refresh")){
//			//someData.doStuffData();
//			System.out.println("Refresh!");
//		}
	}
}
