package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class GenerateLottoNumber {
	public static final int MAX_LOTTO_NUMBERS_SIZE = 6;
	public static final int MAX_LOTTO_NUMBER = 45;

	public static LottoNumbers manual(List<Integer> manualNumbers) {
		verifyNumbers(manualNumbers);

		return manualNumbers.stream()
			.map(LottoNumber::new)
			.sorted(LottoNumber::isGraterThanNumber)
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::new));
	}

	private static void verifyNumbers(List<Integer> manualNumbers) {
		verifyNumbersSize(manualNumbers.size());
		verifyAllowMaxNumber(manualNumbers);

	}

	private static void verifyNumbersSize(int size) {
		if (size > MAX_LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("로또 숫자는 6을 초과할수 없습니다.");
		}
	}

	private static void verifyAllowMaxNumber(List<Integer> manualNumbers) {
		manualNumbers.forEach(GenerateLottoNumber::checkRangeOfNumber);
	}

	private static void checkRangeOfNumber(int number) {
		if (verifyNumber(number)) {
			throw new IllegalArgumentException("기준치를 초과하였습니다.");
		}
	}

	private static boolean verifyNumber(int number) {
		return number > MAX_LOTTO_NUMBER;
	}
}
