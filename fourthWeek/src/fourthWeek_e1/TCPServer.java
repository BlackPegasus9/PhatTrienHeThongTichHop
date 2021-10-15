package fourthWeek_e1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public final static int serverPort = 7;
	public static void main(String[] args) throws IOException{
		try {
			ServerSocket ss = new ServerSocket(serverPort);
			System.out.println("Server is created.");
			while(true) {
				try {
					Socket s = ss.accept();
					InputStream is = s.getInputStream();
					OutputStream os = s.getOutputStream();
					DataInputStream dis = new DataInputStream(is);
					DataOutputStream dos = new DataOutputStream(os);
					String receiver;
					while(true) {
						receiver = dis.readUTF();
						char ch[] = receiver.toCharArray();
						if(Character.isDigit(ch[0])) {
							if(receiver.equalsIgnoreCase("0"))
								dos.writeUTF("Khong.");
							else if(receiver.equalsIgnoreCase("1"))
								dos.writeUTF("Mot.");
							else if(receiver.equalsIgnoreCase("2"))
								dos.writeUTF("Hai.");
							else if(receiver.equalsIgnoreCase("3"))
								dos.writeUTF("Ba.");
							else if(receiver.equalsIgnoreCase("4"))
								dos.writeUTF("Bon.");
							else if(receiver.equalsIgnoreCase("5"))
								dos.writeUTF("Nam.");
							else if(receiver.equalsIgnoreCase("6"))
								dos.writeUTF("Sau.");
							else if(receiver.equalsIgnoreCase("7"))
								dos.writeUTF("Bay.");
							else if(receiver.equalsIgnoreCase("8"))
								dos.writeUTF("Tam.");
							else if(receiver.equalsIgnoreCase("9"))
								dos.writeUTF("Chin.");
						}
						else {
							dos.writeUTF("Khong phai so nguyen.");
						}
						s.close();
					}			
			}catch(Exception ie1) {
				System.out.println("Connection Error " + ie1);	
				}
			}
		}catch(IOException ie) {
			System.out.println("Connection Error " + ie);
		}
	}
}
