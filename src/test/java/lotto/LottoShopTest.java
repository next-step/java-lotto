package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.LottoWallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {

    @DisplayName("원하는 개수만큼의 임시 로또 티켓을 배정한다.")
    @Test
    void createLottoTicketAsYouWant() {
        int money = 1000;
        List<Lotto> assignedLottoList = LottoShop.from(money).assignedLottoList();
        assertThat(assignedLottoList.size()).isEqualTo(1);
    }

    @DisplayName("배정된 티켓을 확정구매한다.")
    @Test
    void purchaseTicketThatAssigned(){
        LottoWallet lottoWallet = LottoShop.from(10000).purchase();
        assertThat(lottoWallet.totalTicketCount()).isEqualTo(10);
    }

}
