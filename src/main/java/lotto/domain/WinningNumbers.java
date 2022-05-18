package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumbers {
	public static final String DELIMITER = ",";
	public static final int NUMBER_SIZE = 6;
	private final List<LottoNumber> numbers;

	public WinningNumbers(String input) {
		numbers = Stream.of(input.split(DELIMITER))
			.map(LottoNumber::of)
			.collect(Collectors.toList());

		validateSize(numbers);
	}

	public WinningNumbers(String input, LottoNumber bonusNumber) {
		numbers = Stream.of(input.split(DELIMITER))
			.map(LottoNumber::of)
			.collect(Collectors.toList());

		validateSize(numbers);
		validateDuplicationBonusNumber(bonusNumber);
		numbers.add(bonusNumber);
	}

	private void validateDuplicationBonusNumber(LottoNumber bonusNumber) {
		if (numbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호는 당첨번호랑 중복될 수 없습니다.");
		}
	}

	public WinningNumbers(List<LottoNumber> numbers) {
		validateSize(numbers);
		this.numbers = numbers;
	}

	public long matchQuantity(Lotto lotto) {
		return matchQuantity(lotto, LottoNumberType.DEFAULT);
	}

	public long matchBonusQuantity(Lotto lotto) {
		return matchQuantity(lotto, LottoNumberType.BONUS);
	}

	private long matchQuantity(Lotto lotto, LottoNumberType type) {
		return this.numbers.stream()
			.filter(number -> number.checkType(type) && lotto.contain(number))
			.count();
	}

	private void validateSize(List<LottoNumber> numbers) {
		Set<LottoNumber> deduplicationSplitInput = new HashSet<>(numbers);
		if(deduplicationSplitInput.size() != NUMBER_SIZE) {
			throw new IllegalArgumentException(String.format("당첨번호는 중복 없이 %d개로 입력해주세요.", NUMBER_SIZE));
		}
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
