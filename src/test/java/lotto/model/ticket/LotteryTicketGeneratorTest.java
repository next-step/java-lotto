package lotto.model.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTicketGeneratorTest {

    @Test
    @DisplayName("선택된 숫자가 6개인지 체크")
    void selectNumberSizeTest(){
        LotteryTicket lotteryTicket = LotteryTicketGenerator.generate();
        assertThat(lotteryTicket.getNumbers().size()).isEqualTo(6);
    }
}