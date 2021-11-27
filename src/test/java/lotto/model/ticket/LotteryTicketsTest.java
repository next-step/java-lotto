package lotto.model.ticket;

import lotto.model.domain.PurchaseInfo;
import lotto.model.ticket.generator.AutoTicketGenerator;
import lotto.model.ticket.generator.ManualTicketGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTicketsTest {

    LotteryTickets lotteryTickets;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("파라미터로 받은 count 와 생성된 복권 티켓 수가 일치하는지 테스트")
    void createdLotteryTicketSizeCheckTest(int count){
        PurchaseInfo purchaseInfo = new PurchaseInfo(count * 1000,0);
        lotteryTickets = new LotteryTickets(purchaseInfo,new AutoTicketGenerator(), new ManualTicketGenerator());
        assertThat(lotteryTickets.getTickets().size()).isEqualTo(count);
    }

    @Test
    @DisplayName("자동생성으로 생성된 로또 숫자가 6개인지 체크")
    void selectNumberSizeTest(){
        PurchaseInfo purchaseInfo = new PurchaseInfo(1000,0);
        lotteryTickets = new LotteryTickets(purchaseInfo, new AutoTicketGenerator(), new ManualTicketGenerator());
        assertThat(lotteryTickets.getTickets().get(0).getNumbers().size()).isEqualTo(6);
    }
}