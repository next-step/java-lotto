package step2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step2.domain.Lotto;
import step2.domain.LottoList;
import step2.domain.LottoWinner;
import step2.domain.Rank;

/**
 * 로또 검증 시스템
 */
public class LottoValidateService {
    private final LottoList bought;
    private final LottoWinner winner;
    private final Map<Rank, Integer> result = new HashMap<>();

    /**
     * 단일 장수 생성자
     */
    public LottoValidateService(Lotto lotto, LottoWinner winner) {
        this(new LottoList(List.of(lotto)), winner);
    }

    /**
     * 여러 장수 생성자
     */
    public LottoValidateService(LottoList bought, LottoWinner winner) {
        this.bought = bought;
        this.winner = winner;
    }

    /**
     * 전체 검증 시스템
     */
    public void validateAll() {
        for (Lotto lotto : bought.getLottoList()) {
            Rank rank = validateLotto(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    /**
     * 단일 검증 시스템
     */
    private Rank validateLotto(Lotto requestLotto) {
        int matchCount = 0;
        for (Integer number : requestLotto.getLottoNumbers()) {
            if (winner.getWinningNumbers().contains(number)) {
                matchCount++;
            }
        }
        return Rank.of(matchCount);
    }

    /**
     * 검증 결과
     */
    public Map<Rank, Integer> getResult() {
        return result;
    }
}
