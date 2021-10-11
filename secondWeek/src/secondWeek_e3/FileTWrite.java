package secondWeek_e3;

public class FileTWrite extends Thread{
	private String fileName;
	SynchronizedMethod s;
	
	public FileTWrite(SynchronizedMethod s) {
		this.s = s;
	}
	
	@Override
	public void run() {	
		s.writeFile(fileName);
	}

}
