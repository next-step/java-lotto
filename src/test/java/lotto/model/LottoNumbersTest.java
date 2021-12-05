package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호는 중복될 수 없다")
    void testLottoNumbersShouldNotBeSameOne() {
        // Given
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(2),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        // When & Then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }
}