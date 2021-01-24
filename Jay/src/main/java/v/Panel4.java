/**
 * 
 */
package v;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import c.ButtonListener4;
import c.MainGUI;
import m.SomeDataClass;

/**
 *  
 * Class description
 * 
 * @author Samuel
 *
 */
public class Panel4 extends JPanel {

	private JScrollPane firstPanelScroll;
	private JLabel titleLabel;
	private String titleText;
	private JPanel newTaskContent;
	private String instructionsText;
	private JLabel instructionsLabel;
	private JButton backButton;
	private ButtonListener4 buttonController;
	private MainGUI mainGui;

	/**
	 * Constructor method for Panel4. Sets fields.
	 * Finally, sets up Panel4 GUI.
	 * 
	 * @param someData
	 */
	public Panel4(SomeDataClass someData, MainGUI mainGui) {	
				
		titleText = "Instructions<br>";
		instructionsText = "<br>You should be<br> able to create <br>several People and<br> to create Task <br> , after from <br>the dashboard you<br> will see tables<br> that hold the <br>tasks and people <br>you created . It is by <br>clicking on display<br> manager that you <br>will be able <br>to see your <br>actual planning in <br>a form of <br>a table.";

		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel secondPanelCenter = new JPanel();
		secondPanelCenter.setLayout(new GridLayout(1,1)); 
						
		this.add(secondPanelCenter, BorderLayout.CENTER);
		
		JPanel containerNewTask = new JPanel();
		containerNewTask.setLayout(new GridBagLayout()); 
		
		backButton = new JButton("Back to dashboard");

		buttonController = new ButtonListener4(this, mainGui);
		backButton.setName("back");
		backButton.addActionListener(buttonController);
		
		newTaskContent = new JPanel();
		newTaskContent.setLayout(new BoxLayout(newTaskContent, BoxLayout.Y_AXIS));
		titleLabel = new JLabel("<html><div style='text-align: center;'>" + titleText + "</div></html>");
		instructionsLabel = new JLabel("<html><div style='text-align: center;'>" + instructionsText + "</div></html>");		
		
		newTaskContent.add(titleLabel);
		newTaskContent.add(instructionsLabel);
		newTaskContent.add(backButton);
		
		containerNewTask.add(newTaskContent);
		
		// 'firstPanelScroll' contains 'containerNewTask'.
		firstPanelScroll = new JScrollPane(containerNewTask);
		// 'secondPanelCenter' contains 'firstsPanelScroll'.
		secondPanelCenter.add(firstPanelScroll);

		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		//nameLabel.setHorizontalAlignment(JLabel.CENTER);
		//skillLabel.setHorizontalAlignment(JLabel.CENTER);
		//reqLabel.setHorizontalAlignment(JLabel.CENTER);
		
		this.setVisible(true);

	}
}
