package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    @ParameterizedTest
    @CsvSource(value = {"3:3000", "4:4000", "5:5000", "6:6000", "7:7000"}, delimiter = ':')
    public void exchangeAutoLottosTest(int quantity, int purchasePrice) {
        //Given
        LottoShop shop = new LottoShop();
        shop.purchaseLottoTicket(Money.from(purchasePrice));

        //When
        shop.exchangeManualLottos(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        shop.exchangeAutoLottos(new LottoAutoMachine());

        //Then
        assertThat(shop.remainTicketCount()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1000", "2:2000", "3:3000", "4:4000", "5:5000", "6:6000", "7:7000"}, delimiter = ':')
    public void exchangeManualLottosTest(int quantity, int purchasePrice) {
        ///Given
        LottoShop shop = new LottoShop();
        LottoTicket ticket = shop.purchaseLottoTicket(Money.from(purchasePrice));

        //When
        shop.exchangeManualLottos(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //Then
        assertThat(ticket.getRemainCount()).isEqualTo(quantity - 1);
    }
}