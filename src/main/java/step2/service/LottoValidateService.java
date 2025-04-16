package step2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.WinningNumber;
import step2.domain.Rank;

/**
 * 로또 검증 시스템
 */
public class LottoValidateService {
    private final Lottos bought;
    private final WinningNumber winner;
    private final Map<Rank, Integer> result = new HashMap<>();

    /**
     * 단일 장수 생성자
     */
    public LottoValidateService(Lotto lotto, WinningNumber winner) {
        this(new Lottos(List.of(lotto)), winner);
    }

    /**
     * 여러 장수 생성자
     */
    public LottoValidateService(Lottos bought, WinningNumber winner) {
        this.bought = bought;
        this.winner = winner;
    }

    /**
     * 전체 검증 시스템
     */
    public void validateAll() {
        Map<Lotto, Integer> matchCounts = bought.matchCountMap(winner.numbers());
        matchCounts.forEach(
            (lotto, matchCount) -> {
                Rank rank = Rank.of(matchCount);
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        );
    }

    /**
     * 검증 결과
     */
    public Map<Rank, Integer> result() {
        return result;
    }
}
