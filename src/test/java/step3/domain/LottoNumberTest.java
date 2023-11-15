package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("로또번호는 숫자")
    void create() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(lottoNumber.number()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또번호 생성 가능한 숫자는 1~45이다. 예외 테스트")
    void createException(int input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(input));
    }


}
