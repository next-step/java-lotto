package lotto;

import lombok.Getter;

@Getter
public class WinningBalls {

	private final LottoNumbers winningNumbers;

	private WinningBalls(LottoNumbers winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public static WinningBalls of(LottoNumbers winningNumbers) {
		return new WinningBalls(winningNumbers);
	}

}
