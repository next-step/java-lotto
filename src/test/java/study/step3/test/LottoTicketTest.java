package study.step3.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.LottoTicket;
import study.step3.domain.WinningRank;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("등수확인 테스트 - 2등 추가")
    @Test
    public void checkWinningRankTest(){
        String selectedMyLottoNumbers = "1,2,3,4,5,6";
        LottoTicket winningTicket = new LottoTicket("2,3,4,5,6,7");
        int bonusBall = 1;
        assertThat(new LottoTicket(selectedMyLottoNumbers).checkWinningRank(winningTicket,bonusBall)).isEqualTo(WinningRank.SECOND);
    }
}
