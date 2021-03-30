package lotto.domain.stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.prize.Prize;

public class LottoScoreBoard {
    private final Map<Prize, Long> scoreBoard;
    private final Lotto winnerLotto;
    private final List<Lotto> winnerCandidates;

    public LottoScoreBoard(Lotto winnerLotto, List<Lotto> winnerCandidates) {
        scoreBoard = new HashMap<>();
        this.winnerLotto = winnerLotto;
        this.winnerCandidates = winnerCandidates;
    }

    public void scoring() {
        if (scoreBoard.isEmpty()) {
            winnerCandidates
                    .stream()
                    .map(winnerLotto::getEqualNumberCountFrom)
                    .forEach(this::addScore);
        }
    }

    private void addScore(long equalNumberCount) {
        Prize prize = Prize.getPrizeByEqualNumberCount(equalNumberCount);
        if (scoreBoard.containsKey(prize)) {
            scoreBoard.put(prize, scoreBoard.get(prize) + 1L);
            return;
        }
        scoreBoard.put(prize, 1L);
    }

    public Long getWinningsByEqualNumberCount(long equalNumberCount) {
        Prize prize = Prize.getPrizeByEqualNumberCount(equalNumberCount);
        return scoreBoard.getOrDefault(prize, 0L);
    }
}
