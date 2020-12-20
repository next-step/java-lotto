package step2.domain;

public class LottoResult implements Comparable<LottoResult> {

	private final LottoWin lottoWin;
	private int count;

	public LottoResult(final LottoWin lottoWin) {
		this.lottoWin = lottoWin;
	}

	@Override
	public int compareTo(final LottoResult lottoResult) {
		return lottoResult.lottoWin.getMatchCount() - this.lottoWin.getMatchCount();
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
}
