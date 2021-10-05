package secondWeek_e1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FileTWrite extends Thread{
	private String fileName;
	
	@Override
	public void run() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.printf("Input the file name:");
			fileName = sc.nextLine();
			System.out.printf("Input the number of elements of int array:");
			int n = sc.nextInt();
			try (FileWriter fw = new FileWriter(fileName)) {
				for(int i=0;i<n;i++) {
					int ranNum = ThreadLocalRandom.current().nextInt(1,10); //khởi tạo số nguyên trong khoảng 1-9
					String s = Integer.toString(ranNum);
					fw.write(s);
					System.out.printf(Thread.currentThread().getName() + " is running. " + ranNum +" is add to the file " + fileName + "\n");
				}
			}	
			} catch (IOException e) {
				e.printStackTrace();
			}	
		
	}
	
}
