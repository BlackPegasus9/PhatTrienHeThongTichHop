package secondWeek_e3;

public class FileTReader extends Thread{
	private String fileName;
	SynchronizedMethod s;
	
	public FileTReader(SynchronizedMethod s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		s.readFile(fileName);
	}
}
