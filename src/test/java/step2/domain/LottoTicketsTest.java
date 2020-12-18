package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    @DisplayName("등수 확인 테스트")
    @ParameterizedTest
    public void winningRankTest(){
        String myLottoNumbers = "4,8,12,16,20,24";
        LottoTicket winningTicket = new LottoTicket("2,4,8,10,12,14");
        assertThat(new LottoTicket(myLottoNumbers).checkWinningRank(winningTicket)).isEqualTo(WinningRank.THIRD);
    }
}