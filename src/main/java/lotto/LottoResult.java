package lotto;

public class LottoResult {
	private final Rank rank;

	public LottoResult(int matchesCount) {
		this.rank = Rank.ofMatchesCount(matchesCount);
	}

	public static LottoResult compareNumbers(LottoNumbers targetNumbers, LottoWinnerNumbers lottoWinnerNumbers) {
		LottoNumbers winnerNumber = lottoWinnerNumbers.getNumbers();
		int count = Math.toIntExact(targetNumbers.getNumbers()
			.stream()
			.filter(winnerNumber::isContainsLottoNumber)
			.count());
		return new LottoResult(count);
	}

	public boolean isMatchesRank(Rank rank) {
		return this.rank.equals(rank);
	}

	public int getRankAmountMoney() {
		return this.rank.getAmountMoney();
	}
}
