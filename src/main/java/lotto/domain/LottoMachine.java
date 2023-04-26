package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	public PurchasedLottos selectLottoNumbers() {
		for (Lotto lotto : this.purchasedLottos.getLottos()) {
			this.fillEachLotto(lotto);
		}
		return this.purchasedLottos;
	}

	private void fillEachLotto(Lotto lotto) {
		while (lotto.selectedNumbersSize() < Lotto.LOTTO_SIZE) {
			lotto.selectLottoNumbers(RandomUtils.randomInt());
		}
	}

	public int purchasedLottosSize() {
		return this.purchasedLottos.size();
	}

	public void calculateWinCount(List<Integer> winNumbers) {
		for (Lotto lotto : this.purchasedLottos.getLottos()) {
			lotto.winCount(winNumbers);
		}
	}

	public List<WinStatistics> countWinLotto() {
		return this.winStatisticsList(this.countWinLottos(this.purchasedLottos.getLottos()));
	}

	public List<WinStatistics> sortInOrderScore(List<WinStatistics> winStatisticsList) {
		return winStatisticsList.stream().sorted().collect(Collectors.toList());
	}

	public List<WinStatistics> winStatisticsList(Map<WinCount, Integer> winCountMap) {
		return winCountMap.entrySet().stream()
			.map(entry -> new WinStatistics(PrizeType.of(entry.getKey()), entry.getValue()))
			.collect(Collectors.toList());
	}

	public Map<WinCount, Integer> countWinLottos(List<Lotto> lottos) {
		Map<WinCount, Integer> winLottosCountingMap = new HashMap<>();
		for (PrizeType prizeType : PrizeType.values()) {
			winLottosCountingMap.put(prizeType.winCount, 0);
		}
		for (Lotto lotto : lottos) {
			WinCount winCount = lotto.getWinCount();
			if (winLottosCountingMap.containsKey(winCount)) {
				winLottosCountingMap.put(winCount, (winLottosCountingMap.get(winCount) + 1));
			}
		}
		return winLottosCountingMap;
	}

	public int totalProfit() {
		int totalProfit = 0;
		for (Lotto lotto : this.purchasedLottos.getLottos()) {
			totalProfit += PrizeType.of(lotto.getWinCount()).prizeMoney.getPrizeMoney();
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
