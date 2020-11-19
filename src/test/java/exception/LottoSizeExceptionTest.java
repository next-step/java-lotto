package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoSizeExceptionTest {

    @Test
    public void test() {
        assertThatExceptionOfType(LottoSizeException.class)
                .isThrownBy(() -> {
                    throw new LottoSizeException();
                });
    }
}
