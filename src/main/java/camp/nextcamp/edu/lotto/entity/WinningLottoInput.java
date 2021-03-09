package camp.nextcamp.edu.lotto.entity;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextcamp.edu.util.StringUtils;

public class WinningLottoInput {
	private final Set<Integer> numbers;

	public WinningLottoInput(String input) {
		if (!input.contains(", ")) {
			throw new RuntimeException(",  단위로 잘라서 입력해주세요.");
		}

		Set<String> numbers = Arrays.stream(input.split(", "))
			.collect(Collectors.toSet());
		if (checkNotNumeric(numbers)) {
			throw new RuntimeException("숫자만 입력이 가능합니다.");
		}

		this.numbers = convertToIntegerList(numbers);
	}


	private boolean checkNotNumeric(Set<String> input) {
		return input.stream()
			.map(StringUtils::isNumeric)
			.anyMatch((valid) -> !valid);
	}

	private Set<Integer> convertToIntegerList(Set<String> input) {
		return input.stream()
			.map(Integer::parseInt)
			.collect(Collectors.toSet());
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}
}
