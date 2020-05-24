package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {

    @Test
    void buyLottoTicketTest_1개_구입() {
        int money = 1000;
        LottoShop lottoShop = LottoShop.putMoney(money);
        List<LottoTicket> lottoTicketList = lottoShop.buyLottoTickets();
        assertThat(lottoTicketList.size()).isEqualTo(1);
    }

    @Test
    void buyLottoTicketTest_여러개_구입() {
        int money = 14000;
        LottoShop lottoShop = LottoShop.putMoney(money);
        List<LottoTicket> lottoTicketList = lottoShop.buyLottoTickets();
        assertThat(lottoTicketList.size()).isEqualTo(14);
    }

    @Test
    void buyLottoTicketTest_0개_구입_에러() {
        int money = 0;
        assertThatThrownBy(() ->  LottoShop.putMoney(money))
                .hasMessageMatching("0원 이하는 로또를 살 수 없습니다.");
    }

    @Test
    void buyLottoTicketTest_돈마이너스값_에러() {
        int money = -1000;
        assertThatThrownBy(() ->  LottoShop.putMoney(money))
                .hasMessageMatching("0원 이하는 로또를 살 수 없습니다.");
    }
}
