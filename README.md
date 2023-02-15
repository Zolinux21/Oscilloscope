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
