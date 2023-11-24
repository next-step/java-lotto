package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.LottoNumber;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호는 1이상 45이하의 정수로만 생성가능하다.")
    void numberTest() {
        assertThat(LottoNumber.valueOf(45).getNumber()).isEqualTo(45);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.valueOf(46));
    }
}
