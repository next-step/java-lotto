package lotto.common;

import lotto.domain.LottoNumber;
import lotto.domain.LottoPackage;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketMachineTest {
    @DisplayName("입력한 숫자만큼 로또 티켓 자동 발행")
    @Test
    void issueTickets() {
        int money = 3_000;
        int ticketPrice = 1_000;
        //when
        LottoPackage lottoTickets = LottoTicketMachine.issueTickets(money);

        //then
        assertEquals(money / ticketPrice, lottoTickets.getTicketCount());
    }

    @DisplayName("티켓발행 실패 - 금액부족")
    @Test
    void newInstance() {
        //given
        int money = 999;

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicketMachine.issueTickets(money))
                .withMessage("구입금액이 부족합니다.");
    }

    @DisplayName("입력받은 문자열로 LottoTicket 생성")
    @Test
    void issueTicket() {
        //given
        String numberValues = "1, 2, 3, 4, 5, 6";

        //when
        LottoTicket actual = LottoTicketMachine.issueTicket(numberValues);

        //then
        Set<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
        LottoTicket expected = new LottoTicket(lottoNumbers);
        assertEquals(expected, actual);
    }
}