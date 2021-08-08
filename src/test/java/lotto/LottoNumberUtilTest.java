package lotto;

import lotto.util.LottoNumberUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberUtilTest {

    @Test
    void 로또_숫자_유효성_검사() {
        assertThat(LottoNumberUtil.validNumber(1))
                .isEqualTo(true);
        assertThat(LottoNumberUtil.validNumber(23))
                .isEqualTo(true);
        assertThat(LottoNumberUtil.validNumber(45))
                .isEqualTo(true);
    }

    @Test
    void 로또_숫자_유효성_검사2() {
        assertThatThrownBy(() -> {
            LottoNumberUtil.validNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            LottoNumberUtil.validNumber(0);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
