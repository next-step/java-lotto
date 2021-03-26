package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankingResult {
	private final Map<Ranking, Integer> result = new HashMap<>();

	public void calculate(LottoGames lottoGames, LastWeekWinnerNumber lastWeekWinnerNumber) {
		final Map<Integer, Integer> winnerCountPerRanking = new HashMap<>();

		lottoGames.getLottoGameList().forEach(lottoGame -> {
			int equalCount = (int)lottoGame.getGameNumberList()
				.stream()
				.filter(
					lottoNumber -> lastWeekWinnerNumber.getLastWinnerNumber().getGameNumberList().contains(lottoNumber))
				.count();

			winnerCountPerRanking.put(equalCount, winnerCountPerRanking.getOrDefault(equalCount, 0) + 1);
		});

		saveRanking(winnerCountPerRanking);
	}

	public Map<Ranking, Integer> getResult() {
		return result;
	}

	private void saveRanking(Map<Integer, Integer> winnerCountPerGrade) {
		for (Ranking ranking : Ranking.values()) {
			result.put(ranking, winnerCountPerGrade.getOrDefault(ranking.getMatchCount(), 0));
		}
	}
}
