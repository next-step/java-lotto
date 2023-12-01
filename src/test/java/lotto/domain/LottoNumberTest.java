package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 번호 테스트")
public class LottoNumberTest {

    @DisplayName("로또 번호는 0보다 크고 46보다 작다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void LottoNumberTest(int number) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber.valueOf(number);
        });
    }

    @DisplayName("두 로또 번호가 같을 경우 1을 반환한다.")
    @Test
    void getResultIfEqual() {
        LottoNumber number = new LottoNumber(1);
        Assertions.assertThat(number.getResultIfEqual(LottoNumber.valueOf(1))).isEqualTo(1);
    }
}
