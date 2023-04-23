package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import lotto.utils.RandomUtils;

public class LottoMachine {

	private static final int BREAK_EVEN_POINT = 1;

	private final PurchasedLottos purchasedLottos;

	public LottoMachine() {
		this.purchasedLottos = new PurchasedLottos();
	}

	public LottoMachine(int purchaseAmount) {
		this();

		if (purchaseAmount < Lotto.LOTTO_PRICE || purchaseAmount % Lotto.LOTTO_PRICE != 0) {
			throw new IllegalArgumentException("구입 금액이 올바르지 않습니다.");
		}

		int purchaseCount = purchaseAmount / Lotto.LOTTO_PRICE;
		for (int i = 0; i < purchaseCount; i++) {
			this.purchasedLottos.add(new Lotto());
		}
	}

	public LottoMachine(List<Lotto> purchasedLottos) {
		this.purchasedLottos = new PurchasedLottos(purchasedLottos);
	}

	public void selectLottoNumbers() {
		for (Lotto lotto : this.purchasedLottos.getLottos()) {
			this.fillEachLotto(lotto);
		}
	}

	private void fillEachLotto(Lotto lotto) {
		while (lotto.selectedNumbersSize() < Lotto.LOTTO_SIZE) {
			lotto.selectLottoNumbers(RandomUtils.randomInt());
		}
	}

	public int purchasedLottosSize() {
		return this.purchasedLottos.size();
	}

	public int totalProfit() {
		int totalProfit = 0;
		for (Lotto lotto : this.purchasedLottos.getLottos()) {
			totalProfit += PrizeType.of(lotto.getWinCount()).prizeMoney;
		}
		return totalProfit;
	}

	public double totalProfitRate(int totalProfit, int purchaseAmount) {
		return new BigDecimal((double) totalProfit / purchaseAmount).setScale(2, RoundingMode.DOWN).doubleValue();
	}

	public boolean isBenefit(double totalProfit) {
		return totalProfit > LottoMachine.BREAK_EVEN_POINT;
	}
}
