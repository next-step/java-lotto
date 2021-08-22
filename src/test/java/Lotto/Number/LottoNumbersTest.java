package Lotto.Number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("로또 숫자 리스트는")
public class LottoNumbersTest {
    public static final int LENGTH_OF_LOTTO_NUMBERS = 6;

    @DisplayName("길이가 6이 아닐 경우 에러 발생")
    @ParameterizedTest(name = "길이: {0}")
    @ValueSource(ints = {LENGTH_OF_LOTTO_NUMBERS - 1, LENGTH_OF_LOTTO_NUMBERS + 1})
    void lottoNumbersAboveOrUnder6ThrowsError(int length) {
        List<LottoNumber> given = new RandomNumbers(length, Limit.MIN.getValue(), Limit.MAX.getValue()).getValue();
        assertThatThrownBy(() -> new LottoNumbers(given)).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("로또 숫자는 6개입니다.");
    }

    @DisplayName("길이가 6일 경우 정상")
    @Test
    void lottoNumbersLengthMustBe6() {
        List<LottoNumber> given = new RandomNumbers(LENGTH_OF_LOTTO_NUMBERS, Limit.MIN.getValue(), Limit.MAX.getValue()).getValue();
        assertDoesNotThrow(() -> new LottoNumbers(given));
    }
}
