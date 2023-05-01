package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class BenefitResult {

	private static final int BREAK_EVEN_POINT = 1;

	private final long purchaseAmount;
	private final long totalProfit;
	private final double totalProfitRate;
	private final boolean benefit;

	public BenefitResult(List<PrizeSituation> prizeSituations, long purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
		this.totalProfit = this.totalProfit(prizeSituations);
		this.totalProfitRate = this.totalProfitRate();
		this.benefit = this.isBenefit();
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public BenefitResult(long purchaseAmount, long totalProfit) {
		this.totalProfitRate = 0.0;
		this.purchaseAmount = purchaseAmount;
		this.totalProfit = totalProfit;
		this.benefit = this.isBenefit();
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public BenefitResult(double totalProfitRate) {
		this.totalProfitRate = totalProfitRate;
		this.purchaseAmount = 0;
		this.totalProfit = 0;
		this.benefit = this.isBenefit();
	}

	public long totalProfit(List<PrizeSituation> prizeSituations) {
		long totalProfit = 0;
		for (PrizeSituation prizeSituation : prizeSituations) {
			long prizeMoney = prizeSituation.getPrizeType().prizeMoney.getPrizeMoney();
			int prizeCount = prizeSituation.getPrizeCount();
			totalProfit += (prizeMoney * prizeCount);
		}
		return totalProfit;
	}

	public double totalProfitRate() {
		return new BigDecimal((double) this.totalProfit / this.purchaseAmount).setScale(2, RoundingMode.DOWN).doubleValue();
	}

	public boolean isBenefit() {
		return this.totalProfitRate > BenefitResult.BREAK_EVEN_POINT;
	}

	public long getTotalProfit() {
		return this.totalProfit;
	}

	public double getTotalProfitRate() {
		return this.totalProfitRate;
	}
}
