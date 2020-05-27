package lotto.domain.shop;

import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    @Test
    void buyLottoTicketTest_1개_구입() {
        int money = 1000;
        LottoPurchaseMoney input = LottoPurchaseMoney.input(money);
        LottoShop lottoShop = new LottoShop();
        List<LottoTicket> lottoTicketList = lottoShop.publishLottoTickets(input);
        assertThat(lottoTicketList.size()).isEqualTo(1);
    }

    @Test
    void buyLottoTicketTest_여러개_구입() {
        int money = 14000;
        LottoPurchaseMoney input = LottoPurchaseMoney.input(money);
        LottoShop lottoShop = new LottoShop();
        List<LottoTicket> lottoTicketList = lottoShop.publishLottoTickets(input);
        assertThat(lottoTicketList.size()).isEqualTo(14);
    }
}
