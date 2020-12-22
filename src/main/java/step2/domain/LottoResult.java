package step2.domain;

public class LottoResult implements Comparable<LottoResult> {

	private final LottoWin lottoWin;
	private int count;

	public LottoResult(final LottoWin lottoWin) {
		this.lottoWin = lottoWin;
	}

	public void increase() {
		this.count++;
	}

	public Integer getMatchCount() {
		return lottoWin.getMatchCount();
	}

	public Integer getPrice() {
		return lottoWin.getPrice();
	}

	public Integer getWinPrice() {
		if (this.isWin()) {
			return lottoWin.getPrice() * count;
		}
		return 0;
	}

	public int getWinCount() {
		return count;
	}

	public boolean isWin() {
		return !this.lottoWin.isNotWin();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final LottoResult that = (LottoResult)o;

		return lottoWin == that.lottoWin;
	}

	@Override
	public int hashCode() {
		return lottoWin != null ? lottoWin.hashCode() : 0;
	}

	@Override
	public int compareTo(final LottoResult lottoResult) {
		return this.lottoWin.getMatchCount() - lottoResult.lottoWin.getMatchCount();
	}

	public void increaseIfEqualsMatchCount(final int matchCount, final boolean hasBonusNumber) {
		if (isWinWithBonusBall() && hasBonusNumber) {
			this.increase();
			return;
		}

		if (this.getMatchCount() == matchCount) {
			this.increase();
		}
	}

	public boolean isWinWithBonusBall() {
		return this.lottoWin.hasBonusBall();
	}
}
