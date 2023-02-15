package application;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
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
    	byte[] bMeassage;
    	byte[] data = new byte[1024];
    	try {
    		bMeassage = message.getBytes(StandardCharsets.US_ASCII);
        	out.write(bMeassage);
        	int length = socket.getInputStream().read(data);
        	System.out.println("Received data: " + new String(data, 0, length));
        	if(data[0] == 111 && data[1] == 107)// ASCII code: "ok" = 111;107
        	{
        		System.out.println("write succesfully");
        		System.out.println("-------------------------");
        		return true;
        	}else if(data[0] == 110 && data[1] == 111 && data[2] == 107) // ASCII code "nok"
        	{
        		System.out.println("Incorrect write command (NOK)");
        		System.out.println("-------------------------");
        		return false;
        	}
            
        } catch (IOException e) {
            e.printStackTrace();
            ConnectionIsAlive = false;
        } 
    	return false;
    }
    
    static int read(String message) {
    	byte[] bMeassage;
    	byte[] data = new byte[1024];
    	int value = 0;
    	try {
    		bMeassage = message.getBytes(StandardCharsets.US_ASCII);
        	out.write(bMeassage);
        	int length = socket.getInputStream().read(data);
        	System.out.println(message + ": " + new String(data, 0, length));
        	System.out.println("-------------------------");
        	value = Integer.parseInt(new String(data, 0, length));   
        } catch (IOException e) {
            e.printStackTrace();
            ConnectionIsAlive = false;
        } 
    	return value;
    }
    
    static void run() {
    	try {
        	Thread.sleep(1000);
        	out.writeBytes("Hallo");
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
    		
    		/*String sourceFilePathTemp = TCP.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    		String sourceFilePath = "1" + sourceFilePathTemp + "asd";
    		int lastSlashIndex = sourceFilePath.lastIndexOf("/");
    		//String[] arrOfStr = sourceFilePath.split("/", lastSlashIndex);
    		String lastWord = sourceFilePath.substring(sourceFilePath.length() - 1);
    		
    		for(int i = 0; i < sourceFilePath.length() + lastSlashIndex; i++) {
    			sourceFilePath += sourceFilePath.substring(sourceFilePath.length() - (lastSlashIndex - i));
    		}
    		System.out.println("The last word is: " + lastWord);

    		
    		System.out.println("The source file path is: " + sourceFilePath);
    		
    	    File configFile = new File(sourceFilePath);*/
    	    File configFile = new File("/home/narancsikon/git/Resources/config.txt");
    		//File configFile = new File("/home/admin/config.txt");
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
