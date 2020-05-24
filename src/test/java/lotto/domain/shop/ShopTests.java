package lotto.domain.shop;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.shop.exceptions.ExceedTotalLottoTicketsCountInMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ShopTests {
    @DisplayName("낸 돈으로 최대한 살 수 있는 LottoTicket을 판매한다.")
    @Test
    void sellLottoTickets() {
        LottoTickets lottoTickets = Shop.sellLottoTicketsAuto(new Money(10000));
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

    @DisplayName("수동 구매할 LottoTickets의 수는 Money로 구매 가능한 LottoTickets의 수보다 클 수 없다.")
    @Test
    void countAutoLottoTicketsValidationTest() {
        LottoTickets manualLottoTickets = LottoTickets.create(Arrays.asList(
                LottoGenerator.createFromString("1,2,3,4,5,6"),
                LottoGenerator.createFromString("7,8,9,10,11,12")
        ));

        assertThatThrownBy(() -> Shop.countAutoLottoTickets(manualLottoTickets, new Money(1000)))
                .isInstanceOf(ExceedTotalLottoTicketsCountInMoney.class);
    }

    @DisplayName("수동과 자동을 섞어서 LottoTicket을 구매할 수 있다.")
    @Test
    void sellLottoAutoAndManual() {
        LottoTickets manualLottoTickets = LottoTickets.create(Arrays.asList(
                LottoGenerator.createFromString("1,2,3,4,5,6"),
                LottoGenerator.createFromString("7,8,9,10,11,12")
        ));

        LottoTickets boughtLottoTickets = Shop.sellLottoTicketsAutoAndManual(manualLottoTickets, new Money(4000));

        assertThat(boughtLottoTickets.size()).isEqualTo(4);
    }
}
