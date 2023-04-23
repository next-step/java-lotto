package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import lotto.utils.RandomUtils;

public class LottoMachine {

	private static final int BREAK_EVEN_POINT = 1;

	private final List<Lotto> lottos;

	public LottoMachine() {
		this.lottos = new ArrayList<>();
	}

	public LottoMachine(int buyAmount) {
		this();

		if (buyAmount < Lotto.LOTTO_PRICE || buyAmount % Lotto.LOTTO_PRICE != 0) {
			throw new IllegalArgumentException("구입 금액이 올바르지 않습니다.");
		}

		int buyCount = buyAmount / Lotto.LOTTO_PRICE;
		for (int i = 0; i < buyCount; i++) {
			this.lottos.add(new Lotto());
		}
	}

	public LottoMachine(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public void selectLottoNumbers() {
		for (Lotto lotto : this.lottos) {
			this.fillEachLotto(lotto);
		}
	}

	private void fillEachLotto(Lotto lotto) {
		while (lotto.selectedNumbersSize() < Lotto.LOTTO_SIZE) {
			lotto.selectLottoNumbers(RandomUtils.randomInt());
		}
	}

	public int lottosSize() {
		return this.lottos.size();
	}

	public int totalProfit() {
		int totalProfit = 0;
		for (Lotto lotto : this.lottos) {
			totalProfit += PrizeType.of(lotto.getWinCount()).prizeMoney;
		}
		return totalProfit;
	}

	public double totalProfitRate(int totalProfit, int buyAmount) {
		return new BigDecimal((double) totalProfit / buyAmount).setScale(2, RoundingMode.DOWN).doubleValue();
	}

	public boolean isBenefit(double totalProfit) {
		return totalProfit > LottoMachine.BREAK_EVEN_POINT;
	}
}
