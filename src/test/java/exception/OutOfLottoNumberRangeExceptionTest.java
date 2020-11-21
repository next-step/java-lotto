package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OutOfLottoNumberRangeExceptionTest {
    @Test
    void test() {
        assertThatExceptionOfType(OutOfLottoNumberRangeException.class)
                .isThrownBy(() -> {
                    throw new OutOfLottoNumberRangeException();
                });
    }
}
