package study1;

public class Validation {
	
	public static boolean negativeCheck(String[] numbers) {
		for(String str : numbers) {
			negativeparseInt(str);
		}
		return false;
	}
	public static boolean negativeparseInt(String str) {
		if (Integer.parseInt(str) < 0) {
			throw new RuntimeException();
		}
		return false;
	}
}
