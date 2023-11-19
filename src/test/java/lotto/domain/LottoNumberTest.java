package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("같은 숫자를 입력하면, 항상 같은 로또번호가 리턴된다.")
    @Test
    void memorizeNumberTest() {
        final LottoNumber lottoNumber = LottoNumber.memorizeNumber(3);
        assertThat(lottoNumber).isEqualTo(LottoNumber.memorizeNumber(3));
    }

    @DisplayName("로또번호는 1이상 45이하 여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    void invalid_로또번호(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }
}

