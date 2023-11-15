package lotto.step2.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.step2.input.PassiveLottoCount.MIN_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PassiveLottoCountTest {

    private final int maxPassiveLottoCount = 150;

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9, 15, 100})
    @DisplayName("생성자로 범위내의 수동으로 구매할 로또 수가 입력되면, 생성된 객체는 수동으로 구매할 로또 수를 가지고 있다.")
    void testPassiveLottoCountConstructor(final int userCountInput) {
        //given
        PassiveLottoCount passiveLottoCount = new PassiveLottoCount(userCountInput, maxPassiveLottoCount);

        //when
        final int value = passiveLottoCount.getValue();

        //then
        assertThat(value).isEqualTo(userCountInput);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -3})
    @DisplayName("생성자로 0개 이하의 수동으로 구매할 로또 수가 입력되면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenPassiveLottoCountIsLessThanZeroAndIsEqualToZero(final int userCountInput) {
        //given, when, then
        assertThatThrownBy(() -> new PassiveLottoCount(userCountInput, maxPassiveLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("passiveLottoCount must be between " + MIN_VALUE + " and " + maxPassiveLottoCount);
    }

    @Test
    @DisplayName("생성자로 최대 수동으로 구매할 로또 수보다 더 큰 값이 입력되면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenPassiveLottoCountIsGreaterThanMaxValue() {
        //given, when, then
        assertThatThrownBy(() -> new PassiveLottoCount(maxPassiveLottoCount + 1, maxPassiveLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("passiveLottoCount must be between " + MIN_VALUE + " and " + maxPassiveLottoCount);
    }
}
