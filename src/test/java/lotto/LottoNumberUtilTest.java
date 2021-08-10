package lotto;

import lotto.model.LottoNumber;
import lotto.model.LottoNumberPicker;
import lotto.model.LottoNumbers;
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

    @Test
    void 숫자가_이미뽑힌건지_체크() {
        LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> {
            LottoNumberUtil.containsNumber(
                    lottoNumbers.selectedNumber(), LottoNumberPicker.pickNumber(1));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
