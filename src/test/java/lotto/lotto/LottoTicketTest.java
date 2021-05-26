package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.enums.Prize;

class LottoTicketTest {
    @Test
    @DisplayName("당첨 테스트")
    void matchWinningLotto() {
        //given
        LottoTicket lottoTicket = new LottoTicket();
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 1; i < 7; i++) {
            LottoNumber lottoNumber = new LottoNumber(i);
            numbers.add(lottoNumber);
        }

        WinningNumber winningNumber = new WinningNumber(numbers);

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16));
        LottoNumber bonusNumber = new LottoNumber(45);
        lottoTicket.add(lotto);
        //when
        LottoResult lottoResult = lottoTicket.matchWinningNumber(winningNumber, bonusNumber);
        //then
        assertThat(lottoResult.count(Prize.THIRD)).isEqualTo(1);
        assertThat(lottoResult.income()).isEqualTo(Prize.THIRD.money());
    }
}