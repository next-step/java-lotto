package stringadder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringAdderTest {
    private static final String[] EMPTY_ARRAY = {};

    @DisplayName("값이 없을 경우 0을 반환한다.")
    @Test
    void addWithEmptyRawNumbers() {
        StringAdder adder = new StringAdder(EMPTY_ARRAY);

        assertThat(adder.add()).isEqualTo(0);
    }

    @DisplayName("값이 하나인 경우 해당 값을 반환한다.")
    @Test
    void addWithSingleRawNumbers() {
        StringAdder adder = new StringAdder(new String[]{"1"});

        assertThat(adder.add()).isEqualTo(1);
    }

    @DisplayName("값이 여러개인 경우 합을 반환한다.")
    @Test
    void addWithMultipleRawNumbers() {
        StringAdder adder = new StringAdder(new String[]{"1", "2"});

        assertThat(adder.add()).isEqualTo(3);
    }

    @DisplayName("입력값이 null일 경우 0을 반환한다.")
    @Test
    void NullShouldReturnZero() {
        StringAdder adder = new StringAdder(null);

        assertThat(adder.add()).isEqualTo(0);
    }

    @DisplayName("정수로 변환되지 않는 값이 배열에 있으면 exception을 던진다.")
    @Test
    void NotValidInputShouldThrowRuntimeException() {
        StringAdder adder = new StringAdder(new String[]{"1", "-1"});

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
            () -> adder.add()
        );
    }
}