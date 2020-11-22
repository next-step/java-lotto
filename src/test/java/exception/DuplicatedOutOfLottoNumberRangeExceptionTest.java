package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DuplicatedOutOfLottoNumberRangeExceptionTest {

    @Test
    public void test() {
        assertThatExceptionOfType(DuplicatedLottoNumberException.class)
                .isThrownBy(() -> {
                    throw new DuplicatedLottoNumberException();
                });
    }
}
