package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotteries {
	public final static int PRICE_PER_GAME = 1000;
	private List<Lotto> lotteries = new ArrayList<>();

	public Lotteries(int purchasePrice) {
		int lotteriesNumber = purchasePrice / PRICE_PER_GAME;
		validationLottoGamesSize(lotteriesNumber);

		this.lotteries = IntStream.rangeClosed(1, lotteriesNumber)
			.mapToObj(n -> new Lotto(new ShuffleMakeStrategy()))
			.collect(Collectors.toList());
	}

	public Lotteries(Lotto... lotto) {
		for (int i = 0; i < lotto.length; i++) {
			this.lotteries.add(lotto[i]);
		}
	}

	public void add(Lotteries newLotteries) {
		this.lotteries.addAll(newLotteries.lotteries);
	}

	public List<Lotto> getLottoGameList() {
		return lotteries;
	}

	public RankingResult calculateRanking(LastWeekWinnerNumber lastWeekWinnerNumber) {
		RankingResult rankingResult = new RankingResult();
		lotteries.forEach(lotto -> {
			int matchCount = lastWeekWinnerNumber.getMatchCount(lotto);
			boolean matchBonusCount = lastWeekWinnerNumber.getMatchBonusCount(lotto);
			rankingResult.saveRanking(matchCount, matchBonusCount);
		});
		return rankingResult;
	}

	private static void validationLottoGamesSize(int lotteriesNumber) {
		if (lotteriesNumber < 1) {
			throw new IllegalArgumentException("최소 한장 이상 구매할 수 있는 금액을 입력해주세요.");
		}
	}
}
