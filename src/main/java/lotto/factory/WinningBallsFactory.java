package lotto.factory;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lotto.LottoNumbers;
import lotto.WinningBalls;
import lotto.input.InputValidator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WinningBallsFactory {

	private static final String WINNING_NUMBER_DELIMITER = ",";

	private static LottoNumbers create(List<Integer> numbers) {
		return LottoNumbers.of(numbers);
	}

	public static WinningBalls create(String numbersString) {
		InputValidator.validateWinningNumbers(numbersString);
		LottoNumbers winningNumbers = create(Stream.of(numbersString.split(WINNING_NUMBER_DELIMITER))
												   .mapToInt(number -> Integer.parseInt(number.trim()))
												   .boxed()
												   .collect(toList()));
		return WinningBalls.of(winningNumbers);
	}
}
