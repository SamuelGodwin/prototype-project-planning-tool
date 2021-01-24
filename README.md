# Jay
Enio Kaso , 
Jaysen Munsami , 
Ming Xuan Wu , 
Samuel Godwin , 
Henry Valeyre

#

For our application, we made a Kanban Board at the start and thought about some tests in advance. We thought, initially, that the application would need a login and that we had to manually set people to a task, at a specific time and state when they finish this task. We later realized that we were slightly on the wrong track and that everything should be set-up automatically. The aforementioned factors would instead be calculated in our Work Schedule. We took this on board and pursued development accordingly.

# Synopsis
In our program the user is able to create People to work on tasks, and assign them: an estimated ability in completing tasks, a first name, surname and an optional Employee Number (should they have one). Furthermore, you can create a Task with: its own estimated effort, name and estimated time in which to do it (this changes depending on the complexity of the task and the capacity or number of people working on it). A task is also given a maximum number of people that can work on it, as well as any additional requirements/dependencies that the task may require. These requirements are tasks that require completion before you can start the task you are currently creating. The user is able to view the dashboard to see all the data they have created, in tables, and they can view a Work Schedule that will automatically display the most efficient way a person(s) can do which task(s) at what times.

# Development
The Project was developed in Java and its interface in Java Swing.

# Gradle

In order to run with Gradle, you should type in the command line "gradle run" - if Gradle is installed and you have the correct version of Java.

# Tests
In order to run the tests implemented along the creation of our project you will need to run this command line "gradle test --info" . It will run some UNIT Test and some integration testing that us automaton

# Possible Errors

It is possible that you get errors and that it is not possible to run and build gradle , for such maybe you need to move to the file that contains the gradle.build.
Or you will maybe need to create a .properties with your java jdk
