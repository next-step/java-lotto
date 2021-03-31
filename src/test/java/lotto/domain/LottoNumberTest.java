package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 하나 생성")
    public void create() throws Exception {
        LottoNumber number = new LottoNumber(1);
        assertThat(number).isEqualTo(new LottoNumber(1));
        LottoNumber newNumber = new LottoNumber();
        assertThat(newNumber).isEqualTo(new LottoNumber(newNumber.lottoNumber()));
    }
}
