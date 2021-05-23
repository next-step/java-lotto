package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @DisplayName("자동로또번호발생 범위 테스트")
    @Test
    void 자동로또번호발생_범위() {
        assertThatThrownBy(()->new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1과 45 사이의 정수여야 합니다.");
        assertThatThrownBy(()->new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1과 45 사이의 정수여야 합니다.");
    }

}
