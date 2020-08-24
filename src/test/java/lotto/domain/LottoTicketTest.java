package lotto.domain;

import lotto.util.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓 숫자가 6개인지 테스트")
    void lotto_ticket_count() {
        LottoMachine.getInstance();
        assertThatCode(() -> LottoTicket.valueOf(LottoMachine.generateLottoNumber()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("두 로또 번호를 비교해 맞은 개수 반환 테스트")
    void count_match_numbers() {
        LottoTicket winningLotto = LottoTicket.valueOf(LottoMachine.createManualLottoNumbers(StringSplitter.splitText("1,2,3,4,5,6")));
        LottoTicket compareLotto = LottoTicket.valueOf(LottoMachine.createManualLottoNumbers(StringSplitter.splitText("1,2,3,4,44,45")));
        assertEquals(4, winningLotto.countMatchNumbers(compareLotto));
    }
}
