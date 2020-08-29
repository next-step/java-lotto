package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {


    private LottoTicket winningNumber;
    private BonusNumber bonusNumber;
    private WinningNumber winningNumbers;
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(Arrays.asList(11,2,31,41,25,36));
        winningNumber = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        bonusNumber = new BonusNumber(7);
        winningNumbers = new WinningNumber(winningNumber, bonusNumber);
    }

    @Test
    @DisplayName("로또 복권에 포함되는 당첨번호 확인")
    void isContainsLottoNumber() {
        int lottoIndex = lottoTicket.getLottoTicket().get(1);
        boolean result = winningNumbers.isContainsLottoNumber(lottoIndex);
        assertThat(result).isTrue();
    }

}
