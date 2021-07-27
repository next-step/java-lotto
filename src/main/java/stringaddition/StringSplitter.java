package stringaddition;

public class StringSplitter {

	public static final String DELIMITER = ",|:";

	public String[] split(String text) {
		return text.split(DELIMITER);
	}

}
