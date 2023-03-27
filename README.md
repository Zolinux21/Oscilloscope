# Oscilloscope
Működés:
1. fekete háttér
2. omxplayer boot video lejátszása, fekete háttér marad
3. maga a játék
4. kész a játék
5. feketedoboz -> video lejátsz

boot : INT; -> boot video play
//oszcilloszkóp
kapcsolo_tabla_done : INT; -> megjelenik a játék és játszható
oszcilloszkop_done  : INT; -> ha kész a játék elküldi a PLC-nek
fekete_doboz	    : INT; -> ha bead akkor lejátsza a koordinata videot
oszcilloszkop_skip  : INT; -> ha skip akkor beáll megoldásra és várja hogy


java --module-path PATH_OF_FX/lib --add-modules javafx.controls -jar games.jar

Raspberry:
java --module-path /usr/share/openjfx/lib  --add-modules javafx.controls -jar osci.jar

Ubuntu:
java --module-path /home/narancsikon/JavaFx/openjfx-19_linux-x64_bin-sdk/javafx-sdk-19/lib --add-modules javafx.controls -jar osci.jar
