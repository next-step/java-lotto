package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinnerNumbers {
	private final LottoNumbers winnerNumbers;

	public LottoWinnerNumbers(LottoNumbers winnerNumbers) {
		this.winnerNumbers = winnerNumbers;
	}

	public LottoNumbers getNumbers() {
		return this.winnerNumbers;
	}

	public static LottoWinnerNumbers ofUser(String input) {
		List<Integer> userInputWinnerNumber = Arrays.stream(input.split(","))
			.map(String::trim)
			.map(Integer::parseInt).collect(Collectors.toList());

		return new LottoWinnerNumbers(GenerateLottoNumber.manual(userInputWinnerNumber));
	}
}
