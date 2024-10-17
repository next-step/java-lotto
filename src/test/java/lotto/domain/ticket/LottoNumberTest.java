package lotto.domain.ticket;

import lotto.domain.winning.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호와 당첨번호의 일치 여부를 반환한다.")
    void 로또번호와_당첨번호_일치여부() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(10, 39, 4, 1, 23, 31),
                                                            new LottoNumber(40));

        LottoNumber lottoNumber1 = new LottoNumber(39);
        LottoNumber lottoNumber2 = new LottoNumber(20);

        boolean containedNumber = lottoNumber1.matchWinningNumbers(winningNumbers);
        boolean notContainedNumber = lottoNumber2.matchWinningNumbers(winningNumbers);

        assertThat(containedNumber).isTrue();
        assertThat(notContainedNumber).isFalse();
    }
}