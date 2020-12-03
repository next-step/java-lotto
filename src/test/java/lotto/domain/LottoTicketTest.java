package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("로또 티켓 구매 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2000", "15000", "5000"}, delimiter = ':')
    public void purchaseLottoTest(int purchasePrice) {

        //Given
        int lottoPrice = 1_000;
        LottoShop shop = new LottoShop();

        //When
        LottoTicket lottoTicket = shop.purchaseLottoTicket(Money.from(purchasePrice));

        //Then
        assertThat(lottoTicket).isNotNull();
        assertThat(lottoTicket).isEqualTo(new LottoTicket(purchasePrice / lottoPrice));

    }

}
