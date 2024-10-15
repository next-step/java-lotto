package lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    @DisplayName("로또 당첨번호와 일치 여부를 반환한다.")
    void 당첨번호와_일치여부() {
        String[] winningNumbers = new String[]{"10", "39", "4", "1", "23", "31"};

        LottoNumber lottoNumber1 = new LottoNumber(39);
        LottoNumber lottoNumber2 = new LottoNumber(20);

        boolean containedNumber = lottoNumber1.isContain(winningNumbers);
        boolean notContainedNumber = lottoNumber2.isContain(winningNumbers);

        assertThat(containedNumber).isTrue();
        assertThat(notContainedNumber).isFalse();
    }
}