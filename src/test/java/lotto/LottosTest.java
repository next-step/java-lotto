package lotto;

import lotto.domain.Lottos;
import lotto.domain.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @ParameterizedTest
    @DisplayName("입력한 금액 만큼 Lotto를 생성 한다.")
    @MethodSource
    void createLottos(int money, int expected) {
        Lottos lottos = Lottos.from(money, new RandomNumberGenerator());

        assertThat(lottos.lottoCount()).isEqualTo(expected);
    }

    static Stream<Arguments> createLottos() {
        return Stream.of(
                Arguments.of(
                        1000, 1
                ),
                Arguments.of(
                        2000, 2
                ),
                Arguments.of(
                        3200, 3
                )
        );
    }
}