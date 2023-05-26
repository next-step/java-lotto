package step2.lotto.domain;

public class LottoWinningStatisticDto {

	private int threeMatch;

	private int fourMatch;

	private int fiveMatch;

	private int sixMatch;

	private double profitRate;

	public LottoWinningStatisticDto(int threeMatch, int fourMatch, int fiveMatch, int sixMatch, double profitRate) {
		this.threeMatch = threeMatch;
		this.fourMatch = fourMatch;
		this.fiveMatch = fiveMatch;
		this.sixMatch = sixMatch;
		this.profitRate = profitRate;
	}

	public static LottoWinningStatisticDto of(int threeMatch, int fourMatch, int fiveMatch, int sixMatch, double profitRate) {
		return new LottoWinningStatisticDto(threeMatch, fourMatch, fiveMatch, sixMatch, profitRate);
	}

	public int getThreeMatch() {
		return threeMatch;
	}

	public int getFourMatch() {
		return fourMatch;
	}

	public int getFiveMatch() {
		return fiveMatch;
	}

	public int getSixMatch() {
		return sixMatch;
	}

	public double getProfitRate() {
		return profitRate;
	}
}
