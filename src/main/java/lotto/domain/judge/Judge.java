package lotto.domain.judge;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.correctnumber.CorrectNumbers;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottorank.LottoRank;
import lotto.domain.lottorank.LottoRanks;

public class Judge {

    private final CorrectNumbers correctNumbers;

    public Judge(final CorrectNumbers correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    public LottoRanks getRanks(final List<Lotto> lottos) {
        return new LottoRanks(Collections.unmodifiableList(
                lottos.stream()
                        .map(this::getRank)
                        .collect(Collectors.toList())));
    }

    private LottoRank getRank(final Lotto lotto) {
        final int matchCount = lotto.matchNumber(correctNumbers.getWinningNumbers());
        final boolean isBonus = lotto.contains(correctNumbers.getBonusNumber());

        return LottoRank.getRank(matchCount, isBonus);
    }
}
