package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
	public static final String USER_INPUT_SEPARATOR = ",";

	public static LottoNumbers manual(List<String> manualNumbers) {
		return generateLottoNumbers(manualNumbers);
	}

	public static LottoNumbers auto() {
		List<String> autoNumber = new ArrayList<>();
		IntStream.range(0, LottoNumber.MAX_LOTTO_NUMBER).forEach(index -> autoNumber.add(String.valueOf(index + 1)));
		Collections.shuffle(autoNumber);
		ArrayList<String> shuffledAutoNumbers = new ArrayList<>(autoNumber.subList(0, LottoNumbers.MAX_LOTTO_NUMBERS_SIZE));

		return generateLottoNumbers(shuffledAutoNumbers);
	}

	public static LottoNumbers ofInput(String input) {
		return LottoNumberGenerator.manual(
			Arrays.stream(getTextValue(input)
				.split(USER_INPUT_SEPARATOR))
				.map(LottoNumberGenerator::getTextValue)
				.collect(Collectors.toList()));
	}

	private static LottoNumbers generateLottoNumbers(List<String> targetNumbers) {
		return targetNumbers.stream()
			.map(LottoNumber::new)
			.sorted(LottoNumber::isGraterThanNumber)
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::new));
	}

	private static String getTextValue(String input) {
		return Optional.ofNullable(input)
			.map(String::trim)
			.filter(s -> !s.isEmpty())
			.orElseThrow(() -> new IllegalArgumentException("null 또는 공백을 입력 할 수 없습니다."));
	}
}
