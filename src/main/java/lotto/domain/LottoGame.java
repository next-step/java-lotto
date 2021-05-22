package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoGame {

	public static final int PURCHASE_AMOUNT_PER_LOTTO = 1_000;
	private final int purchaseAmount;
	private final List<LottoNumbers> lottos;
	private final RandomNumbersGenerator randomNumbersGenerator;

	public LottoGame(int purchaseAmount) {
		validationPurchaseAmount(purchaseAmount);
		this.purchaseAmount = purchaseAmount;
		this.lottos = new ArrayList<>();
		this.randomNumbersGenerator = new LottoRandomNumbersGenerator();
		this.purchaseLottos();
	}

	public LottoGame(int purchaseAmount, RandomNumbersGenerator randomNumbersGenerator) {
		validationPurchaseAmount(purchaseAmount);
		this.purchaseAmount = purchaseAmount;
		this.lottos = new ArrayList<>();
		this.randomNumbersGenerator = randomNumbersGenerator;
		this.purchaseLottos();
	}

	private void validationPurchaseAmount(int purchaseAmount) {
		if (purchaseAmount < PURCHASE_AMOUNT_PER_LOTTO) {
			throw new IllegalArgumentException(String.format("로또를 구입하려면 최소 %,d원 이상 있어야 합니다.", PURCHASE_AMOUNT_PER_LOTTO));
		}
	}

	protected int findNumberOfAvailablePurchases() {
		return this.purchaseAmount / PURCHASE_AMOUNT_PER_LOTTO;
	}

	private void purchaseLottos() {
		int lottoCount = this.findNumberOfAvailablePurchases();
		for (int i = 0; i < lottoCount; i++) {
			this.lottos.add(new LottoNumbers(this.randomNumbersGenerator));
		}
	}

	public int hasSize() {
		return this.lottos.size();
	}

	public List<LottoNumbers> getLottos() {
		return lottos;
	}

	public LottoResult findWinningResult(LottoNumbers winLottoNumbers) {
		HashMap<Rank, Integer> rankMap = initRankMap();

		for (LottoNumbers lottoNumbers : this.lottos) {
			Rank rank = lottoNumbers.findRank(winLottoNumbers);
			this.addRank(rankMap, rank);
		}
		return new LottoResult(this.purchaseAmount, rankMap);
	}

	private void addRank(HashMap<Rank, Integer> rankMap, Rank rank) {
		rankMap.put(rank, rankMap.get(rank) + 1);
	}

	private HashMap<Rank, Integer> initRankMap() {
		HashMap<Rank, Integer> rankMap = new LinkedHashMap<>();
		rankMap.put(Rank.NONE, 0);
		rankMap.put(Rank.FOURTH, 0);
		rankMap.put(Rank.THIRD, 0);
		rankMap.put(Rank.SECOND, 0);
		rankMap.put(Rank.FIRST, 0);
		return rankMap;
	}

}
