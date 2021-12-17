package lotto.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import lotto.domain.CalculatePrize;

public class LottoResult {

	private static final int LOTTO_PRICE = 1000;

	private final int first;
	private final int third;
	private final int fourth;
	private final int fifth;
	private final int miss;
	private final int buyingAmount;
	private BigDecimal yield;
	private int totalWinningAmount;

	public LottoResult(PrizeStack prizeStack) {
		this.first = prizeStack.countingPrize(CalculatePrize.FIRST);
		this.third = prizeStack.countingPrize(CalculatePrize.THIRD);
		this.fourth = prizeStack.countingPrize(CalculatePrize.FOURTH);
		this.fifth = prizeStack.countingPrize(CalculatePrize.FIFTH);
		this.miss = prizeStack.countingPrize(CalculatePrize.MISS);
		this.totalWinningAmount = 0;
		this.buyingAmount = prizeStack.size() * LOTTO_PRICE;

		sumTotalAmount();
		calculateYield();
	}

	private void sumTotalAmount() {
		List<Integer> numbers = Arrays.asList(first, third, fourth, fifth, miss);
		int i = 0;
		for (CalculatePrize calculatePrize : CalculatePrize.values()) {
			totalWinningAmount += calculatePrize.calculate(numbers.get(i));
			i++;
		}
	}

	private void calculateYield() {
		BigDecimal bTotalWinnings = new BigDecimal(totalWinningAmount);
		BigDecimal bAmount = new BigDecimal(buyingAmount);
		this.yield = bTotalWinnings.divide(bAmount, 2, RoundingMode.UP);
	}

	public int getFirst() {
		return first;
	}

	public int getThird() {
		return third;
	}

	public int getFourth() {
		return fourth;
	}

	public int getFifth() {
		return fifth;
	}

	public BigDecimal getYield() {
		return yield;
	}
}
