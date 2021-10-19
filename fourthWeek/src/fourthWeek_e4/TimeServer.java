package fourthWeek_e4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TimeServer {
public static void main(String args[]){


    Socket s = null;
    ServerSocket ss = null;
    try{
        ss = new ServerSocket(2345);
        System.out.println("Server is created.");
    }
    catch(IOException e){
    System.out.println("Server error: " + e);

    }

    while(true){
        try{
            s= ss.accept();
            System.out.println("Connect Successfully.");
            RequestProcessing rp=new RequestProcessing(s);
            rp.start();         
        }
    catch(IOException e){
        e.printStackTrace();
        System.out.println("Connection Error");
    }
    }

}

}

