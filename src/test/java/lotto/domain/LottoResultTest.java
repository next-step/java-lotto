package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @DisplayName("ranking 일치 시 count 증가 여부 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void updateCountTest(int count) {
        Ranking ranking = Ranking.valueOfRanking(count);
        lottoResult.updateCount(ranking);
        assertThat(lottoResult.getLottoResultMap().get(ranking)).isNotZero();
    }

    @DisplayName("총 수익률 구하는 테스트")
    @Test
    void findProfitRateTest() {
        Money money = Money.of(5000);
        lottoResult.updateCount(Ranking.FIFTH);
        assertThat(lottoResult.findProfitRate(money))
                .isEqualTo((double) Ranking.FIFTH.getPrizeMoney() / money.getPrice());
    }

    @DisplayName("당첨 확인 테스트")
    @Test
    void findWinningLottoTest() {
        final Lotto lotto = Lotto.of(Arrays.asList(7, 9, 11, 18, 24, 39));
        final WinningLotto winningLotto = WinningLotto.of(Arrays.asList(7, 9, 11, 18, 24, 39));

        assertThat(lotto.findRankingByLotto(winningLotto.getWinningLotto())).isEqualTo(Ranking.FIRST);
    }
}