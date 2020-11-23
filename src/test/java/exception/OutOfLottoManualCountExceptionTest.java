package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OutOfLottoManualCountExceptionTest {

    @Test
    void test() {
        assertThatExceptionOfType(OutOfLottoManualCountException.class)
                .isThrownBy(() -> {
                    throw new OutOfLottoManualCountException();
                });
    }
}
