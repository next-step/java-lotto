package lotto.domain;

import lotto.domian.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("로또번호는 1 ~ 45이어야 한다.")
    public void lottoNumber_RangeInBetween1And45_IfNotThrowException() {
        int number = 46;
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(number));
    }

    @Test
    public void dd() {
        String a = "2 ";
        System.out.println(a.trim());
        System.out.println(a.trim().length());
    }
}
