package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("1 ~ 45 를 넘어가는 숫자는 예외가 발생한다.")
    @ValueSource(ints = {0, 46})
    void newInstance(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input))
                .withMessageContaining("1 ~ 45 까지만 허용됩니다.");
    }

    @Test
    void compareTo() {
        LottoNumber numberOne = new LottoNumber(1);
        LottoNumber numberTwo = new LottoNumber(2);

        assertThat(numberOne.compareTo(numberTwo)).isLessThan(0);
    }
}
