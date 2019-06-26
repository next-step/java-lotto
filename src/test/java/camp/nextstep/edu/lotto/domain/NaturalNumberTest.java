package camp.nextstep.edu.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NaturalNumberTest {

    @Test
    @DisplayName("음수를 입력하면 IllegalArgumentException 을 발생시킵니다")
    void staticFactoryMethod_throwsIllegalArgumentException() {
        // given
        final int givenValue = -1;
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NaturalNumber.from(givenValue))
                // then
                .withMessageContaining("must be greater than or equal to");
    }

    @Test
    @DisplayName("0을 입력하면 0을 가지는 자연수를 반환합니다")
    void staticFactoryMethod_zero() {
        // given
        final int givenValue = 0;
        // when
        final NaturalNumber actual = NaturalNumber.from(givenValue);
        // then
        final int value = actual.value();
        assertThat(value).isEqualTo(0);
    }

    @Test
    @DisplayName("양수를 입력하면 해당 숫자를 가지는 자연수를 반환합니다")
    void staticFactoryMethod_positiveNumber() {
        // given
        final int givenValue = 1;
        // when
        final NaturalNumber actual = NaturalNumber.from(givenValue);
        // then
        final int value = actual.value();
        assertThat(value).isEqualTo(1);
    }
}