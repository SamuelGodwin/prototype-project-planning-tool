/**
 *
 */
package v;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import c.ButtonListener1;
import c.MainGUI;
import m.SomeDataClass;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;
import m.Task;
import java.util.ArrayList;
import m.People;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Class description
 *
 * @author Samuel, Henry
 *
 */
public class Panel1 extends JPanel implements Observer{

	private JScrollPane firstPanelScroll;
	private JButton newTaskButton;
	private JLabel label;
	private JLabel label2;
	private String titleText;
	private SomeDataClass someData;
	private JPanel containsLabels;
	private ButtonListener1 buttonController;
	private MainGUI mainGui;
	private JLabel tasksLabel;
	private JLabel peopleLabel;
	private JButton newPeopleButton;
	private JButton displayMgrsButton;
	private JButton deleteButton;
	private JTable table;
	private JTable table2;
	private JScrollPane pane2;
	private DefaultTableModel model = new DefaultTableModel();
	private DefaultTableModel dataModel = new DefaultTableModel();

	/**
	 * Constructor method for Panel1. Sets fields of this class to object references
	 * passed as a parameters.Displays the table with the list of tasks and peoples
	 * Finally, sets up Panel1 GUI.
	 *
	 * @param SomeDataClass someData
	 * @param MainGui       mainGui
	 */
	public Panel1(SomeDataClass someData, MainGUI mainGui) {

		this.someData = someData;
		this.mainGui = mainGui;
		this.someData.addObserver(this);
		titleText = "DASHBOARD<br>";
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JPanel firstPanelCenter = new JPanel();
		firstPanelCenter.setLayout(new GridLayout(1,1));
		containsLabels = new JPanel();
		containsLabels.setLayout(new BorderLayout());
		this.add(firstPanelCenter, BorderLayout.CENTER);
		JPanel containsLabelContainer = new JPanel();
		containsLabelContainer.setLayout(new GridBagLayout());
		containsLabels = new JPanel();
		containsLabels.setLayout(new BoxLayout(containsLabels, BoxLayout.Y_AXIS));
		myLabels();

		table = new JTable(model);
		table2 = new JTable(dataModel);

		JScrollPane pane = new JScrollPane(table);

		pane2 = new JScrollPane(table2);

		createTables();

		button();


		JPanel northFlow = new JPanel();
		northFlow.setLayout(new FlowLayout());

		northFlow.add(label);

		JPanel midPane = new JPanel();
		midPane.setLayout(new BorderLayout());

		JPanel tableTitles = new JPanel();
		tableTitles.setLayout(new BorderLayout());

		JPanel westFlow = new JPanel();
		westFlow.setLayout(new FlowLayout());
		westFlow.add(tasksLabel);

		JPanel eastFlow = new JPanel();
		eastFlow.setLayout(new FlowLayout());
		eastFlow.add(peopleLabel);

		tableTitles.add(westFlow, BorderLayout.WEST);
		tableTitles.add(eastFlow, BorderLayout.EAST);

		JPanel tableFlow = new JPanel();
		tableFlow.setLayout(new FlowLayout());

		tableFlow.add(pane);
		tableFlow.add(pane2);

		midPane.add(tableTitles, BorderLayout.NORTH);
		midPane.add(tableFlow, BorderLayout.SOUTH);

		JPanel southFlow = new JPanel();
		southFlow.setLayout(new FlowLayout());

		southFlow.add(displayMgrsButton);

		containsLabels.add(northFlow, BorderLayout.NORTH);
		containsLabels.add(midPane, BorderLayout.CENTER);
		containsLabels.add(southFlow, BorderLayout.SOUTH);

		containsLabelContainer.add(containsLabels);

		firstPanelScroll = new JScrollPane(containsLabelContainer);

		firstPanelCenter.add(firstPanelScroll);

		label.setHorizontalAlignment(JLabel.CENTER);

		this.setVisible(true);

	}

	/**
	 * This will update our view whenever the model is modified
	 * It displays the Actual new tables of peoples and tasks according to the values contained in the data class
	 * @param Observable arg0
	 * @param Object arg1
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		int j=0;
		model.setRowCount(0);
		dataModel.setRowCount(0);
		someData.calculations();
	 	for(Task myTask : someData.getTasks()){
	 		model.addRow(new Object[] { myTask.getName() , myTask.getCapacity() , myTask.getPeople() , myFunction(myTask) , myTask.getTime() , j});
	 		j+=1;
	 	}

	 	for(People myPeople : someData.getPeoples()){
	 		dataModel.addRow(new Object[] { myPeople.getFirstName() , myPeople.getSurname() , myPeople.getEmployeeNum() , myPeople.getCapacity()});
	 	}

	}
	/**
	 * This will display all the ids of requirements that a task has
	 */
	ArrayList<Integer> myFunction(Task theTask){
		ArrayList<Integer> myList = new ArrayList<Integer>();
		if(theTask.getRequirements().isEmpty()){
			return myList;
		}
		for(int i = 0 ; i < theTask.getRequirements().size();i++){
			myList.add(i);
		}
		return myList;
	}
	/**
	 * creates the actual column titles for our two tables
	 */
	public void createTables(){

		table.setName("taskTable");
		model.addColumn("Task Name");
		model.addColumn("Effort");
		model.addColumn("Max People");
		model.addColumn("Requirements");
		model.addColumn("Time Set");
		model.addColumn("Task ID");

		table2.setName("employeeTable");
		dataModel.addColumn("First Name");
		dataModel.addColumn("Surname");
		dataModel.addColumn("Employee No");
		dataModel.addColumn("Capacity");

	}
	/**
	 * This is used to create our button that is used to display the manager
	 */
	public void button(){
		buttonController = new ButtonListener1(this, mainGui);
		displayMgrsButton.setName("display managers");
		displayMgrsButton.addActionListener(buttonController);
	}
	/**
	* This gives a name and a content to all the labels
	*/
	public void myLabels(){
		label = new JLabel("<html><div style='text-align: center;'>" + titleText + "</div></html>");
		tasksLabel = new JLabel("<html><div style='text-align: center;'>" + "TASKS" + "</div></html>");
		peopleLabel = new JLabel("<html><div style='text-align: center;'>" + "PEOPLE" + "</div></html>");
		displayMgrsButton = new JButton("Work Schedule");
	}

}
