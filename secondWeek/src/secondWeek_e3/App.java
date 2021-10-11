package secondWeek_e3;

public class App {

	public static void main(String[] args) {
		SynchronizedMethod s = new SynchronizedMethod();
		FileTWrite t1 = new FileTWrite(s);
		FileTReader t2 = new FileTReader(s);
		FileTWrite t3 = new FileTWrite(s);
		FileTReader t4 = new FileTReader(s);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
