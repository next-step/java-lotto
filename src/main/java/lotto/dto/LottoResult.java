package lotto.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.domain.CalculatePrize;

public class LottoResult {

	private static final int LOTTO_PRICE = 1000;

	private final PrizeStack prizeStack;
	private final int buyingAmount;

	private int first;
	private int second;
	private int third;
	private int fourth;
	private int fifth;
	private int miss;
	private BigDecimal yield;
	private int totalWinningAmount;

	public LottoResult(int lottoBuyingCount) {
		this.prizeStack = new PrizeStack();
		this.buyingAmount = lottoBuyingCount * LOTTO_PRICE;
	}

	public void calculatePrizeCount() {
		this.first = countingPrize(CalculatePrize.FIRST);
		this.second = countingPrize(CalculatePrize.SECOND);
		this.third = countingPrize(CalculatePrize.THIRD);
		this.fourth = countingPrize(CalculatePrize.FOURTH);
		this.fifth = countingPrize(CalculatePrize.FIFTH);
		this.miss = countingPrize(CalculatePrize.MISS);
		this.totalWinningAmount = 0;

		sumTotalAmount();
		calculateYield();
	}

	public void add(CalculatePrize calculatePrize) {
		Map<CalculatePrize, Integer> prize = prizeStack.getPrize();
		prize.put(calculatePrize, prize.get(calculatePrize) + 1);
	}

	public int countingPrize(CalculatePrize calculatePrize) {
		Map<CalculatePrize, Integer> prize = prizeStack.getPrize();
		return prize.get(calculatePrize);
	}

	private void sumTotalAmount() {
		List<Integer> numbers = Arrays.asList(first, second, third, fourth, fifth, miss);
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

	public int getSecond() {
		return second;
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
