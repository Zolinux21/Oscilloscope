package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCP {
	static DataInputStream in;
    static DataOutputStream out;
    static Socket socket;
    static boolean ConnectionIsAlive = false;
    
    static boolean Connect() {
    	try {
            socket = new Socket("localhost", 3555);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
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

}
