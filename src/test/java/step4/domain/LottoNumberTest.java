package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("로또 숫자는 1과 45 사이의 숫자이다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void lottoNumberTest(int number) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }
}
