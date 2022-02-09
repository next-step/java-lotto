package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    private final CorrectNumbers correctNumbers;

    public Judge(final CorrectNumbers correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    public LottoRanks getRanks(final Lottos lottos) {
        final List<LottoRank> lottoRanks = new ArrayList<>();

        lottos.get().stream()
                .forEach(lotto -> {
                    int matchCount = lotto.matchNumber(correctNumbers.getWinningNumbers());
                    boolean isBonus = lotto.containsBonusNumber(correctNumbers.getBonusNumber());

                    lottoRanks.add(LottoRank.getRank(matchCount, isBonus));
                });

        return new LottoRanks(lottoRanks);
    }
}
