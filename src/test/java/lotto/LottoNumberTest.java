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
    @DisplayName("로또 숫자는 1 ~ 45 이어야 한다.")
    public void createLottoNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("로또 숫자의 값이 같으면 같은 로또 숫자이다.")
    public void equalsLottoNumberTest(int num) {
        assertThat(new LottoNumber(num)).isEqualTo(new LottoNumber(num));
    }

}
