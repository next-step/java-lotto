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

	public static WinningArgument of(LottoNumbersDto lottoNumbersDtoOfUser, WinningBalls winningBalls) {
		List<Integer> lottoNumbersOfUser = lottoNumbersDtoOfUser.getLottoNumbers();
		List<Integer> winningLottoNumbers = winningBalls.getAllWinningNumbers();

		int sameCount = getSameCount(lottoNumbersOfUser, winningLottoNumbers);
		boolean matchBonusBall = winningBalls.isSameNumberIncludedWithBonusBall(lottoNumbersOfUser);

		return new WinningArgument(sameCount, matchBonusBall);
	}

	private static int getSameCount(List<Integer> lottoNumbersOfUser, List<Integer> winningLottoNumbers) {
		int sameCount = (int) lottoNumbersOfUser.stream()
												.filter(winningLottoNumbers::contains)
												.count();

		validateSameCount(sameCount);

		return sameCount;
	}

	private static void validateSameCount(int sameCount) {
		if (Ranking.FIRST.getSameCount() < sameCount) {
			throw new IllegalArgumentException("당첨 개수는 6개를 넘을 수 없습니다.");
		}
	}
}
