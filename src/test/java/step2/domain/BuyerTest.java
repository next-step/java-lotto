package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuyerTest {

    @DisplayName("구매자 생성.")
    @Test
    void createBuyerTest(){
        int money = 10000;
        Buyer buyer = Buyer.from(money);

        assertThat(buyer.getMoney()).isEqualTo(money);
    }

    @DisplayName("구매자가 소유한 금액으로 살수있는 최대한의 로또를 산다.")
    @Test
    void buyLottoTest(){
        int money = 10000;

        Buyer buyer = Buyer.from(money);

        assertThat(buyer.getLottoCounts()).isEqualTo(10);
    }
}