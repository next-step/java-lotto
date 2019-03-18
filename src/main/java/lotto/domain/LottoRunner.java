package lotto.domain;

import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoBundle;
import lotto.enums.LottoRank;
import lotto.vo.LottoResult;

public class LottoRunner {
    private LottoRunner() {
    }

    public static LottoResult runLotto(Lotto winner, LottoBundle lottoBundle) {
        return new LottoResult(getMatchCounts(winner, lottoBundle));
    }

    static long[] getMatchCounts(Lotto winner, LottoBundle lottoBundle) {
        long[] result = new long[LottoRank.SECOND.getMatchCount() + 1];

        lottoBundle.getLottos().forEach(lotto -> {
            int numberOfDuplicatedNumbers = lotto.getMatchCounts(winner);
            result[numberOfDuplicatedNumbers]++;
        });

        return result;
    }
}
