package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("주어진 6개의 숫자로 로또를 만들 수 있다")
    void testLottoGivenNumbers() {
        // Given
        LottoNumbers expected = new LottoNumbers(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                ));
        Lotto lotto = new Lotto(expected);

        // When
        LottoNumbers actual = lotto.getLottoNumbers();

        // Then
        assertThat(actual).isEqualTo(expected);
    }
}