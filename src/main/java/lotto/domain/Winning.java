package lotto.domain;

import lotto.dto.AnnounceWinning;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Winning {

    private final Set<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    private Winning(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static Winning of(AnnounceWinning announceWinning) {
        return new Winning(announceWinning.getAnnounceWinning().stream()
                                   .map(LottoNumber::of)
                                   .collect(Collectors.toSet()),
                           LottoNumber.of(announceWinning.getBonusNumber()));
    }

    public List<LottoRank> scratch(Lottos lottos) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            lottoRanks.add(LottoRank.of(calculateMatchCount(lotto), isMatchingBonus(lotto)));
        }
        return lottoRanks;
    }

    private int calculateMatchCount(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    private boolean isMatchingBonus(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
