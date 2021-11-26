package lotto.domain;

import lotto.exception.ManualLottoCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @DisplayName("Money 생성 테스트")
    @ValueSource(ints = {1000, 2000, 3000})
    void createMoney(int purchaseAmount) {
        Money money = Money.from(purchaseAmount);

        assertThat(money).isInstanceOf(Money.class);
    }

    @ParameterizedTest
    @DisplayName("수동 로또 구입 개수가 구입 금액보다 클 경우 예외")
    @MethodSource
    void manualLottoCountException(Money money, int manualCount) {
        assertThatThrownBy(() -> money.validateManualLottoCount(manualCount)).isInstanceOf(ManualLottoCountException.class);
    }

    static Stream<Arguments> manualLottoCountException() {
        return Stream.of(
                Arguments.of(
                        Money.from(1000), 2
                )
        );
    }
}