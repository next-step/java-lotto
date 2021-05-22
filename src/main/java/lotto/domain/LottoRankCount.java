package lotto.domain;

public class LottoRankCount {

	private long firstCount;
	private long secondCount;
	private long thirdCount;
	private long fourthCount;

	public LottoRankCount(long firstCount, long secondCount, long thirdCount, long fourthCount) {
		this.firstCount = firstCount;
		this.secondCount = secondCount;
		this.thirdCount = thirdCount;
		this.fourthCount = fourthCount;
	}

	public long getFirstCount() {
		return firstCount;
	}

	public long getSecondCount() {
		return secondCount;
	}

	public long getThirdCount() {
		return thirdCount;
	}

	public long getFourthCount() {
		return fourthCount;
	}

}
