package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LastWeekWinnerNumber {
	LottoGame winnerNumber;

	public LastWeekWinnerNumber(String inputNumber) {
		String[] splitNumbers = inputNumber.split(",");
		winnerNumber = new LottoGame(() -> {
			List<LottoNumber> gameNumberList = new ArrayList<>();
			Arrays.stream(splitNumbers)
				.forEach((numbers) -> gameNumberList.add(new LottoNumber(Integer.valueOf(numbers.trim()))));
			return gameNumberList;
		});
	}

	public LottoGame getLastWinnerNumber() {
		return winnerNumber;
	}
}
