package lotto.dto;

import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {

	private static final String PRINT_FORMAT = "[%s]";
	private static final String PRINT_DELIMITER = ", ";

	private final List<Integer> numbers;

	private LottoDto(Lotto lotto) {
		this.numbers = new ArrayList<>(lotto.getNumbers());
		Collections.sort(this.numbers);
	}

	public static LottoDto of(Lotto lotto) {
		return new LottoDto(lotto);
	}

	public String printLottoNumbers() {
		List<String> stringNumbers = numbers.stream()
				.map(String::valueOf)
				.collect(Collectors.toList());
		return String.format(PRINT_FORMAT, String.join(PRINT_DELIMITER, stringNumbers));
	}

}
