package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.constant.LottoRank;

public class LottoAnnounce {

    private final Lotto winningNumber;

    public LottoAnnounce(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    }

    public LottoRanks createRanks(List<Lotto> lottos) {
        return new LottoRanks(lottos.stream()
            .map(this::scoreHit)
            .map(LottoRank::toWinLotto)
            .collect(Collectors.toList()));
    }

    private int scoreHit(Lotto lotto) {
        return (int) lotto.getNumbers()
            .stream()
            .filter(number -> winningNumber.getNumbers().contains(number))
            .count();
    }

}
