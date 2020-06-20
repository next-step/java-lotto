package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 번호 한개 클래스 테스트")
public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 범위 테스트")
    void validateRangeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
    }

    @Test
    @DisplayName("로또 번호가 같으면 true 테스트")
    void compareToNumberTest() {
        LottoNumber lottoNumber = new LottoNumber(3);

        assertThat(lottoNumber.compareToNumber(new LottoNumber(3))).isTrue();
    }

}
