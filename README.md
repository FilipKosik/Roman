# Roman
Demo of conversion to and from simple Roman numerals as a simple web app


## Implementation Notes
Unfortunately, I am really busy and I cannot "play” with a super nice solution. I used Spring Boot with an embedded *Tomcat* (in *Spring Boot Web*). *Guava* is used because of `ImmutableBiMap` (immutable bidirectional map with unique values and keys + providing method `invert`).
There is no client framework/library (e.g. *JSF*) for front-end. It is a plain *HTML*, *CSS* and *JS* that directly calls REST API running on the *Tomcat*. It seems to me as a waisting of my time and overkill for such a simple task.

Let me know, if you are really interested in me and you need more. I will try to implement something more sophisticated but I cannot guarantee when I have enough time for that. 


## Tests 
Demo includes unit tests using *JUniper* (*JUnit 5* as a default Spring Boot dependency). Dependency is available in project (through *Maven*). 


## Launch
1. Clone this project.
2. Build the project using *Maven* (use default m2 settings.xml for this project if your IDE is not using it, eg if you use company maven repository).
3. Run the project (*Tomcat* is embedded, no need for deployment, just run it as Java Application). Use main method in `RomanNumeralConverterApp` class.
4. Developed under *Java 8* (*Adopt Open JDK 8* was used for both compilation and runtime of the project). Do not use older Java version.


