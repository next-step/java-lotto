package lotto;

import java.util.List;

public class WinningBalls {

	private final Lotto winningNumbers;
	private final BonusBall bonusBall;

	private WinningBalls(Lotto winningNumbers, BonusBall bonusBall) {
		this.winningNumbers = winningNumbers;
		this.bonusBall = bonusBall;
	}

	public static WinningBalls of(Lotto winningNumbers, BonusBall bonusBall) {
		return new WinningBalls(winningNumbers, bonusBall);
	}

	public List<Integer> getAllWinningNumbers() {
		List<Integer> lottoNumbers = winningNumbers.toLottoNumbersDto()
												   .getLottoNumbers();
		bonusBall.addInto(lottoNumbers);
		return lottoNumbers;
	}

	public boolean isSameNumberIncludedWithBonusBall(Lotto lotto) {
		return bonusBall.isSameNumberIncludedIn(lotto);
	}

}
