package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.Prize;

public class WinningNumber {

	private List<Integer> winningNumbers;

	public WinningNumber(String numbers) {
		winningNumbers = getWinningNumbers(numbers);
	}

	private List<Integer> getWinningNumbers(String numbers) {
		return Arrays.stream(numbers.split("[\\s,]+"))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
	}

	public Prize match(Lotto lotto) {
		int match = 0;
		for(Integer winningNumber : winningNumbers) {
			if(lotto.match(winningNumber)) {
				++match;
			}
		}
		return Prize.get(match);
	}
}
