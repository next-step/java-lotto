package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMachine {

	private static final int BREAK_EVEN_POINT = 1;

	private final PurchasedLottos purchasedLottos;

	public LottoMachine() {
		this.purchasedLottos = new PurchasedLottos();
	}

	public LottoMachine(long purchaseAmount) {
		this();

		if (purchaseAmount < Lotto.PRICE || purchaseAmount % Lotto.PRICE != 0) {
			throw new IllegalArgumentException("구입 금액이 올바르지 않습니다.");
		}

		long purchaseCount = purchaseAmount / Lotto.PRICE;
		for (long i = 0; i < purchaseCount; i++) {
			this.purchasedLottos.add(new Lotto());
		}
	}

	public LottoMachine(List<Lotto> purchasedLottos) {
		this.purchasedLottos = new PurchasedLottos(purchasedLottos);
	}

	public int purchasedCount() {
		return this.purchasedLottos.size();
	}

	public void calculateScore(List<Integer> winNumbers) {
		this.purchasedLottos.calculateScore(winNumbers);
	}

	public List<PrizeSituation> makePrizeSituations() {
		return this.toPrizeSituations(this.makeScoreBoard(this.purchasedLottos.getLottos()));
	}

	private List<PrizeSituation> toPrizeSituations(Map<Score, Integer> scoreBoard) {
		return scoreBoard.entrySet().stream()
			.map(entry -> new PrizeSituation(PrizeType.of(entry.getKey()), entry.getValue()))
			.collect(Collectors.toList());
	}

	public Map<Score, Integer> makeScoreBoard(List<Lotto> lottos) {
		Map<Score, Integer> scoreBoard = new HashMap<>();
		for (PrizeType prizeType : PrizeType.values()) {
			scoreBoard.put(prizeType.score, 0);
		}
		for (Lotto lotto : lottos) {
			fillScoreBoard(scoreBoard, lotto);
		}
		return scoreBoard;
	}

	private void fillScoreBoard(Map<Score, Integer> scoreBoard, Lotto lotto) {
		Score score = lotto.getScore();
		if (scoreBoard.containsKey(score)) {
			scoreBoard.put(score, (scoreBoard.get(score) + 1));
		}
	}

	public List<PrizeSituation> sortInOrderScore(List<PrizeSituation> prizeSituations) {
		return prizeSituations.stream().sorted().collect(Collectors.toList());
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

	public double totalProfitRate(long totalProfit, long purchaseAmount) {
		return new BigDecimal((double) totalProfit / purchaseAmount).setScale(2, RoundingMode.DOWN).doubleValue();
	}

	public boolean isBenefit(double totalProfitRate) {
		return totalProfitRate > LottoMachine.BREAK_EVEN_POINT;
	}

	public PurchasedLottos getPurchasedLottos() {
		return purchasedLottos;
	}
}
