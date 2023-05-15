package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0,46})
    @DisplayName("범위를 벗어난 숫자를 할당받으면 예외를 던진다.")
    void 숫자범위(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(number);
        });
    }

    @Test
    @DisplayName("숫자 값을 일치여부를 확인할 수 있다.")
    void equals() {
        LottoNumber lottoNumber = new LottoNumber(10);
        assertThat(lottoNumber.equals(new LottoNumber(10))).isTrue();
    }

    @Test
    @DisplayName("다른 LottoNumber와 숫자를 비교할 수 있다.")
    void compare() {
        LottoNumber lottoNumber1 = new LottoNumber(10);
        LottoNumber lottoNumber2 = new LottoNumber(20);
        assertThat(lottoNumber1.compareTo(lottoNumber2)).isEqualTo(-1);
    }
}
