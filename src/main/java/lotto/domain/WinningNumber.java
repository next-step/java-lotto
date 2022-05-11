package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {
	public final String DELIMITER = ",";
	public static final int NUMBER_SIZE = 6;
	private final List<LottoNumber> numbers;

	public WinningNumber() {
		numbers = new ArrayList<>();
	}

	public WinningNumber(String input) {
		String[] splits = input.split(DELIMITER);
		validateSize(splits);
		numbers = Stream.of(splits)
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	private void validateSize(String[] splits) {
		if(splits.length != NUMBER_SIZE) {
			throw new IllegalArgumentException("당첨번호는 " + NUMBER_SIZE + "개로 입력해주세요.");
		}
	}

	public long match(Lotto lotto) {
		return this.numbers.stream()
			.filter(lotto::contain)
			.count();
	}
}
