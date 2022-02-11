package lotto.domain.judge;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.correctnumber.CorrectNumbers;
import lotto.domain.lotto.Lottos;
import lotto.domain.lottorank.LottoRank;
import lotto.domain.lottorank.LottoRanks;

public class Judge {

    private final CorrectNumbers correctNumbers;

    public Judge(final CorrectNumbers correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    public LottoRanks getRanks(final Lottos lottos) {
        final List<LottoRank> lottoRanks = new ArrayList<>();

        lottos.get().forEach(lotto -> {
            int matchCount = lotto.matchNumber(correctNumbers.getWinningNumbers());
            boolean isBonus = lotto.contains(correctNumbers.getBonusNumber());

            lottoRanks.add(LottoRank.getRank(matchCount, isBonus));
        });

        return new LottoRanks(lottoRanks);
    }
}
