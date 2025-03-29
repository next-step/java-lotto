package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
	private static final int LOTTO_SIZE = 6;
	private final List<Integer> numbers;

	public LottoTicket(List<Integer> numbers) {
		validateSize(numbers.size());
		validateDuplicate(numbers);
		this.numbers = List.copyOf(numbers);
	}

	private void validateSize(int size) {
		if (size != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
		if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("중복인 로또 번호가 존재합니다.");
		}
	}

}
