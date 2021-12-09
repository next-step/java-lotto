package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @ParameterizedTest(name = "1이상 45이하의 숫자가 아니면 IllegalArgumentException을 throw한다")
    @ValueSource(ints = {0, 46})
    void testLottoNumberBounds(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }

    @Test
    @DisplayName("number가 같은 LottoNumber는 같아야 한다")
    void testCompareLottoNumber_same() {
        // Given
        LottoNumber lottoNumberA = new LottoNumber(3);
        LottoNumber lottoNumberB = new LottoNumber(3);

        // Expect
        assertThat(lottoNumberA).isEqualTo(lottoNumberB);
    }

    @Test
    @DisplayName("number가 작은 LottoNumber가 더 작아야 한다")
    void testCompareLottoNumber_less() {
        // When
        LottoNumber lottoNumberSmall = new LottoNumber(3);
        LottoNumber lottoNumberLarge = new LottoNumber(5);

        // Expect
        assertThat(lottoNumberSmall).isLessThan(lottoNumberLarge);
    }
}