1. Prerequisites:
------------------------
Before running the automation script, ensure the following software and tools are installed on your machine
	1. Java Development Kit (JDK)
		a. Install the latest JDK (Java 8 or higher).
		b. Verify installation by running java -version in the terminal/command prompt.

	2. Eclipse IDE (or any Java-compatible IDE)
		a. Download and install Eclipse IDE for Java Developers.

	3. Maven (for dependency management)
		a. Install Maven and ensure it's added to your system's PATH.
		b. Verify installation by running mvn -version.

	4. TestNG Plugin for Eclipse

		a. Open Eclipse and install TestNG from the Eclipse Marketplace.

	5. Google Chrome Browser

		a. Ensure the latest version of Google Chrome is installed.

	6. ChromeDriver

		a. Download the ChromeDriver version matching your Chrome browser version from ChromeDriver Downloads.
		b. Place the executable in a directory (e.g., D:\Chrome Driver\chromedriver.exe).

2. Setting Up the Automation Project:
------------------------------------------
	1. Create a Maven Project
		a. Open Eclipse and create a new Maven project (File > New > Maven Project).
		b. Use the archetype: maven-archetype-quickstart.

	2. Add Dependencies to pom.xml Add the following dependencies to your pom.xml:

	<dependencies>
    	     <!-- Selenium Dependency -->
    	     <dependency>
       		 <groupId>org.seleniumhq.selenium</groupId>
       		 <artifactId>selenium-java</artifactId>
       		 <version>4.13.0</version>
    	</dependency>

    	<!-- TestNG Dependency -->
    	<dependency>
        	<groupId>org.testng</groupId>
       	 	<artifactId>testng</artifactId>
        	<version>7.7.1</version>
   	 </dependency>
	</dependencies>
3. Set Up the Directory Structure Organize your project as follows:
---------------------------------------------------------------------

src
├── main
│   ├── java
│   │   └── com.Utilities
│   │       └── BaseTest.java
│   ├── resources
└── test
    ├── java
    │   └── Fitpeo.Fitpeo
    │       └── FitpeoTest.java
    ├── resources

4. Add the Code
----------------------------
	a. Copy BaseTest.java into the com.Utilities package.
	b. Copy FitpeoPageElements.java and FitpeoTest.java into their respective packages.

5.  Running the Script
----------------------------
	1. Modify the ChromeDriver Path
		a. Ensure the System.setProperty line in BaseTest.java points to the correct ChromeDriver location:
		b. System.setProperty("webdriver.chrome.driver", "D:\\Chrome Driver\\chromedriver.exe");
6. Run the Tests
-------------------
	a. Open FitpeoTest.java.
	b. Right-click and select Run As > TestNG Test.
	c. The script will execute the test cases.
7. View Results
------------------------
	a. Check the console for logs and assertions.
	b. TestNG will generate an HTML report in the test-output folder of your project.



