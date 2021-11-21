package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @ParameterizedTest
    @DisplayName("Lotto의 개수를 리턴한다.")
    @MethodSource
    void lottosCountTest(Lottos lottos, int count) {
        assertThat(lottos.lottoCount()).isEqualTo(count);
    }

    static Stream<Arguments> lottosCountTest() {
        return Stream.of(
                Arguments.of(
                        LottosFactory.from(Money.from(1000), new RandomLottoNumbersGenerator()), 1
                ),
                Arguments.of(
                        LottosFactory.from(Money.from(2000), new RandomLottoNumbersGenerator()), 2
                ),
                Arguments.of(
                        LottosFactory.from(Money.from(10000), new RandomLottoNumbersGenerator()), 10
                )
        );
    }
}