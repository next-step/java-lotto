package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2_1.domain.LottoTicket;
import study.step2_1.domain.WinningRank;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("등수확인 테스트")
    @Test
    public void checkWinningRankTest(){
        String selectedMyLottoNumbers = "1,2,3,4,5,6";
        LottoTicket winningTicket = new LottoTicket("2,3,4,5,6,7");
        assertThat(new LottoTicket(selectedMyLottoNumbers).checkWinningRank(winningTicket)).isEqualTo(WinningRank.SECOND);
    }
}
