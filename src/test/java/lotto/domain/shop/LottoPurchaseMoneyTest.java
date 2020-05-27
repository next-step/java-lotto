package lotto.domain.shop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseMoneyTest {

    @Test
    void buyLottoTicketTest_0개_구입_에러() {
        int money = 0;
        assertThatThrownBy(() ->  LottoPurchaseMoney.input(money))
                .hasMessageMatching("0원 이하는 로또를 살 수 없습니다.");
    }

    @Test
    void buyLottoTicketTest_돈마이너스값_에러() {
        int money = -1000;
        assertThatThrownBy(() ->  LottoPurchaseMoney.input(money))
                .hasMessageMatching("0원 이하는 로또를 살 수 없습니다.");
    }

    @Test
    void buyLottoTicketTest_거스름돈존재하지않음_에러() {
        int money = 100;
        assertThatThrownBy(() ->  LottoPurchaseMoney.input(money))
                .hasMessageMatching("이 구매기는 거스름돈이 없습니다. 1000원 단위로 입력하세요");
    }

    @Test
    void ticketCountTest() {
        int money = 15000;
        int lottoCount = 15;
        LottoPurchaseMoney input = LottoPurchaseMoney.input(money);
        int lottoTicketCount = input.getLottoTicketCount();
        assertThat(lottoTicketCount).isEqualTo(lottoCount);
    }

}
