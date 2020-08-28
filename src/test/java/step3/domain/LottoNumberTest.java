package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("LottoNumber 객체 비교")
    public void makeLottoNumberTest() {
        assertThat(new step2.domain.LottoNumber(3)).isEqualTo(new step2.domain.LottoNumber(3));
    }

    @Test
    @DisplayName("에외 처리 여부 테스트 ")
    public void makeLottoExceptionTest() {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
