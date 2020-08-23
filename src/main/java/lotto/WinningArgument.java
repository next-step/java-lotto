package lotto;

import java.util.List;

import lombok.Getter;

@Getter
public class WinningArgument {

	private final int sameCount;
	private final boolean matchBonusBall;

	private WinningArgument(int sameCount, boolean matchBonusBall) {
		this.sameCount = sameCount;
		this.matchBonusBall = matchBonusBall;
	}

	public static WinningArgument of(Lotto lotto, WinningBalls winningBalls) {
		List<Integer> winningLottoNumbers = winningBalls.getAllWinningNumbers();


		int sameCount = lotto.calculateMatchCountWith(winningLottoNumbers);
		boolean matchBonusBall = winningBalls.isSameNumberIncludedWithBonusBall(lotto);

		return new WinningArgument(sameCount, matchBonusBall);
	}
}
