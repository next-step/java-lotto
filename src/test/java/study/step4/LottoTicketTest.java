package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step4.domain.LottoTicket;
import study.step4.domain.WinningLotto;
import study.step4.domain.WinningRank;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("등수확인 테스트 - 2등 추가")
    @Test
    public void checkWinningRankTest(){
        String selectedMyLottoNumbers = "1,2,3,4,5,6";
        String winningNumbers = "2,3,4,5,6,7";
        int bonusBall = 1;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);

        assertThat(new LottoTicket(selectedMyLottoNumbers).checkWinningRank(winningLotto))
                .isEqualTo(WinningRank.SECOND);
    }
}
