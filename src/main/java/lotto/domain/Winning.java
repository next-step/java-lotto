package lotto.domain;

import lotto.dto.AnnounceWinning;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Winning {

    private final Set<Integer> winningNumbers;

    private Winning(Set<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static Winning of(AnnounceWinning announceWinning) {
        return new Winning(announceWinning.getAnnounceWinning());
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
