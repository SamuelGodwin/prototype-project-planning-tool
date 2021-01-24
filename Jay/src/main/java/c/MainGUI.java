/**
 *
 */
package c;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import m.SomeDataClass;
import v.Panel1;
import v.Panel2;
import v.Panel3;
import v.Panel4;
import v.Panel5;

/**
 * Class description
 *
 * @author Samuel
 *
 */
public class MainGUI {

	private JFrame window = new JFrame("SEG Agile Project");
	private JPanel topBar; // topmost bar of application
	private JPanel contentPane; // panel that holds each of our JPanels, i.e. the content
	private JPanel bottomBar; // bottommost bar of application, holds button, textarea
	private JButton newPeopleButton;
	private JButton newTaskButton;
	private JButton dashBoardButton;
	private JLabel bottomText;
	private JButton refreshButton;
	private ArrayList<JPanel> ContentPanels;
	private int panelIndex = 0;
	private MainButtonController buttonController;
	private Panel1 firstPanel;
	private Panel3 thirdPanel;
	private Panel2 secondPanel;
	private Panel4 fourthPanel;
	private Panel5 displayPanel;
	private JButton helpButton;


	/**
	 * Constructor method for MainGUI. Creates an object of someData.
	 * This method also sets up MainGUI's user interface.
	 *
	 */
	public MainGUI() {
		SomeDataClass someData = new SomeDataClass();

		//Create panels
		firstPanel = new Panel1(someData, this);
		secondPanel = new Panel2(someData, this);
		thirdPanel = new Panel3(someData, this);
		fourthPanel = new Panel4(someData, this);
		displayPanel = new Panel5(someData, this);
		//peoplePanel = new Panel6(someData, this);

		ContentPanels = new ArrayList();
		ContentPanels.add(firstPanel);
		ContentPanels.add(secondPanel);
		ContentPanels.add(thirdPanel);
		ContentPanels.add(fourthPanel);
		ContentPanels.add(displayPanel);

		createWindow();

		//Create tabs
		topBar = new JPanel();
		topBar.setLayout(new FlowLayout(FlowLayout.CENTER));
		window.add(topBar, BorderLayout.NORTH);
		buttonController = new MainButtonController(this, someData, secondPanel, thirdPanel);

		dashBoardButton = new JButton("Dashboard");
		topBar.add(dashBoardButton, BorderLayout.WEST);
		dashBoardButton.setName("dashboard");
		dashBoardButton.addActionListener(buttonController);
		dashBoardButton.setEnabled(false);

		newTaskButton = new JButton("New Task");
		topBar.add(newTaskButton, BorderLayout.WEST);
		newTaskButton.setName("new task");
		newTaskButton.addActionListener(buttonController);

		newPeopleButton = new JButton("Add People");
		topBar.add(newPeopleButton, BorderLayout.WEST);
		newPeopleButton.setName("add people");
		newPeopleButton.addActionListener(buttonController);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		window.add(contentPane, BorderLayout.CENTER);

		//Create bottom toolbar
		bottomBar = new JPanel();
		bottomBar.setLayout(new BorderLayout());
		window.add(bottomBar, BorderLayout.SOUTH);

		//Bottom toolbar message
		bottomText = new JLabel("SEG AGILE PROJECT TEAM JAY", SwingConstants.CENTER);
		bottomBar.add(bottomText, BorderLayout.CENTER);

		//bottom toolbar help button
		helpButton = new JButton("Help");
		bottomBar.add(helpButton, BorderLayout.EAST);
		helpButton.setName("help");
		helpButton.addActionListener(buttonController);

		contentPane.add(firstPanel);

		render();

	}
	/**
	 *This creates the window accordingly to our tastes
	 */
	public void createWindow(){
		window.setSize(1000, 800);
		window.setPreferredSize(new Dimension(1000, 800));
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 *Allows us to see our frame
	 */
	public void render(){
		window.pack();
		window.setVisible(true);
	}

	/**
	 * This method allows us to enter the dashboard by setting the according panel index and sets some other buttons to
	 * As we should not be able to access them while being on the Dahsboard
	 */
	public void enterDashboard() {
			contentPane.remove(ContentPanels.get(panelIndex));
			panelIndex = 0;
			contentPane.repaint();
			contentPane.add(ContentPanels.get(panelIndex));

			contentPane.repaint();
			window.setVisible(true);

			dashBoardButton.setEnabled(false);
			newTaskButton.setEnabled(true);
			newPeopleButton.setEnabled(true);

	}

	/**
	 * This method allows us to enter the Task panel by setting the according panel index and sets some other buttons to
	 * As we should not be able to access them while being on the Task panel
	 */
	public void enterNewTask() {
			contentPane.remove(ContentPanels.get(panelIndex));
			panelIndex = 1;
			//contentPane.revalidate();
			contentPane.repaint();
			contentPane.add(ContentPanels.get(panelIndex));

			contentPane.repaint();
			window.setVisible(true);

			dashBoardButton.setEnabled(true);
			newTaskButton.setEnabled(false);
			newPeopleButton.setEnabled(true);
	}

	/**
	 * This method allows us to enter the People panel by setting the according panel index and sets some other buttons to
	 * As we should not be able to access them while being on the People panel
	 */
	public void enterAddPeople() {
			contentPane.remove(ContentPanels.get(panelIndex));
			panelIndex = 2;
			contentPane.repaint();
			contentPane.add(ContentPanels.get(panelIndex));
			contentPane.repaint();
			window.setVisible(true);

			dashBoardButton.setEnabled(true);
			newTaskButton.setEnabled(true);
			newPeopleButton.setEnabled(false);
	}

	
	public void enterOther() {
			contentPane.remove(ContentPanels.get(panelIndex));
			panelIndex = 3;
			contentPane.repaint();
			contentPane.add(ContentPanels.get(panelIndex));
			contentPane.repaint();
			window.setVisible(true);

			dashBoardButton.setEnabled(true);
			newTaskButton.setEnabled(true);
			newPeopleButton.setEnabled(true);
	}	
	
	/**
	 * This method allows us to display the Manager/planning panel by setting the according panel index and sets some other buttons to
	 * As we should not be able to access them while being on the Manager panel
	 */
	public void enterDisplayMgrs() {
		contentPane.remove(ContentPanels.get(panelIndex));
		panelIndex = 4;
		contentPane.repaint();
		contentPane.add(ContentPanels.get(panelIndex));
		contentPane.repaint();
		window.setVisible(true);
		
		dashBoardButton.setEnabled(true);
		newTaskButton.setEnabled(true);
		newPeopleButton.setEnabled(true);
	}
	


	/**
	 * Sets size of JFrame window, based on passed parameters x and y.
	 *
	 * @param x
	 * @param y
	 */
	public void setSize(int x, int y) {
		window.setSize(x, y);
	}

	/**
	 * Sets whether or not JFrame window is resizable, based on boolean passed parameter x.
	 *
	 * @param x
	 */
	public void setResizeable(boolean x) {
		window.setResizable(x);
	}

	/**
	 * This is an accessor method for firstPanel.
	 *
	 * @return firstPanel, (instance of Panel1, extends JPanel).
	 */
	public Panel1 getPanel1() {
		return firstPanel;
	}

}
