package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTicketsTest {

    LotteryTickets lotteryTickets;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("파라미터로 받은 count 와 생성된 복권 티켓 수가 일치하는지 테스트")
    void createdLotteryTicketSizeCheckTest(int count){
        lotteryTickets = new LotteryTickets(count);
        assertThat(lotteryTickets.getTickets().size()).isEqualTo(count);
    }
}