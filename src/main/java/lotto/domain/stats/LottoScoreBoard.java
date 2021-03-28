package lotto.domain.stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.domain.Lotto;

public class LottoScoreBoard {
    private Map<Long, Long> scoreBoard; // Long: 당첨된 볼개수, Integer: 당첨 횟수
    private final Lotto winnerLotto;
    private final List<Lotto> winnerCandidates;

    public LottoScoreBoard(Lotto winnerLotto, List<Lotto> winnerCandidates) {
        scoreBoard = new HashMap<>();
        this.winnerLotto = winnerLotto;
        this.winnerCandidates = winnerCandidates;
    }

    public void scoring() {
        winnerCandidates.stream()
                        .map(winnerLotto::getEqualNumberCountFrom)
                        .forEach(this::addScore);
    }

    private void addScore(long equalNumberCount) {
        if (scoreBoard.containsKey(equalNumberCount)) {
            scoreBoard.put(equalNumberCount, scoreBoard.get(equalNumberCount) + 1L);
            return;
        }
        scoreBoard.put(equalNumberCount, 1L);
    }

    public Long getWinningsByEqualNumberCount(long equalNumberCount) {
        return Optional.ofNullable(scoreBoard.get(equalNumberCount)).orElse(0L);
    }
}
