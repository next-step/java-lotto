package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    public void 생성_테스트() {
        LottoNumber num = LottoNumber.of(1);
        assertThat(num).isEqualTo(LottoNumber.of(1));
    }

    @Test
    public void 생성_테스트_잘못된경우() {
        assertThatThrownBy(() -> {
            LottoNumber num = LottoNumber.of(0);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            LottoNumber num = LottoNumber.of(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
