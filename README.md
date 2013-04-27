final-frontier
==============

A demonstration of how the autorun registry hack adversely affects directory creation using java's File object.

Steps to reproduce:

1. Enable the registry hack to run a command as soon as you open a cmd prompt as follows:
	- Create a new String value called Autorun in HKEY_CURRENT_USER\Software\Microsoft\Command Processor
	- Set it's value to :  cd /d "c:\dev\"
	- Open a cmd prompt to see whether the directory automatically changes to c:\dev

2. Run the test contained in this project by doing a 'mvn clean test' from the root.
	Expected Result : The test would fail.

3. Delete the Autorun key in HKEY_CURRENT_USER\Software\Microsoft\Command Processor and re-run the test.
	Result : The test passes.



Details of the error message :
java.lang.RuntimeException: Error writing to file: some-dir/target/generated-resources/stuff.xmlwith the following error: 
Couldn't create dir: some-dir\target\generated-resources
        at com.test.build.TestFileCreation.createDirectoryTest(TestFileCreation.


So the Question is : Why does the Autorun entry affect a java process ?!

