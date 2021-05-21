package utils;

public class StringUtils {

	private StringUtils(){
		// empty
	}

	public static String[] split(String delimiter, String text) {
		if(isEmpty(delimiter)
		   || isEmpty(text)){
			return null;
		}
		return text.split(delimiter);
	}

	public static boolean isEmpty(final String text){
		if(null == text
		   || text.isEmpty()){
			return true;
		}
		return false;
	}
}
