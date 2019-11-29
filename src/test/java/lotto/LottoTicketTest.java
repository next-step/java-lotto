package lotto;

import lotto.domain.LottoNum;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @DisplayName("3개 번호 일치")
    @Test
    void countMatchNumberTest() {
        LottoTicket lottoTicket = LottoTicket.ofString("1,2,3,6,11,12");
        LottoTicket winningTicket = LottoTicket.ofString("1,2,3,7,8,9");

        assertThat(lottoTicket.countMatchNumber(winningTicket.getLottoNums())).isEqualTo(3);
    }

    @DisplayName("보너스 번호 일치")
    @Test
    void matchBonusNumberTest() {
        LottoTicket lottoTicket = LottoTicket.ofString("1,2,3,6,11,12");

        assertThat(lottoTicket.matchNumber(new LottoNum(6))).isTrue();
    }
}
