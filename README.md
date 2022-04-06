# Roman
Interview demo of conversion to and from Roman numerals. Created as a simple web app.


## Implementation Notes
Unfortunately, I am really busy and I cannot "play” with a super nice solution. I used Spring Boot with an embedded *Tomcat* (in *Spring Boot Web*). 
*Guava* is used because of `ImmutableBiMap` (immutable bidirectional map with unique values and keys + providing method `invert`).

There is no advanced client framework/library (e.g. *JSF*, *React*) for front-end. It is a plain *HTML*, *CSS* and *jQuery* that directly calls REST API running on the *Tomcat*. It seems to me as a waste of my time and expensive work for such a simple task.

There could be additional refactoring/implementation changes in case of more complex or production application, e.g. use of custom exceptions. Interfaces `MyRomanNumeralConverter` and `RomanNumeralConverter` can be merged if both are internal but I worked with it as a third-party interface (because `RomanNumeralConverter` was a part of task assignment).

## Tests 
Demo includes unit tests using *JUniper* (*JUnit 5* as a default Spring Boot dependency). Dependency is available in project (through *Maven*). 


## Launch
1. Clone this project.
2. Build the project using *Maven* (use default m2 settings.xml for this project if your IDE is not using it, eg if you use company maven repository).
3. Run the project (*Tomcat* is embedded, no need for deployment, just run it as Java Application). Use main method in `RomanNumeralConverterApp` class.
4. Developed under *Java 8* (*Adopt Open JDK 8* was used for both compilation and runtime of the project). Do not use older Java version.
5. Application will run on localhost and port 8077. Change the port in `application.yml` if needed.

Note: The web application requires the **Internet** because jQuery is not hosted but Google CDN is used. jQuery source should be added for production and/or offline deployment.

Note 2: This is standalone application (with embedded Tomcat). If you want relaunch, restart the application to **stop its previous instance.** Otherwise, you will run multiple instances but you have to use a different ports for them.
