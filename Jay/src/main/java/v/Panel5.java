package v;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import c.MainGUI;
import c.ButtonListener1;
import c.ButtonListener3;
import m.SomeDataClass;
import c.ButtonListener5;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import m.Task;
import m.People;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;

/**
 *
 * Panel5
 * This is the Panel that displays the board manager and allows us
 * to see who got assigned to which task at which period of time
 * @author Samuel
 *
 */
public class Panel5 extends JPanel implements Observer {

	private JScrollPane firstPanelScroll;
	private JLabel titleLabel;
	private JLabel firstNameLabel;
	private JLabel skillLabel;
	private String titleText;
	private JPanel newTaskContent;
	private JSlider skillSlider;
	private JTextField firstNameField;
	private JButton backButton;
	private JLabel surnameLabel;
	private JTextField surnameField;
	private JLabel employeeNoLabel;
	private JTextField employeeNoField;
	private ActionListener buttonController;
	private String invalidString;
	private JProgressBar progressBar4;
	private SomeDataClass someData;
	private MainGUI mainGui;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table;



	/**
	 * Constructor method for Panel3. Sets fields.
	 * Finally, sets up Panel1 GUI.
	 *
	 * @param mainGUI
	 *
	 * @param someData
	 */
	public Panel5(SomeDataClass someData, MainGUI mainGui) {

		this.someData = someData;

		this.mainGui = mainGui;

		this.someData.addObserver(this);

		titleText = "SCHEDULE OF WORK (TO-DO)<br>";
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel secondPanelCenter = new JPanel();
		secondPanelCenter.setLayout(new GridLayout(1,1));

		this.add(secondPanelCenter, BorderLayout.CENTER);

		myLabels();

		backButton = new JButton("Back");
		table = new JTable(model);
		table.setName("managerBoard");
		model.addColumn("Task Name");
		model.addColumn("People");
		model.addColumn("Start Time");
		model.addColumn("End Time");

	  JScrollPane pane = new JScrollPane(table);
		buttonController = new ButtonListener5(this, mainGui);
		backButton.setName("back");
		backButton.addActionListener(buttonController);

		newTaskContent.add(titleLabel);

		firstNameField = new JTextField();

		surnameField = new JTextField();
		employeeNoField = new JTextField();

		newTaskContent.add(pane);
		newTaskContent.add(backButton);

		firstPanelScroll = new JScrollPane(newTaskContent);

		secondPanelCenter.add(firstPanelScroll);

		titleLabel.setHorizontalAlignment(JLabel.CENTER);

		this.setVisible(true);

	}
	/**
	 * This will update our view whenever the model is modified
	 * It displays a new table for the Board Manager according to the someData class
	 * @param Observable arg0
	 * @param Object arg1
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		model.setRowCount(0);
		someData.calculations();
		for(Map.Entry<Task,ArrayList<People>> entry : someData.getTheEnd().entrySet()) {
  			Task key = entry.getKey();
  			ArrayList<People> value = entry.getValue();
  			model.addRow(new Object[] { key.getName() , myFunction(value) , key.getStartTime() , key.endTime()});
		}
	}
	/**
	* This gets all the the people's name that got assigned to a task
	* @param ArrayList<People>  myPeople
	*/
	public ArrayList<String> myFunction(ArrayList<People> myPeople){
		ArrayList<String> myString = new ArrayList<String>();
		for(People thePeople : myPeople){
			myString.add(thePeople.getSurname());
		}
		return myString;
	}
	/**
	* This gives a name and a content to all the labels
	*/
	public void myLabels(){
		newTaskContent = new JPanel();
		newTaskContent.setLayout(new BoxLayout(newTaskContent, BoxLayout.Y_AXIS));
		titleLabel = new JLabel("<html><div style='text-align: center;'>" + titleText + "</div></html>");
		firstNameLabel = new JLabel("<html><div style='text-align: center;'><br>Person 1:</div></html>");
		surnameLabel = new JLabel("<html><div style='text-align: center;'><br>Person 2:</div></html>");
		employeeNoLabel = new JLabel("<html><div style='text-align: center;'><br>Person 3:</div></html>");
		skillLabel = new JLabel("<html><div style='text-align: center;'><br>Person 4:</div></html>");

	}

}
