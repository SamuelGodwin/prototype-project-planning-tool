package v;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import c.ButtonListener2;
import c.MainGUI;
import m.SomeDataClass;
import m.Task;

/**
 *
 * This is the class for the panel2 that will display the Task creator
 *
 * @author Samuel, Henry
 *
 */
@SuppressWarnings("deprecation")
public class Panel2 extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	private JScrollPane firstPanelScroll;
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel effortLabel;
	private JLabel checkLabel;
	private JLabel reqLabel;
	private String titleText;
	private JPanel newTaskContent;
	private JSlider effortSlider;
	private JTextField nameField;
	private JSpinner amountOfPerson;
	private JLabel peopleToAdd;
	private JButton plusButton;
	private JButton saveButton;
	private ActionListener buttonController;
	private MainGUI mainGui;
	private String invalidString;
	private SomeDataClass someData;
	private JComboBox<Task> tasksTo;
	private Task tasks;
	private String nameContent="";
	private int effortContent=5;
	private JSpinner theTime;
	private JLabel selectTime;
	private int timeContent=1;
	private int amountToAdd=1;
	private JCheckBox check;
	private ArrayList<Task> checkboxes;
	private JLabel noLabel;
	private ArrayList<Task> theArray = new ArrayList<Task>();
	private ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();
	private JLabel maximumLabel;


	/**
	 * Constructor method for Panel2. Sets someData field of this class as a
	 * reference to the object someData passed as a parameter.
	 * Finally, sets up Panel1 GUI.
	 *
	 * @param SomeDataClass someData
	 * @param MainGui       mainGui
	 */
	public Panel2(SomeDataClass someData, MainGUI mainGui) {
		ArrayList<Task> checkboxes = new ArrayList<Task>();
		tasks = new Task(nameContent , effortContent , checkboxes , timeContent , amountToAdd , someData);
		this.someData = someData;
		this.mainGui = mainGui;
		tasks.addObserver(this);
		titleText = "NEW TASK<br>";
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel secondPanelCenter = new JPanel();
		secondPanelCenter.setLayout(new GridLayout(1,1));

		this.add(secondPanelCenter, BorderLayout.CENTER);

		JPanel containerNewTask = new JPanel();
		containerNewTask.setLayout(new GridBagLayout());

		newTaskContent = new JPanel();
		newTaskContent.setLayout(new BoxLayout(newTaskContent, BoxLayout.Y_AXIS));
		myLabels();
		saveButton = new JButton("Save");

		saveButton.setEnabled(false);
		newTaskContent.add(titleLabel);
		newTaskContent.add(nameLabel);
		nameField = new JTextField();
		nameField.setName("nameField");
		newTaskContent.add(nameField);
		SpinnerModel value = new SpinnerNumberModel(1,1,1000,1);
		amountOfPerson = new JSpinner(value);

		amountOfPerson.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
	         amountToAdd = (int) ((JSpinner)e.getSource()).getValue();
	        }});

		SpinnerModel values = new SpinnerNumberModel(1,1,1000,1);
		theTime = new JSpinner(values);
		theTime.setName("setTime");
		theTime.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	         timeContent = (int) ((JSpinner)e.getSource()).getValue();
	        }});

	    newTaskContent.add(selectTime);
		newTaskContent.add(theTime);
		nameField.addKeyListener((KeyListener) new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	                if(isString(nameField.getText())==false || nameField.getText().isEmpty()) {
	                	saveButton.setEnabled(false);
	                }else {
	                	saveButton.setEnabled(true);
	                }
	        }
		});
		effortSlider = new JSlider(1, 10);
		effortSlider.setName("effortSlider");
		effortSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  effortContent = effortSlider.getValue();

		      }
		    });
		effortSlider.setMajorTickSpacing(1);
		effortSlider.setPaintTicks(true);
		effortSlider.setPaintLabels(true);

		newTaskContent.add(effortLabel);
		newTaskContent.add(effortSlider);
		newTaskContent.add(maximumLabel);
		newTaskContent.add(amountOfPerson);
		saveButton.setName("save");

		buttonController = new ButtonListener2(this, mainGui , tasks , someData);

		saveButton.addActionListener(buttonController);

		newTaskContent.add(saveButton);

		containerNewTask.add(newTaskContent);
		// 'firstPanelScroll' contains 'containerNewTask'.
		firstPanelScroll = new JScrollPane(containerNewTask);
		secondPanelCenter.add(firstPanelScroll);

		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		this.setVisible(true);

	}
	/**
	 * This will update our view whenever the model is modified
	 * It displays the new Task panel according to the Task class
	 * It adds the check boxes
	 * @param Observable arg0
	 * @param Object arg1
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		createCheckBoxes();
		revalidate();
		repaint();
	}
	/**
	* creation of the check boxes according to thr elements contained in the Task class
	* enables the ability to use the checkboxes and set the requirements from there in the controller for it to be used in the model
	*/
	public void createCheckBoxes(){
		if(!boxes.isEmpty()) {
			for(JCheckBox myBox : boxes) {

				newTaskContent.remove(myBox);

			}
			boxes.clear();
		}
		saveButton.setEnabled(false);
		theArray = tasks.getTasks();
		checkboxes = new ArrayList<Task>();
		if(!theArray.isEmpty()) {
			newTaskContent.add(checkLabel);
			for(Task element : theArray) {
				final JCheckBox box = new JCheckBox(element.getName() , false);
				box.setName(element.getName());
				boxes.add(box);
				box.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent actionEvent) {
				        if(box.isSelected()) {
				        	String theBox = box.getText();
				        	for(Task toadd : theArray) {
				        		if(toadd.getName().equals(theBox)) {
				        			checkboxes.add(toadd);
				        			tasks.setRequirements(checkboxes);
				        		}
				        	}
				        }else {
				        	String theBox = box.getText();
				        	for(Task toadd : theArray) {
				        		if(toadd.getName().equals(theBox)) {
				        			checkboxes.remove(toadd);
				        			tasks.setRequirements(checkboxes);
				        		}
				        	}
				        }
					}});
			    newTaskContent.add(box);
			}
		}else {
			newTaskContent.add(noLabel);
		}
		newTaskContent.remove(saveButton);
		newTaskContent.add(saveButton);
	}

	/**
	* Checks whether a string correctly is a string and does not contain any number
	*/
	public boolean isString(String s){
    	boolean hasNoNum=false;
		if(s != null){
        	for(int i = 0; i < s.length(); i++){
            	if(!Character.isDigit(s.charAt(i))){
                	 hasNoNum = true;
            	}else {
            		return false;
            	}
        	}
    	}
        return hasNoNum;
	}

	/**
	* gets the name contained in the text field
	*/
	public String getName() {
		return nameField.getText();
	}
	/**
	* gets the time that it would take for a task to be done
	*/
	public int getTime() {
		return timeContent;
	}
	/**
	* gets the complexity of a task
	*/
	public int getCapacity() {
		return effortContent;
	}
	/**
	* gets the requirements needed to complete a task
	*/
	public ArrayList<Task> getRequirements(){
		if(checkboxes == null) {
			checkboxes = new ArrayList<Task>();
			return checkboxes;
		}
		return checkboxes;
	}
	/**
	* gets the task itself
	*/
	public Task getTask(){
		return tasks;
	}
	/**
	* gets the maximum amount of people allowed to have per task
	*/
	public int getPeople(){
		return amountToAdd;
	}
	/**
	* gets the effortSlider itself so that we can reset its values when the Observer is updated
	*/
	public JSlider getEffortSlider() {
		return effortSlider;
	}
	/**
	* gets the nameField itself so that we can reset its content when the Observer is updated
	*/
	public JTextField getNameField() {
		return nameField;
	}
	/**
	* gets the time itself so that we can reset its values when the Observer is updated
	*/
	public JSpinner getTheTime() {
		return theTime;
	}
	/**
	* gets the mac amount of person as a slider so that we can reset its values when the Observer is updated	*/
	public JSpinner getThePeople() {
		return amountOfPerson;
	}

	/**
	* This gives a name and a content to all the labels
	*/
	public void myLabels(){
		titleLabel = new JLabel("<html><div style='text-align: center;'>" + titleText + "<br></div></html>");
		nameLabel = new JLabel("<html><div style='text-align: center;'><br>Task Name<br>(non-numeric characters only):</div></html>");
		selectTime = new JLabel("<html><div style='text-align: center;'><br>Estimated No. Hours:</div></html>");
		effortLabel = new JLabel("<html><div style='text-align: center;'><br>Estimated Effort:</div></html>");
		maximumLabel = new JLabel("<html><div style='text-align: center;'><br>Maximum No. People for This Task:</div></html>");
		reqLabel = new JLabel("<html><div style='text-align: center;'><br>Task Requirements:</div></html>");
		checkLabel = new JLabel("<html><div style='text-align: center;'><br>Select a prerequisite(*):</div></html>");
		noLabel = new JLabel("<html><div style='text-align: center;'><br>No prerequisite for the moment :</div></html>");
	}

}
