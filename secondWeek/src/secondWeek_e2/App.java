package secondWeek_e2;

public class App {

	public static void main(String[] args) {
		FileTReader t1 = new FileTReader();
		FileTReader t2 = new FileTReader();
		FileTReader t3 = new FileTReader();
		
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
