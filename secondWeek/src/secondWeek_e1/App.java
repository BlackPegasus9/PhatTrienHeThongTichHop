package secondWeek_e1;

public class App {

	public static void main(String[] args) {
		FileTWrite t1 = new FileTWrite();
		FileTWrite t2 = new FileTWrite();
		FileTWrite t3 = new FileTWrite();
		
		t1.start();
		
		try {
            t1.join();
        } catch (Exception e) {
            System.out.println(e);
        }
		
		t2.start();
		
		try {
            t2.join();
        } catch (Exception e) {
            System.out.println(e);
        }
		
		t3.start();
	}

}
