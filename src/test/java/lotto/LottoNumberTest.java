package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    @DisplayName("로또에 사용 되는 숫자는 값 객체로 생성한다")
    public void createLottoNumberByConstructor() {
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(new LottoNumber(1)).isEqualTo(lottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void throwIllegalArgumentExceptionWhenInputOverRange(int value) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(value);
        });
    }
}
