package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 하나 생성")
    public void create() throws Exception {
        LottoNumber number = new LottoNumber(1);
        assertThat(number).isEqualTo(new LottoNumber(1));
        LottoNumber newNumber = new LottoNumber();
        assertThat(newNumber).isEqualTo(new LottoNumber(newNumber.lottoNumber()));
    }

    @Test
    @DisplayName("로또 번호 1 ~ 45 외의 값 에러")
    public void checkBound() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
    }
}
