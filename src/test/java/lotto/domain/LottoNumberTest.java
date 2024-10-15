package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("숫자로 입력받은 값을 가지고 있습니다.")
    void containNumberTest(int number) {
        LottoNumber lottoNumber = LottoNumber.valueOf(number);
        assertThat(lottoNumber.value()).isEqualTo(number);
    }

    @Test
    @DisplayName("범위 밖의 숫자로 만들려고 하면 IllegalArgumentException을 띄웁니다")
    void numberOutOfRangeTest() {
        int numbersOutOfRange = 50;
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.valueOf(numbersOutOfRange));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("같은 숫자로 만들어지면 equals true입니다.")
    void equalsTest(int number) {
        LottoNumber lottoNumber1 = LottoNumber.valueOf(number);
        LottoNumber lottoNumber2 = LottoNumber.valueOf(number);
        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("같은 숫자로 만들어지면 hashCode가 같습니다.")
    void hashCodeTest(int number) {
        LottoNumber lottoNumber1 = LottoNumber.valueOf(number);
        LottoNumber lottoNumber2 = LottoNumber.valueOf(number);
        assertThat(lottoNumber1.hashCode()).isEqualTo(lottoNumber2.hashCode());
    }
}
