package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateLottoNumber {
	public static final int MAX_LOTTO_NUMBERS_SIZE = 6;
	public static final int MAX_LOTTO_NUMBER = 45;
	public static final String USER_INPUT_SEPARATOR = ",";

	public static LottoNumbers manual(List<Integer> manualNumbers) {
		return generateLottoNumbers(manualNumbers);
	}

	public static LottoNumbers auto() {
		List<Integer> autoNumber = new ArrayList<>();
		IntStream.range(0, MAX_LOTTO_NUMBER).forEach(index -> autoNumber.add(index + 1));
		Collections.shuffle(autoNumber);
		ArrayList<Integer> shuffledAutoNumbers = new ArrayList<>(autoNumber.subList(0, MAX_LOTTO_NUMBERS_SIZE));

		return generateLottoNumbers(shuffledAutoNumbers);
	}

	public static LottoNumbers ofInput(String input) {
		List<Integer> userInputNumber = Arrays.stream(input.split(USER_INPUT_SEPARATOR))
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		return GenerateLottoNumber.manual(userInputNumber);
	}

	private static LottoNumbers generateLottoNumbers(List<Integer> targetNumbers) {
		verifyNumbers(targetNumbers);
		return targetNumbers.stream()
			.map(LottoNumber::new)
			.sorted(LottoNumber::isGraterThanNumber)
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::new));
	}

	private static void verifyNumbers(List<Integer> manualNumbers) {
		verifyNumbersSize(manualNumbers.size());
		manualNumbers.forEach(GenerateLottoNumber::checkRangeOfNumber);
	}

	private static void verifyNumbersSize(int size) {
		if (size > MAX_LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("로또 숫자는 6을 초과할수 없습니다.");
		}
	}

	private static void checkRangeOfNumber(int number) {
		if (number > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException("기준치를 초과하였습니다.");
		}
	}
}
