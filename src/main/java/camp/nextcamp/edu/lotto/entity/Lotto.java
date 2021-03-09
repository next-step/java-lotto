package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.lotto.constants.LottoConstants.*;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import camp.nextcamp.edu.lotto.module.LottoValidator;

public class Lotto {
	private final Set<Integer> numbers;

	public Lotto(Set<Integer> numbers) {
		if (!checkSize(numbers)) {
			throw new RuntimeException("Lotto 갯수는 6개 여야됩니다.");
		}

		if (isNotInRange(numbers)) {
			throw new RuntimeException("Lotto 는 1~46까지만 입력이 가능합니다.");
		}
		this.numbers = numbers;
	}

	private boolean isNotInRange(Set<Integer> input) {
		return input.stream()
			.map(LottoValidator::isNotInRange)
			.anyMatch((valid) -> !valid);
	}

	private boolean checkSize(Set<Integer> numbers) {
		return Optional.ofNullable(numbers)
			.orElse(new TreeSet<>())
			.size() == LOTTO_COUNT;
	}

	public Set<Integer> getNumbers() {
		return this.numbers;
	}

	public String getNumbersString() {
		return this.numbers
			.stream()
			.map(Object::toString)
			.collect(Collectors.joining(", "));
	}
}
