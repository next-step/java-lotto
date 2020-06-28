package lotto;

import lotto.domain.store.LottoMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMoneyTest {

    @ParameterizedTest
    @DisplayName("입력한 돈이 1000원으로 나누어 떨어 지지 않을 경우 Exception")
    @MethodSource("provideInvalidMoney")
    void FailToSetMoneyIfInputMoneyIsInvalid(BigDecimal input) {
        assertThatThrownBy(() -> new LottoMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidMoney() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(4444)),
                Arguments.of(BigDecimal.valueOf(5555)),
                Arguments.of(BigDecimal.valueOf(500)),
                Arguments.of(BigDecimal.valueOf(777))
        );
    }

    @ParameterizedTest
    @DisplayName("지불한 돈 만큼의 로또 장수를 반환 하는 지 테스트")
    @MethodSource("provideMoney")
    void NumberOfLottoIsEqualWithMoneyPaid(BigDecimal input, int expected) {
        LottoMoney lottoMoney = new LottoMoney(input);
        int actual = lottoMoney.getNumberOfLottoByMoneyPaid();

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMoney() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(5000), 5),
                Arguments.of(BigDecimal.valueOf(15000), 15),
                Arguments.of(BigDecimal.valueOf(1000), 1)
        );
    }
}
