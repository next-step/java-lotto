package lotto.domain.stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.prize.Prize;
import lotto.view.dto.LottoDto;

public class LottoScoreBoard {
    private final Map<Prize, List<Lotto>> scoreBoard;
    private final Lotto winnerLotto;
    private final List<Lotto> winnerCandidates;
    private final Integer bonusNumber;

    public LottoScoreBoard(LottoDto winnerLotto, List<Lotto> winnerCandidates) {
        scoreBoard = new HashMap<>();
        this.winnerLotto = new Lotto(winnerLotto.getNumbers());
        this.winnerCandidates = winnerCandidates;
        this.bonusNumber = winnerLotto.getBonusBall();
    }

    public LottoScoreBoard(Lotto winnerLotto, List<Lotto> winnerCandidates) {
        scoreBoard = new HashMap<>();
        this.winnerLotto = winnerLotto;
        this.winnerCandidates = winnerCandidates;
        this.bonusNumber = -1;
    }

    public void scoring() {
        if (!scoreBoard.isEmpty()) {
            return;
        }
        for (Lotto lotto : winnerCandidates) {
            addScore(findPrize(lotto), lotto);
        }
    }

    private void addScore(Prize prize, Lotto lotto) {
        if (scoreBoard.containsKey(prize)) {
            scoreBoard.get(prize).add(lotto);
            return;
        }
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        scoreBoard.put(prize, lottoList);
    }

    private Prize findPrize(Lotto lotto) {
        long equalNumberCount = winnerLotto.getEqualNumberCountFrom(lotto);
        if (equalNumberCount == 5 && lotto.traverseCompareTo(bonusNumber) > 0) {
            return Prize.SECOND;
        }
        if (equalNumberCount == 5) {
            return Prize.THIRD;
        }
        return Prize.getPrizeByEqualNumberCount(equalNumberCount);
    }

    public Long getWinningsByPrize(Prize prize) {
        return (long) scoreBoard.getOrDefault(prize, new ArrayList<>()).size();
    }
}
