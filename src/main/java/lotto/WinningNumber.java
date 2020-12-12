package lotto;

import java.util.List;

public class WinningNumber {
	private final LottoNumber winningNumbers;

	public WinningNumber(List<Integer> winningNumbers) {
		this.winningNumbers = new LottoNumber(winningNumbers);
	}

	public LottoRank match(LottoNumber numbers) {
		return LottoRank.valueOfMatchCount(this.getMatchCount(numbers));
	}

	private int getMatchCount(LottoNumber number) {
		return this.winningNumbers.matchCount(number);
	}
}
