package fourthWeek_e4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

public static void main(String args[]) throws IOException{


    InetAddress address=InetAddress.getLocalHost();
    Socket s=null;
    String i=null;
    InputStream is = null;
	OutputStream os = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	Scanner sc = null;

    try {
    	s = new Socket(address, 2345);
		System.out.println("Client is created");
		System.out.println("Options: ");
		System.out.println("\n1. Print Time");
		System.out.println("\n2. Print Date");
		System.out.println("\n3. Print Date and Time");
		is = s.getInputStream();
		os = s.getOutputStream();
		dis = new DataInputStream(is);
		dos = new DataOutputStream(os);	
    }
    catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception");
    }

    try{
    	sc = new Scanner(System.in);
    	System.out.println("Input your choice:");
    	i = sc.nextLine();
    	dos.writeUTF(i);
		String message_from_sv = dis.readUTF();
		System.out.println(message_from_sv);
    }
    catch(IOException e){
    }
    finally{
        s.close();
        System.out.println("Connection Closed");
    }

}
}