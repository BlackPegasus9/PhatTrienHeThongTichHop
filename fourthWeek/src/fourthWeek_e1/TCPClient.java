package fourthWeek_e1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
	public final static String serverIP = "127.0.0.1";
	public final static int serverPort = 7;
	public static void main(String[] args) throws InterruptedException, IOException{
		Socket s = null;
		try {
			s = new Socket(serverIP, serverPort);
			System.out.println("Client is created");
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			Scanner sc = new Scanner(System.in);
			System.out.println("Input the number:");
			String i = sc.nextLine();
			dos.writeUTF(i);
			String message_from_sv = dis.readUTF();
			System.out.println(message_from_sv);
			
		}catch (IOException ie) {
			System.out.println("Error: Can NOT create socket");
		}finally {
			if(s!= null) {
				s.close();
			}
		}

	}

}
