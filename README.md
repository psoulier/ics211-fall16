#ICS-211 Lab - Fall 2016

## Check Content of JAR File
After exporting a project into a JAR file from Eclipse, there are two ways to check what's in the
file:
1. From the command line:
```
$ jar tf archive.jar
```
Where "archive.jar" is whatever file the project was exported to.
2. For some reason (mostly Windows systems), the jar command isn't in the path. An alternative is to
   import the JAR file from eclipse. Eclipse will show the contents of the file. NOTE: make sure you
   don't actually import the file and overwrite an existing project.

## Running JUnit from Command Line
Compiling source requires JUnit jar, running JUnit tests additionally requires Hamcrest.  The last
parameter to #3 below is the test case class to execute. The commands below assume the JUnit JAR
files are in the local directory.
1. Download JUnit and Hamcrest from JUnot.org
2. Compile source: `javac -cp .:./junit-4.12.jar <java source>`
3. Run JUnit: `ava -cp .:./junit-4.12.jar:./hamcrest-core-1.3.jar  org.junit.runner.JUnitCore
   MyArrayListTest`
