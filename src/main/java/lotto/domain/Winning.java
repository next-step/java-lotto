package lotto.domain;

import lotto.dto.AnnounceWinning;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Winning {

    private final Set<LottoNumber> winningNumbers;

    private Winning(Set<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static Winning of(AnnounceWinning announceWinning) {
        return new Winning(announceWinning.getAnnounceWinning().stream()
                                   .map(LottoNumber::of)
                                   .collect(Collectors.toSet()));
    }

    public List<LottoRank> scratch(Lottos lottos) {
        return lottos.getLottos().stream()
                .map(this::calculateMatchCount)
                .map(LottoRank::of)
                .collect(Collectors.toList());
    }

    private int calculateMatchCount(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();
    }
}
