package lotto.domain.shop;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTests {
    @DisplayName("낸 돈으로 최대한 살 수 있는 LottoTicket을 판매한다.")
    @Test
    void sellLottoTickets() {
        LottoTickets lottoTickets = Shop.sellLottoTickets(new Money(10000));
        assertThat(lottoTickets.size()).isEqualTo(10);
    }

    @DisplayName("제시된 돈과 수동 구매할 LottoTickets의 수를 계산해서 자동 구매할 LottoTickets의 수를 계산할 수 있다.")
    @Test
    void countAutoLottoTicketsTest() {
        LottoTickets manualLottoTickets = LottoTickets.create(Arrays.asList(
                LottoGenerator.createFromString("1,2,3,4,5,6"),
                LottoGenerator.createFromString("7,8,9,10,11,12")
        ));

        int autoLottoTicketNumber = Shop.countAutoLottoTickets(manualLottoTickets, new Money(3000));
        assertThat(autoLottoTicketNumber).isEqualTo(1);
    }
}
