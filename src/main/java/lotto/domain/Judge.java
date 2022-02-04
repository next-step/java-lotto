package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    private CorrectNumbers correctNumbers;

    public Judge(CorrectNumbers correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    public LottoRanks getRanks(Lottos lottos) {
        List<LottoRank> lottoRanks = new ArrayList<>();

        lottos.get().stream()
            .forEach(lotto -> {
                int matchCount = lotto.matchNumber(correctNumbers.getWinningNumbers().get());
                boolean isBonus = lotto.containsBonusNumber(correctNumbers.getBonusNumber().get());

                lottoRanks.add(LottoRank.getRank(matchCount, isBonus));
            });

        return new LottoRanks(lottoRanks);
    }
}
