package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberOutOfRangeExceptionTest {

    @Test
    public void test() {
        assertThatExceptionOfType(OutOfLottoNumberRangeException.class)
                .isThrownBy(() -> {
                            throw new OutOfLottoNumberRangeException();
                        }
                );
    }
}
