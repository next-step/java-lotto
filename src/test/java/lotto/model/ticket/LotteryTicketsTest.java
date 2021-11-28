package lotto.model.ticket;

import lotto.model.domain.CountInfo;
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
        CountInfo countInfo = new CountInfo(0, count);
        lotteryTickets = new LotteryTickets(countInfo);
        assertThat(lotteryTickets.getTickets().size()).isEqualTo(count);
    }

    @Test
    @DisplayName("자동생성으로 생성된 로또 숫자가 6개인지 체크")
    void selectNumberSizeTest(){
        CountInfo countInfo = new CountInfo(0,10);
        lotteryTickets = new LotteryTickets(countInfo);
        assertThat(lotteryTickets.getTickets().get(0).getNumbers().size()).isEqualTo(6);
    }
}