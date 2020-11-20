package exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoPriceExceptionTest {

    @DisplayName("LottoPriceException 테스트")
    @Test
    public void test_LottoPrice_ThrowException() {
        assertThatExceptionOfType(LottoPriceException.class)
                .isThrownBy(() -> {
                    throw new LottoPriceException();
                });
    }
}
