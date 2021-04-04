package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 하나 생성")
    public void create() throws Exception {
        LottoNumber number = LottoNumber.of(1);
        assertThat(number).isEqualTo(LottoNumber.of("1"));
        LottoNumber newNumber = LottoNumber.of();
        assertThat(newNumber).isEqualTo(LottoNumber.of(newNumber.lottoNumber()));
    }

    @Test
    @DisplayName("로또 번호 1 ~ 45 외의 값 에러")
    public void checkBound() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(0));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46));
    }
}
