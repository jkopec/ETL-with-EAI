# ETL with EAI

Enterprise Application Integration
Gruppenaufgabe (2 Leute)

"The ETL (Extract, Transform, Load) is a mechanism for loading data into systems or databases using some kind of Data Format from a variety of sources; often files then using Pipes and Filters, Message Translator and possible other Enterprise Integration Patterns.
So you could query data from various Camel Components such as File, HTTP or JPA, perform multiple patterns such as Splitter or Message Translator then send the messages to some other Component.
To show how this all fits together, try the ETL Example." [1]

ETL ist ein wichtiger Prozess bei einem Datawarehouse. Zeigen Sie wie Enterprise Integration Patterns [2] dabei eingesetzt werden können (8 Punkte, nur jene, die in dem Beispiel vorkommen). Verwenden Sie dazu das ETL Example [3]. Dokumentieren Sie die Implementierung sowie alle notwendigen Schritte ausführlich in einem Protokoll (8 Punkte). Fügen Sie den verwendeten Code nach den Metaregeln an und geben Sie alles als ZIP-Archiv (Gesamtes Framework mit Anleitung, wie das System gestartet werden kann) ab.

# Protokoll der Inbetriebnahme

+ git repository erstellt
   link: https://github.com/jkopec/ETL-with-EAI.git
+ Neues Java Projekt in Eclipse erstellt und mit git repository verbunden
+ Eclipse: Help->Marketplace nach "Maven" gesucht
+ Eclipse: M2Eclipse war aber bereits installiert
+ apache-camel-2.14.1.tar.gz heruntergeladen
   link: http://tweedo.com/mirror/apache/camel/apache-camel/2.14.1/apache-camel-2.14.1.tar.gz
+ apache-camel-2.14.1 entpackt
+ src Ordner aus: "apache-camel-2.14.1/examples/camel-example-etl/" kopiert und den von Eclipse generierten
   Ordner durch den eben kopierten ersetzt
+ pom.xml aus: "apache-camel-2.14.1/examples/camel-example-etl/" kopiert und in die Eclipse workspace eingefügt
+ dependency in pom.xml hinzugefügt
   link: http://camel.apache.org/camel-eclipse.html
   dependency:
    <dependency>
      <groupId>org.apache.camel</groupId>
      <artifactId>camel-eclipse</artifactId>
      <version>2.14.1</version>
      <!-- use the same version as your Camel core version -->
    </dependency>
+ Eclipse geschlossen und in eclipse.ini mehr Arbeitsspeicher zugewiesen
   link: http://camel.apache.org/building.html
   unter mac osx: /Applications/Eclipse Java/Eclipse.app/Contents/MacOS/eclipse.ini
   Eintrag von -Xmx512m auf -Xmx1536m geändert
+ Eclipse wieder geöffnet
+ Rechtsklick auf das Projekt Configure -> Convert to Maven Project
+ Programm ausgeführt
