package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("로또티켓 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:1", "10:5", "5:2", "8:7"}, delimiter = ':')
    public void createInstanceTest(int totalQuantity, int manualQuantity) {
        //Given & When
        LottoTicket ticket = LottoTicket.of(totalQuantity, manualQuantity);

        //Then
        assertThat(ticket).isEqualTo(LottoTicket.of(totalQuantity, manualQuantity));
    }

    @DisplayName("로또 티켓 생성 후 수량확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:1", "10:5", "5:2", "8:7"}, delimiter = ':')
    public void ticketCountTest(int totalQuantity, int manualQuantity) {
        //Given & When
        LottoTicket ticket = LottoTicket.of(totalQuantity, manualQuantity);

        //Then
        assertThat(ticket.getManualQuantity()).isEqualTo(manualQuantity);
        assertThat(ticket.getAutoQuantity()).isEqualTo(totalQuantity - manualQuantity);
    }

}
