package nextstep.step2.domain;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LastWeekLotto {
	private static final String WRONG_WINNER_NUMBERS = "지난주 로또 당첨번호는 모두 숫자여야 합니다.";
	
	public Lotto getLastWeekLotto(String winnerNumbers) {
		String[] winningNumberSplit = winnerNumbers.replaceAll(" ", "").split(",");
		validateLastWinnerNumbers(winningNumberSplit);
		Set<Integer> winningNumbers =  Stream.of(winningNumberSplit)
				.map(Integer::parseInt)
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		return new Lotto(winningNumbers);
	}

	protected void validateLastWinnerNumbers(String[] numbers) {
		boolean isDigit = Stream.of(numbers).allMatch(oddNum -> oddNum.chars().allMatch(Character::isDigit));
		if (!isDigit) {
			throw new IllegalArgumentException(WRONG_WINNER_NUMBERS);
		}
	}
}
