package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberDuplicatedExceptionTest {

    @Test
    public void test() {
        assertThatExceptionOfType(LottoNumberDuplicatedException.class)
                .isThrownBy(() -> {
                    throw new LottoNumberDuplicatedException();
                });
    }
}
