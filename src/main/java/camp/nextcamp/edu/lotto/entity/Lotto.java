package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.lotto.constants.LottoConstants.*;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import camp.nextcamp.edu.lotto.exception.UserException;
import camp.nextcamp.edu.lotto.exception.UserExceptionMesssage;

public class Lotto {
	private final Set<LottoNumber> numbers;

	public Lotto(Set<LottoNumber> numbers) {
		validateSize(numbers);
		this.numbers = numbers;
	}

	private boolean checkSize(Set<LottoNumber> numbers) {
		return Optional.ofNullable(numbers)
			.orElse(new TreeSet<>())
			.size() == LOTTO_COUNT;
	}

	public Set<LottoNumber> getNumbers() {
		return this.numbers;
	}

	public String getNumbersString() {
		return this.numbers
			.stream()
			.map(Object::toString)
			.collect(Collectors.joining(", "));
	}

	private void validateSize(Set<LottoNumber> numbers) {
		if (!checkSize(numbers)) {
			throw new UserException(UserExceptionMesssage.MAXIUMUM_SIZE);
		}
	}
}
