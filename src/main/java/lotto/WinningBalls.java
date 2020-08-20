package lotto;

import java.util.List;

public class WinningBalls {

	private final LottoNumbers winningNumbers;
	private final BonusBall bonusBall;

	private WinningBalls(LottoNumbers winningNumbers, BonusBall bonusBall) {
		this.winningNumbers = winningNumbers;
		this.bonusBall = bonusBall;
	}

	public static WinningBalls of(LottoNumbers winningNumbers, BonusBall bonusBall) {
		return new WinningBalls(winningNumbers, bonusBall);
	}

	public List<Integer> getAllWinningNumbers() {
		List<Integer> lottoNumbers = winningNumbers.toDto()
												   .getLottoNumbers();
		bonusBall.addInto(lottoNumbers);
		return lottoNumbers;
	}

	public boolean isSameNumberIncludedWithBonusBall(List<Integer> lottoNumbersOfUser) {
		return bonusBall.isSameNumberIncluded(lottoNumbersOfUser);
	}

}
