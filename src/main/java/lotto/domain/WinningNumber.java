package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {
	public static final String DELIMITER = ",";
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
		Set<String> deduplicationSplitInput = Arrays.stream(splits)
			.collect(Collectors.toSet());
		if(deduplicationSplitInput.size() != NUMBER_SIZE) {
			throw new IllegalArgumentException("당첨번호는 " + NUMBER_SIZE + "개로 입력해주세요.");
		}
	}

	public long matchQuantity(Lotto lotto) {
		return this.numbers.stream()
			.filter(lotto::contain)
			.count();
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
