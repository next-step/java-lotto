package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoResultTest {

    private List<Rank> target;

    @BeforeEach
    void setUp() {
        target = List.of(
                Rank.FIFTH, Rank.FIFTH,
                Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE,
                Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE
        );
    }

    @Test
    @DisplayName("LottoResult를 정상적으로 생성한다.")
    void createSuccess() {
        /* given */

        /* when & then */
        assertDoesNotThrow(() -> new LottoResult(target));
    }

    @Test
    @DisplayName("수익률을 구한다.")
    void calculateTotalPrize() {
        /* given */
        LottoResult lottoResult = new LottoResult(target);
        long money = target.size() * 1000L;

        /* when */
        double rateOfReturn = lottoResult.calculateRateOfReturn(money);

        /* then */
        double expectedRateOfReturn = Rank.FIFTH.getPrize() * 2L / (double) money;
        assertThat(rateOfReturn).isEqualTo(expectedRateOfReturn);
    }
}
