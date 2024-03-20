package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class Lottos {
    private static final int MIN_WINNING_NUMBER = 3;
    private static final int INCREMENT_VALUE = 1;

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public HashMap<LottoRank, Integer> getWinningStatistics(List<Integer> winningNumber) {
        HashMap<LottoRank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            int count = lotto.getLottoNumber().getCountOfMatchLottoNumber(winningNumber);
            if (count >= MIN_WINNING_NUMBER)
                result.merge(LottoRank.findLottoRankByLottoCount(count), INCREMENT_VALUE, Integer::sum);
        }

        return result;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
