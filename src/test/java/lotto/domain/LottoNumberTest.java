package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    public void 정상_생성자() {
        assertThat(new LottoNumber(5).getLottoNumber()).isEqualTo(5);
    }

    // -1 0 46
    @Test
    public void 입력_범위와_다른_숫자() {
        assertThatThrownBy(() -> {
            new LottoNumber(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    // one 하나
    @Test
    public void 한글_생성자() {
        assertThatThrownBy(() -> {
            new LottoNumber("하나");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
