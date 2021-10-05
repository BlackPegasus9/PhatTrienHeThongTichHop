package secondWeek_e2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileTReader extends Thread{
	private String fileName;
	
	@Override
	public void run() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.printf("Input the file name:");
			fileName = sc.nextLine();
		
			FileReader fr = new FileReader(fileName);
			int i;
	        while ((i = fr.read()) != -1) {
	            System.out.print(Thread.currentThread().getName() + " is running. " + (char) i + "\n");
	        }
	        fr.close();
            
		} catch (IOException e) {
			e.printStackTrace();	
		}	
	}
}
