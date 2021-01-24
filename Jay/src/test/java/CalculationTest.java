import m.*;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.TreeMap;
public class CalculationTest{


@Test
public void testAssignments2Tasks1Person1Requirement(){
  SomeDataClass sdc = new SomeDataClass();
  People enio = new People("enio", "kaso", "123456789", 5 , sdc) ;
  ArrayList<Task> tasksToDO = new ArrayList<Task>();
  ArrayList<Task> requirements = new ArrayList<Task>();
  Task first = new Task("UnitTest", 3, tasksToDO, 5 ,1 , sdc);
  requirements.add(first);
  tasksToDO.add(first);
  Task second = new Task("IntegrationTest", 2, tasksToDO, 6 ,7 , sdc);
  tasksToDO.add(second);
  TreeMap<Task, ArrayList<People>> expected = new TreeMap(new MyComp());
  ArrayList<People> peopleArrayList = new ArrayList<People>();
  peopleArrayList.add(enio);
  sdc.setPeoples(peopleArrayList);
  sdc.setTasks(tasksToDO);
  TreeMap<Task,ArrayList<People>> actual = sdc.calculations();
  System.out.println(actual.firstKey().endTime());
  assertEquals( 9, actual.firstKey().endTime());

}


@Test
public void testAssignments3Tasks1Person2requirements(){
  SomeDataClass sdc = new SomeDataClass();
  People enio = new People("enio", "kaso", "123456789", 5 , sdc);
  //People enio = new People("henry", "valeyre", "321654987", 8 , sdc);
  ArrayList<Task> tasksToDO = new ArrayList<Task>();
  ArrayList<Task> requirements = new ArrayList<Task>();
  Task first = new Task("UnitTest", 3, tasksToDO, 5 ,1 , sdc);
  requirements.add(first);
  tasksToDO.add(first);
  Task second = new Task("IntegrationTest", 2, requirements, 6 ,7 , sdc);
  tasksToDO.add(second);
  Task third = new Task("Aix", 1, tasksToDO, 2 ,3 , sdc);
  tasksToDO.add(third);
  TreeMap<Task, ArrayList<People>> expected = new TreeMap(new MyComp());
  ArrayList<People> peopleArrayList = new ArrayList<People>();
  peopleArrayList.add(enio);
  sdc.setPeoples(peopleArrayList);
  sdc.setTasks(tasksToDO);
  TreeMap<Task,ArrayList<People>> actual = sdc.calculations();
  System.out.println(actual.firstKey().endTime());
  assertEquals( 10, actual.firstKey().endTime());
}


@Test
public void testAssignments1Tasks2Person(){
  SomeDataClass sdc = new SomeDataClass();
  People enio = new People("enio", "kaso", "123456789", 5 , sdc);
  People henry = new People("henry", "valeyre", "321654987", 8 , sdc);
  ArrayList<Task> tasksToDO = new ArrayList<Task>();
  ArrayList<Task> requirements = new ArrayList<Task>();
  Task first = new Task("UnitTest", 3, tasksToDO, 5 ,1 , sdc);
  tasksToDO.add(first);
  TreeMap<Task, ArrayList<People>> expected = new TreeMap(new MyComp());
  ArrayList<People> peopleArrayList = new ArrayList<People>();
  peopleArrayList.add(enio);
  peopleArrayList.add(henry);
  sdc.setPeoples(peopleArrayList);
  sdc.setTasks(tasksToDO);
  TreeMap<Task,ArrayList<People>> actual = sdc.calculations();
  assertEquals( 4, actual.firstKey().endTime());
}

@Test
public void testAssignments2Tasks2PersonSame(){
  SomeDataClass sdc = new SomeDataClass();
  People enio = new People("enio", "kaso", "123456789", 5 , sdc);
  People henry = new People("henry", "valeyre", "321654987", 8 , sdc);
  ArrayList<Task> tasksToDO = new ArrayList<Task>();
  ArrayList<Task> requirements = new ArrayList<Task>();
  Task first = new Task("UnitTest", 3, tasksToDO, 5 ,1 , sdc);
  tasksToDO.add(first);
  requirements.add(first);
  TreeMap<Task, ArrayList<People>> expected = new TreeMap(new MyComp());
  ArrayList<People> peopleArrayList = new ArrayList<People>();
  Task second = new Task("IntegrationTest", 2, requirements, 6 ,7 , sdc);
  tasksToDO.add(second);
  peopleArrayList.add(enio);
  peopleArrayList.add(henry);
  sdc.setPeoples(peopleArrayList);
  sdc.setTasks(tasksToDO);
  TreeMap<Task,ArrayList<People>> actual = sdc.calculations();
  assertEquals(9, actual.firstKey().endTime());
}


@Test
public void testAssignments2Tasks2PersonDifferent(){
  SomeDataClass sdc = new SomeDataClass();
  People enio = new People("enio", "kaso", "123456789", 5 , sdc);
  People henry = new People("henry", "valeyre", "321654987", 8 , sdc);
  ArrayList<Task> tasksToDO = new ArrayList<Task>();
  ArrayList<Task> requirements = new ArrayList<Task>();
  Task first = new Task("UnitTest", 3, requirements, 5 ,1 , sdc);
  TreeMap<Task, ArrayList<People>> expected = new TreeMap(new MyComp());
  ArrayList<People> peopleArrayList = new ArrayList<People>();
  Task second = new Task("IntegrationTest", 2, requirements, 6 ,7 , sdc);
  tasksToDO.add(first);
  tasksToDO.add(second);
  peopleArrayList.add(enio);
  peopleArrayList.add(henry);
  sdc.setPeoples(peopleArrayList);
  sdc.setTasks(tasksToDO);
  TreeMap<Task,ArrayList<People>> actual = sdc.calculations();
  assertEquals(3, actual.firstKey().endTime());
}

@Test
public void testAssignments3Tasks5Person(){
  SomeDataClass sdc = new SomeDataClass();
  People enio = new People("enio", "kaso", "123456789", 1 , sdc);
  People henry = new People("henry", "valeyre", "321654987", 1 , sdc);
  People sam = new People("sam", "kaso", "123456789", 1 , sdc);
  People jason = new People("jason", "valeyre", "321654987", 1 , sdc);
  People ming = new People("ming", "kaso", "123456789", 1 , sdc);
  ArrayList<Task> tasksToDO = new ArrayList<Task>();
  ArrayList<Task> requirements = new ArrayList<Task>();
  Task first = new Task("UnitTest", 3, requirements, 1 ,5 , sdc);
  TreeMap<Task, ArrayList<People>> expected = new TreeMap(new MyComp());
  ArrayList<People> peopleArrayList = new ArrayList<People>();
  Task second = new Task("IntegrationTest", 2, requirements, 1 ,7 , sdc);
  requirements.add(first);
  requirements.add(second);
  Task third = new Task("IntegrationTest", 2, requirements, 1 ,7 , sdc);
  tasksToDO.add(first);
  tasksToDO.add(second);
  tasksToDO.add(third);
  peopleArrayList.add(enio);
  peopleArrayList.add(henry);
  peopleArrayList.add(sam);
  peopleArrayList.add(jason);
  peopleArrayList.add(ming);
  sdc.setPeoples(peopleArrayList);
  sdc.setTasks(tasksToDO);
  TreeMap<Task,ArrayList<People>> actual = sdc.calculations();
  assertEquals(3, actual.firstKey().endTime());
}

}
