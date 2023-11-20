package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Lotto 는 아무런 숫자가 주어지지 않으면 예외를 던진다.")
    void newObject_NullAndEmpty_throwsException(String emptyAndNullInput) {
        assertThatThrownBy(
            () -> new Lotto(emptyAndNullInput)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 는 1 ~ 45 사이 숫자가 아니면 예외를 던진다.")
    void newObject_outOfRange_throwsException() {
        assertThatThrownBy(
            () -> new Lotto("1,2,3,4,5,46")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 는 6자리 숫자가 아니면 예외를 던진다")
    void newObject_invalidCount_throwsException() {
        assertThatThrownBy(
            () -> new Lotto("1,2,3,4,5,6,7")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 는 중복된 숫자가 있으면 예외를 던진다")
    void newObject_duplicationNumber_throwsException() {
        assertThatThrownBy(
            () -> new Lotto("1,2,3,4,5,5")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
