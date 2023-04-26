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

	public int purchasedCount() {
		return this.purchasedLottos.size();
	}

	public void calculateScore(List<Integer> winNumbers) {
		for (Lotto lotto : this.purchasedLottos.getLottos()) {
			lotto.calculateScore(winNumbers);
		}
	}

	public List<PrizeMoneyBoard> makePrizeMoneyBoard() {
		return this.prizeMoneyBoard(this.scoreBoard(this.purchasedLottos.getLottos()));
	}

	public List<PrizeMoneyBoard> prizeMoneyBoard(Map<Score, Integer> scoreMap) {
		return scoreMap.entrySet().stream()
			.map(entry -> new PrizeMoneyBoard(PrizeType.of(entry.getKey()), entry.getValue()))
			.collect(Collectors.toList());
	}

	public Map<Score, Integer> scoreBoard(List<Lotto> lottos) {
		Map<Score, Integer> scoreBoard = new HashMap<>();
		for (PrizeType prizeType : PrizeType.values()) {
			scoreBoard.put(prizeType.score, 0);
		}
		for (Lotto lotto : lottos) {
			Score score = lotto.getScore();
			if (scoreBoard.containsKey(score)) {
				scoreBoard.put(score, (scoreBoard.get(score) + 1));
			}
		}
		return scoreBoard;
	}

	public List<PrizeMoneyBoard> sortInOrderScore(List<PrizeMoneyBoard> prizeMoneyBoardList) {
		return prizeMoneyBoardList.stream().sorted().collect(Collectors.toList());
	}

	public int totalProfit() {
		int totalProfit = 0;
		for (Lotto lotto : this.purchasedLottos.getLottos()) {
			totalProfit += PrizeType.of(lotto.getScore()).prizeMoney.getPrizeMoney();
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
