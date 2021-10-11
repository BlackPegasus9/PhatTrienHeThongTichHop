package secondWeek_e3;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class SynchronizedMethod {
	synchronized void writeFile(String fileName){
		try{	
			Scanner sc = new Scanner(System.in);
			System.out.printf("Input the file name: ");
			fileName = sc.nextLine();
            FileWriter fw = new FileWriter(fileName);
            System.out.printf("Input the data:");
            String data = sc.nextLine();
            fw.write(data);
            System.out.printf(Thread.currentThread().getName() + " is running. " + data +" is add to the file " + fileName + "\n");
            fw.close();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
	}
	synchronized void readFile(String fileName){
		try {
			Scanner sc = new Scanner(System.in);
			System.out.printf("Input the file name: ");
			fileName = sc.nextLine();
			FileReader fr = new FileReader(fileName);
			int i;
	        while ((i = fr.read()) != -1) {
	            System.out.print(Thread.currentThread().getName() + " is running. " + (char) i + "\n");
	        }
	        fr.close();
	        Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
	}
}
