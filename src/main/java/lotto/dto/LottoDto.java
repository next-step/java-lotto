package lotto.dto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPrize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {

	private static final String PRINT_FORMAT = "[%s]";
	private static final String PRINT_DELIMITER = ", ";

	private final List<Integer> numbers;
	private final LottoPrize status;

	public LottoDto(LottoPrize status) {
		this.numbers = Collections.emptyList();
		this.status = status;
	}

	private LottoDto(Lotto lotto) {
		this.numbers = new ArrayList<>(lotto.getNumbers());
		Collections.sort(this.numbers);
		this.status = lotto.getStatus();
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

	public LottoPrize getStatus() {
		return status;
	}

	public boolean hasSameStatus(LottoPrize status) {
		return this.status.equals(status);
	}

}
