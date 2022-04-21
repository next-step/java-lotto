package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class LottosTest {

    private static final Lotto WINNING_LOTTO =
            new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @ParameterizedTest(name = "한 개 로또 수익율 계산")
    @MethodSource("provideArgumentsForEarningRate")
    void earningRate_SingleLotto(Lotto lotto, double earningRate) {
        Lottos lottos = new Lottos(lotto);

        assertThat(lottos.earningRate(WINNING_LOTTO))
                .isEqualTo(earningRate, withPrecision(0.01));
    }

    private static Stream<Arguments> provideArgumentsForEarningRate() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 7, 8, 9, 10)), Prize.findEarningsByMatchCount(2) / LOTTO_PRICE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 7, 8, 9)), Prize.findEarningsByMatchCount(3) / LOTTO_PRICE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 7, 8)), Prize.findEarningsByMatchCount(4) / LOTTO_PRICE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Prize.findEarningsByMatchCount(5) / LOTTO_PRICE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Prize.findEarningsByMatchCount(6) / LOTTO_PRICE)
        );
    }

    @DisplayName("여러개 로또 수익율 계산")
    @Test
    void earningRate_MultipleLottos() {
        Lotto zeroMatchLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto threeMatchLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto fourMatchLotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lottos lottos = new Lottos(List.of(zeroMatchLotto, threeMatchLotto, fourMatchLotto));

        // (0 + 5000 + 50000) / (3 * 1000) = 18.33333..
        assertThat(lottos.earningRate(WINNING_LOTTO))
                .isEqualTo(18.33, withPrecision(0.01));
    }
}
