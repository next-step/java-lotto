package wootecam.calculator;

import java.util.List;

public interface StringTokenizer {
	List<String> getNumbers(String input);

	boolean supportForTokenizing(String input);
}
