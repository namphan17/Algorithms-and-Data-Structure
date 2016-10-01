import java.util.logging.*;
public class Logger {
	public static void main(String[] args) {
		Logger dumb = Logger.getLogger(Logger.class.getName());
		dumb.setLevel(Level.INFO);
	}

}
