package lotto.domain;

import lotto.domain.enums.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    void create() {
        Integer purchaseAmount = 1000;
        Lottos lottos = new Lottos(lotto()::numbers, purchaseAmount);

        assertThat(lottos).isEqualTo(new Lottos(List.of(lotto())));
    }

    @DisplayName("구매한 로또 개수를 구한다")
    @Test
    void count() {
        Integer purchaseAmount = 14000;
        Lottos lottos = new Lottos(lotto()::numbers, purchaseAmount);

        assertThat(lottos.count()).isEqualTo(14);
    }

    @DisplayName("구매한 로또들 중에 특정 등수에 당첨된 로또 수를 구한다")
    @ParameterizedTest
    @CsvSource(value = {
            "FIRST,0",
            // TODO "SECOND,0",
            "THIRD,0",
            "FOURTH,1",
            "FIFTH,2",
    })
    void winningCount(LottoPrize lottoPrize, Integer expected) {
        Integer result = lottos().winningCount(lotto(), lottoPrize);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("총 수익률을 구한다")
    @Test
    void totalProfitRate() {
        BigDecimal result = lottos().totalProfitRate(lotto());

        BigDecimal expected = BigDecimal.valueOf(60_000L).divide(BigDecimal.valueOf(5000L), 2, RoundingMode.FLOOR);
        assertThat(result).isEqualTo(expected);
    }

    private Lotto lotto() {
        return new Lotto(List.of(1, 2, 3, 20, 43, 31));
    }

    private Lottos lottos() {
        return new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(11, 12, 13, 20, 43, 31)),
                new Lotto(List.of(1, 2, 3, 20, 5, 6)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(21, 22, 23, 24, 25, 26))));
    }
}