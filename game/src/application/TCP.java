package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class TCP {
	static DataInputStream in;
    static DataOutputStream out;
    static Socket socket;
    static boolean ConnectionIsAlive = false;
    static String IpAddress = "";
    static int Port = 5656;
    
    static boolean Connect() {
    	try {
            socket = new Socket(IpAddress, Port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    static boolean write(String message) {
    	String response = null;
    	try {
        	out.writeUTF(message);
            response = in.readUTF();
            if(response.equals("writeDone#")) {
            	return true;
            }
            else {
            	return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            ConnectionIsAlive = false;
        } 
    	return false;
    }
    
    static int read(String message) {
    	String response = null;
    	String[] splited = null;
    	try {
        	out.writeUTF(message);
            response = in.readUTF();
            splited = response.split("#");
            return Integer.parseInt(splited[0]);
        } catch (IOException e) {
            e.printStackTrace();
            ConnectionIsAlive = false;
        } 
    	return 0;
    }
    
    static void run() {
    	try {
        	Thread.sleep(1000);
        	out.writeUTF("Hallo");
            String message = in.readUTF();
            System.out.println("Server: " + message);
        } catch (IOException e) {
            e.printStackTrace();
            ConnectionIsAlive = false;
        } catch (InterruptedException e) {
			e.printStackTrace();
			ConnectionIsAlive = false;
		}
    }
    
    static void ReadConfigFile() {
    	try {
    	      File configFile = new File("/home/narancsikon/git/Resources/config.txt");
    	      Scanner myScanner = new Scanner(configFile);
    	      IpAddress = myScanner.nextLine();
    	      Port = Integer.parseInt(myScanner.nextLine());
    	      System.out.println(IpAddress);
    	      System.out.println(Port);
    	      myScanner.close();
    	    } catch (FileNotFoundException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    }

}
