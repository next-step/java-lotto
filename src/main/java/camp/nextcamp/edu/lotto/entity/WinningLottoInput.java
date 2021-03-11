package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.lotto.exception.UserExceptionMesssage.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextcamp.edu.lotto.exception.UserException;
import camp.nextcamp.edu.lotto.module.LottoNumberGenerator;
import camp.nextcamp.edu.util.StringUtils;

public class WinningLottoInput {
	private final Set<LottoNumber> numbers;

	public WinningLottoInput(String input) {
		validateContainsComma(input);

		Set<String> numbers = Arrays.stream(input.split(", "))
			.collect(Collectors.toSet());

		validateNumber(numbers);
		this.numbers = convertLottoNumbers(numbers);
	}


	private void validateContainsComma(String input) {
		if (!input.contains(", ")) {
			throw new UserException(SLICE_WITH_COMMA);
		}
	}

	private void validateNumber(Set<String> numbers) {
		if (checkNotNumeric(numbers)) {
			throw new UserException(ONLY_NUMBER);
		}
	}

	private boolean checkNotNumeric(Set<String> input) {
		return input.stream()
			.map(StringUtils::isNumeric)
			.anyMatch((valid) -> !valid);
	}

	private Set<LottoNumber> convertLottoNumbers(Set<String> input) {
		return input.stream()
			.map(Integer::parseInt)
			.map(LottoNumberGenerator::generate)
			.collect(Collectors.toSet());
	}

	public Set<LottoNumber> getNumbers() {
		return numbers;
	}
}
