package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankingResult {
	private final Map<Ranking, Integer> result = new HashMap<>();

	public void calculate(LottoGameList lottoGameList, LastWeekWinnerNumber lastWeekWinnerNumber) {
		final Map<Integer, Integer> winnerCountPerRanking = new HashMap<>();

		lottoGameList.getLottoGameList().forEach(lottoGame -> {
			int equalCount = (int)lottoGame.getGameNumberList()
				.stream()
				.filter(
					lottoNumber -> lastWeekWinnerNumber.getLastWinnerNumber().getGameNumberList().contains(lottoNumber))
				.count();

			winnerCountPerRanking.put(equalCount, winnerCountPerRanking.getOrDefault(equalCount, 0) + 1);
		});

		saveRanking(winnerCountPerRanking);
	}

	private void saveRanking(Map<Integer, Integer> winnerCountPerGrade) {
		for (Ranking ranking : Ranking.values()) {
			result.put(ranking, winnerCountPerGrade.getOrDefault(ranking.getMatchCount(), 0));
		}
	}

	public Map<Ranking, Integer> getResult() {
		return result;
	}
}
