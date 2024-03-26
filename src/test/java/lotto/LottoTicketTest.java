package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.WinningCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    private LottoTicket lottoTicket;

    @BeforeEach
    void setup() {
        lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("금액별 로또 생성 갯수 테스트")
    void lotto_생성_개수(){
        assertThat(LottoMachine.getTicketsCount(14000)).isEqualTo(14);
    }

    @Test
    @DisplayName("WinningCount를 통한 로또 번호 3개 당첨 테스트")
    void WinningCount_3개_당첨() {
        assertThat(WinningCount.compareNumbers(Arrays.asList(1,2,3,4,5,6), Arrays.asList(4,5,6,7,8,9))).isEqualTo(3);
    }

    @Test
    @DisplayName("lottoTicket을 통한 로또 번호 4개 당첨 테스트")
    void lotto_4개_당첨() {
        assertThat(lottoTicket.winningCount(Arrays.asList(3,4,5,6,7,8))).isEqualTo(3);
    }


}
