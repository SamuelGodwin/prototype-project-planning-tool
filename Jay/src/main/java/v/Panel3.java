package v;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import c.ButtonListener3;
import c.MainGUI;
import m.People;
import m.SomeDataClass;

/**
 *
 * Class description
 *
 * @author Samuel, Henry
 *
 */
public class Panel3 extends JPanel implements Observer {


	private JScrollPane firstPanelScroll;
	private JLabel titleLabel;
	private JLabel firstNameLabel;
	private JLabel skillLabel;
	private String titleText;
	private SomeDataClass someData;
	private JPanel newTaskContent;
	private JSlider skillSlider;
	private JTextField firstNameField;
	private JButton saveButton;
	private JLabel surnameLabel;
	private JTextField surnameField;
	private JLabel employeeNoLabel;
	private JTextField employeeNoField;
	private MainGUI mainGui;
	private ActionListener buttonController;
	private String invalidString;
	private boolean name1=false;
	private boolean name2=false;
	private int capacity=5;
	private String firstName = "";
	private String surname = "";
	private String employeeNum = "";
	private People people;
	private JLabel keyLabel;

	/**
	 * Constructor method for Panel3. Sets fields.
	 * displaying of the People panel that lets the user create people
	 * Finally, sets up Panel1 GUI.
	 *
	 * @param SomeDataClass  someData
	 * @param MainGui        mainGui
	 */
	public Panel3(SomeDataClass someData, MainGUI mainGui) {
		people = new People(firstName , surname , employeeNum , capacity , someData);
		people.addObserver(this);
		this.someData = someData;

		this.mainGui = mainGui;

		titleText = "ADD A PERSON<br>";
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel secondPanelCenter = new JPanel();
		secondPanelCenter.setLayout(new GridLayout(1,1));

		this.add(secondPanelCenter, BorderLayout.CENTER);

		JPanel containerNewTask = new JPanel();
		containerNewTask.setLayout(new GridBagLayout());

		newTaskContent = new JPanel();
		newTaskContent.setLayout(new BoxLayout(newTaskContent, BoxLayout.Y_AXIS));
		saveButton = new JButton("Save");
		saveButton.setEnabled(false);
		buttonController = new ButtonListener3(this, mainGui , people , someData);
		myLabels();
		saveButton.setName("save");
		saveButton.addActionListener(buttonController);

		newTaskContent.add(titleLabel);
		newTaskContent.add(firstNameLabel);
		firstNameField = new JTextField();
		firstNameField.setName("firstNameField");
		newTaskContent.add(firstNameField);
		firstNameField.addKeyListener((KeyListener) new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	                if(isString(firstNameField.getText())==false || firstNameField.getText().isEmpty()) {
	                	name1=false;
	                	isItCorrect();
	                }else {
	                	name1=true;
	                	isItCorrect();
	                }
	        }
		});
		newTaskContent.add(surnameLabel);
		surnameField = new JTextField();
		surnameField.setName("surnameField");
		surnameField.addKeyListener((KeyListener) new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	                if(isString(surnameField.getText())==false || surnameField.getText().isEmpty()) {
	                	name2=false;
	                	isItCorrect();
	                }else {
	                	name2=true;
	                	isItCorrect();
	                }
	        }
		});
		newTaskContent.add(surnameField);
		newTaskContent.add(employeeNoLabel);
		employeeNoField = new JTextField();
		surnameField.addKeyListener((KeyListener) new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {

	        }
		});
		newTaskContent.add(employeeNoField);
		newTaskContent.add(skillLabel);
		skillSlider = new JSlider(1, 10);
		skillSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  capacity = skillSlider.getValue();

		      }
		    });
		skillSlider.setMajorTickSpacing(1);
		skillSlider.setPaintTicks(true);
		skillSlider.setPaintLabels(true);
		newTaskContent.add(skillSlider);
		newTaskContent.add(saveButton);
		newTaskContent.add(keyLabel);

		containerNewTask.add(newTaskContent);

		firstPanelScroll = new JScrollPane(containerNewTask);
		secondPanelCenter.add(firstPanelScroll);

		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		this.setVisible(true);

	}
	/**
	 * Gets the actual first name field to be able to access it and set its original values when called in the controller and when the view is updated
	 */
	public JTextField getFirstNameField() {
		return firstNameField;
	}
	/**
	 * Gets the actual surname field to be able to access it and set its original values when called in the controller and when the view is updated
	 */
	public JTextField getSurnameField() {
		return surnameField;
	}

	/**
	 * checks if a text is correctly a string and contains no digits
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
	 * checks if the surname and the first name are both strings to be able to enable the save button
	 */
	public void isItCorrect() {
		if(name1==true && name2==true) {
			saveButton.setEnabled(true);
		}else {
			saveButton.setEnabled(false);
		}
	}

	/**
	 * gets the first name
	 */
	public String getFirst() {
		return firstNameField.getText();
	}

	/**
	 * gets the surname
	 */
	public String getSurname() {
		return surnameField.getText();
	}

	/**
	 * gets the employee number
	 */
	public String getNum() {
		return employeeNoField.getText();
	}

	/**
	 * gets the capacity of a person
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Gets the actual skills slider to be able to access it and set its original values when called in the controller and when the view is updated
	 */
	public JSlider getSkillSlider() {
		return skillSlider;
	}

	/**
	* Gets the actual employee number field to be able to access it and set its original values when called in the controller and when the view is updated
	*/
	public JTextField getEmployeeNoField() {
		return employeeNoField;
	}

	/**
	 * This will update our view whenever the model is modified
	 * It displays a new People panel according to the People class
	 * Sets back the original values
	 * @param Observable arg0
	 * @param Object arg1
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		saveButton.setEnabled(false);
		name1= false;
		name2=false;
		revalidate();
		repaint();
	}

	/**
	* This gives a name and a content to all the labels
	*/
	public void myLabels(){
		titleLabel = new JLabel("<html><div style='text-align: center;'>" + titleText + "</div></html>");
		firstNameLabel = new JLabel("<html><div style='text-align: center;'><br>Name (*):</div></html>");
		surnameLabel = new JLabel("<html><div style='text-align: center;'><br>Surname (*):</div></html>");
		employeeNoLabel = new JLabel("<html><div style='text-align: center;'><br>Employee Number (if any):</div></html>");
		skillLabel = new JLabel("<html><div style='text-align: center;'><br>Employee Skill Estimate:</div></html>");
		keyLabel = new JLabel("<html><div style='text-align: center;'><br>Fields marked with an asterisk (*) are required.</div></html>");

	}




}
