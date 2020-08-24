package lotto.input;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputValidator {
	private static final Pattern NUMBER_PATTERN = Pattern.compile("^[-+]?(0|[1-9][0-9]*)(\\\\.[0-9]+)?([eE][-+]?[0-9]+)?$");

	public static void validatePurchasePrice(String price) {
		if (!isNumber(price)) {
			throw new IllegalArgumentException("구입금액은 숫자로 입력해주세요.");
		}

		if (Integer.parseInt(price) < 1000) {
			throw new IllegalArgumentException("구입금액은 최소 1000원 이상 입력해주세요.");
		}
	}

	public static boolean isNumber(String value) {
		return NUMBER_PATTERN.matcher(value)
							 .matches();
	}

	public static void validateWinningNumbers(String winningNumbers) {
		if (StringUtils.isBlank(winningNumbers)) {
			throw new IllegalArgumentException("당첨번호를 입력하셔야 합니다.");
		}
	}
}
