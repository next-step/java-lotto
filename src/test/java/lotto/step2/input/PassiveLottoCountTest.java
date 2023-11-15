package lotto.step2.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PassiveLottoCountTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9, 15})
    @DisplayName("생성자로 정상적인 수동으로 구매할 로또 수가 입력되면, 생성된 객체는 수동으로 구매할 로또 수를 가지고 있다.")
    void testPassiveLottoCountConstructor(final int userCountInput) {
        //given
        PassiveLottoCount passiveLottoCount = new PassiveLottoCount(userCountInput);

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
        assertThatThrownBy(() -> new PassiveLottoCount(userCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("passiveLottoCount must be greater than 0");
    }
}
