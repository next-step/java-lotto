package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.enums.Prize;

class LottoTicketTest {
    @Test
    @DisplayName("당첨 테스트")
    void matchWinningLotto() {
        //given
        int 자동_로또_개수 = 0;
        WinningNumber 당첨_번호 = WinningNumber.of(1, 2, 3, 4, 5, 6);

        Lotto 내가_선택한_번호 = Lotto.of(1, 2, 3, 4, 5, 16);
        LottoNumber 보너스_번호 = LottoNumber.of(45);
        LottoTicket 로또_티켓 = new LottoTicket(자동_로또_개수, 내가_선택한_번호);
        //when
        LottoResult 결과 = 로또_티켓.matchWinningNumber(당첨_번호, 보너스_번호);
        //then
        assertThat(결과.count(Prize.THIRD)).isEqualTo(1);
        assertThat(결과.income()).isEqualTo(Prize.THIRD.money());
    }
}