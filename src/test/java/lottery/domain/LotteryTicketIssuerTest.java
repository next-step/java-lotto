package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryTicketIssuerTest {

    @Test
    @DisplayName("로또 한 장에 천 원에 판매한다.")
    void sellLottery() {
        LotteryTicketIssuer issuer = new LotteryTicketIssuer();
        int money = 5000;

        assertThat(issuer.issue(money).size()).isEqaulTo(5);
    }
}
