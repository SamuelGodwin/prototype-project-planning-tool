import m.*;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import com.athaydes.automaton.Swinger;
import javax.swing.ListModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.ArrayList;
import static com.athaydes.automaton.selector.StringSelectors.matchingAny;
public class DriverIntegrationTest{

  @Test
  public void testManagerBoard(){
    new  c.MainGUI();
    Swinger swinger = Swinger.forSwingWindow();
    swinger.pause(500);
    swinger.clickOn("name:new task")
            .pause(500)
            .clickOn("name:nameField")
            .type("integration test using automaton")
            .pause(500)
            .clickOn("type:JSpinner")
            .type("1")
            .pause(500)
            .clickOn("name:save")
            .pause(500)

            .clickOn("name:nameField")
            .type("unit test")
            .pause(500)
            .clickOn("type:JSpinner")
            .pause(500)
            .clickOn("name:save")
            .pause(500)

            .clickOn("name:nameField")
            .type("unit test example")
            .pause(500)
            .clickOn("type:JSpinner")
            
            .pause(500)
           
            .clickOn("name:integration test using automaton")
            .clickOn("name:save")

            .clickOn("name:add people")
            .pause(500)
            .clickOn("name:firstNameField")
            .type("Enio")
            .pause(500)
            .clickOn("name:surnameField")
            .type("Kaso")
            .pause(500)
            .clickOn("name:save")

            .clickOn("name:add people")
            .pause(500)
            .clickOn("name:firstNameField")
            .type("First Name")
            .pause(500)
            .clickOn("name:surnameField")
            .type("Last Name")
            .pause(500)
            .clickOn("name:save")
            
            .clickOn("name:dashboard")
            .pause(500)
            .clickOn("name:display managers")

            .pause(500)
            ;

    swinger.clickOn("name:managerBoard");
    TableModel people = ((JTable)swinger.getAt("name:managerBoard")).getModel();


        assertEquals("integration test using automaton",people.getValueAt(0,0));
        assertEquals("kaso",((ArrayList<String>)people.getValueAt(0,1)).get(0));
        assertEquals(0,people.getValueAt(0,2));
        assertEquals(11,people.getValueAt(0,3));

        assertEquals("unit test",people.getValueAt(1,0));
        assertEquals("last name",((ArrayList<String>)people.getValueAt(1,1)).get(0));
        assertEquals(0,people.getValueAt(1,2));
        assertEquals(1,people.getValueAt(1,3));

        assertEquals("unit test example",people.getValueAt(2,0));
        assertEquals("kaso",((ArrayList<String>)people.getValueAt(2,1)).get(0));
        assertEquals(11,people.getValueAt(2,2));
        assertEquals(12,people.getValueAt(2,3));

        swinger.clickOn("name:dashboard");
  }

  

}
