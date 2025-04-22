package step4.service;

import java.util.Map;
import java.util.stream.Collectors;

import step4.domain.Lottos;
import step4.domain.Rank;
import step4.domain.WinningNumber;

/**
 * 로또 검증 시스템
 */
public class LottoValidateService {
    private final WinningNumber winner;

    public LottoValidateService(WinningNumber winner) {
        this.winner = winner;
    }

    public Map<Rank, Integer> validate(Lottos bought) {
        return bought.matchResultMap(winner)
            .values().stream()
            .map(Rank::of)
            .collect(Collectors.toMap(
                rank -> rank,
                rank -> 1,
                Integer::sum
            ));
    }
}
