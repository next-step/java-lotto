package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreBoard {

	private final Map<Score, Integer> scoreBoard = new HashMap<>();

	public ScoreBoard(List<Lotto> lottos) {
		for (PrizeType prizeType : PrizeType.values()) {
			this.scoreBoard.put(prizeType.score, 0);
		}
		for (Lotto lotto : lottos) {
			Score score = lotto.getScore();
			this.plusScore(score);
		}
	}

	private void plusScore(Score score) {
		if (this.scoreBoard.containsKey(score)) {
			this.scoreBoard.put(score, (scoreBoard.get(score) + 1));
		}
	}

	public List<PrizeSituation> makePrizeSituations() {
		return this.scoreBoard.entrySet().stream()
			.map(entry -> new PrizeSituation(PrizeType.of(entry.getKey()), entry.getValue()))
			.collect(Collectors.toList());
	}

	public Integer winCount(Score score) {
		return this.scoreBoard.get(score);
	}
}
