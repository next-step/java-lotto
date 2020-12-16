package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public int calculate(String input) {
		// null 또는 빈문자열
		if (input == null || input.isEmpty()) {
			return 0;
		}
		String[] numArray;
		// 커스텀 구분자 체크
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (matcher.find()) {
			numArray = matcher.group(2).split(matcher.group(1));
		} else {
			// 숫자 하나 문자열
			numArray = input.split(",|:");
		}
		// 음수 포함 시 Exception 발생
		for (String num : numArray) {
			if (num.startsWith("-")) {
				throw new RuntimeException("음수는 입력이 불가합니다.");
			}
		}

		if (numArray.length == 1) {
			return Integer.parseInt(numArray[0]);
		}
		// 숫자 두개 콤마 문자열
		int result = 0;
		for (String num : numArray) {
			result += Integer.parseInt(num);
		}
		return result;
	}
}
