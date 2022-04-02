# Roman
Demo of conversion to and from simple Roman numerals as a simple web app

## Implementation Notes
Unfortunately, I am really busy and I cannot "play” with a super nice solution. I used Spring Boot with an embedded Tomcat (in Spring Web). There is no client framework/library (e.g. JSF) for front-end. It is a plain HTML, JS and CSS that calls REST API running on the Tomcat. It seems to be overkill for such a simple task.

Let me know, if you are really interested in me and you need more. I will try to implement something more sophisticated but I cannot guarantee when I have enough time for that. 

## Launch
* Open the project. 
* Build the project using Maven (use default m2 settings.xml). 
* Run the project (Tomcat is embedded, no need for deployment, just run it as Java Application). Use main method in RomanNumeralConverterApp.
* Developed under Java 8 (using Adopt Open JDK 8 for both compilation and runtime).
