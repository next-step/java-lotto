package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoCalculate {
	private int firstPlace;
	private int secondPlace;
	private int thirdPlace;
	private int fourthPlace;
	private int fifthPlace;
	private BigDecimal yield;

	public LottoCalculate calculatedLotto(List<LotteryWinnings> LotteryWinnings, int amount){
		for (LotteryWinnings winnings : LotteryWinnings) {
			classifyWinnings(winnings);
		}
		calculateYield(amount);
		return this;
	}

	private void classifyWinnings(LotteryWinnings winnings) {
		if (winnings.equals(new LotteryWinnings(5))) {
			fifthPlace++;
		}
		if (winnings.equals(new LotteryWinnings(4))) {
			fourthPlace++;
		}
		if (winnings.equals(new LotteryWinnings(3))) {
			thirdPlace++;
		}
		if (winnings.equals(new LotteryWinnings(1))) {
			firstPlace++;
		}
	}

	private void calculateYield(int amount){
		int firstWinnings = CalculateWinnings.of(1).calculate(firstPlace);
		int thirdWinnings = CalculateWinnings.of(3).calculate(thirdPlace);
		int fourthWinnings = CalculateWinnings.of(4).calculate(fourthPlace);
		int fifthWinnings = CalculateWinnings.of(5).calculate(fifthPlace);

		int totalWinnings = firstWinnings + thirdWinnings + fourthWinnings + fifthWinnings;
		BigDecimal bTotalWinnings = new BigDecimal(totalWinnings);
		BigDecimal bAmount = new BigDecimal(amount);
		this.yield = bTotalWinnings.divide(bAmount, 2, RoundingMode.UP);

	}

	public int getFirstPlace() {
		return firstPlace;
	}

	public int getSecondPlace() {
		return secondPlace;
	}

	public int getThirdPlace() {
		return thirdPlace;
	}

	public int getFourthPlace() {
		return fourthPlace;
	}

	public int getFifthPlace() {
		return fifthPlace;
	}

	public BigDecimal getYield() {
		return yield;
	}
}
