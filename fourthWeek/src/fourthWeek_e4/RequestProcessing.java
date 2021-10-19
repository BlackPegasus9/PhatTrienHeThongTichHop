package fourthWeek_e4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RequestProcessing extends Thread{  

    String choice=null;
    Socket s=null;
    InputStream is = null;
	OutputStream os = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;

    public RequestProcessing(Socket s){
        this.s=s;
    }

    public void run() {
    try{
    	is = s.getInputStream();
		os = s.getOutputStream();
		dis = new DataInputStream(is);
		dos = new DataOutputStream(os);

    }catch(IOException e){
        System.out.println("IO error in request processing.");
    }

    try {
    	String choice = dis.readUTF();
        while(true){
        	switch(choice) {
			case "1":
				LocalTime time = LocalTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				String Time = time.format(formatter);
				dos.writeUTF(Time);
				break;
			case "2":
				LocalDate date = LocalDate.now();
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String Date = date.format(formatter1);
				dos.writeUTF(Date);		
				break;
			case "3":
				LocalDateTime dateTime = LocalDateTime.now();
				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
				String DateTime = dateTime.format(formatter2);
				dos.writeUTF(DateTime);
				break;	
			default:
				break;
				}
        	return;
        	}   
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }finally{    
	    try{
	        System.out.println("Connection Closing..");
	        if (s!=null){
	        s.close();
	        System.out.println("Socket Closed");
	        }
	       }
	    catch(IOException ie){
	        System.out.println("Socket Close Error");
	        return;
	    	}
	    }
    }
}
