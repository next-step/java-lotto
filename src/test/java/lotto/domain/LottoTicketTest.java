package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    private static final int LOTTO_PRICE = 1_000;

    @DisplayName("로또 티켓 구매 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2_000, 15_000, 5_000})
    public void purchaseLottoTest(int purchasePrice) {

        //Given
        LottoShop shop = new LottoShop();

        //When
        LottoTicket lottoTicket = shop.purchaseLottoTicket(Money.from(purchasePrice));

        //Then
        assertThat(lottoTicket).isNotNull();
        assertThat(lottoTicket).isEqualTo(new LottoTicket(purchasePrice / LOTTO_PRICE));

    }

    @DisplayName("로또 잔여 수량 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2000:1", "15000:5", "5000:2", "10000:7"}, delimiter = ':')
    public void remainLottoTicketTest(int purchasePrice, int manualSpendCount) {
        //Given
        int expectedRemainCount = (purchasePrice / 1_000)  - manualSpendCount;
        LottoTicket lottoTicket = new LottoTicket(purchasePrice / LOTTO_PRICE);

        //When
        IntStream.range(0, manualSpendCount)
                .forEach(i -> lottoTicket.spend());

        //Then
        assertThat(lottoTicket.getRemainCount()).isEqualTo(expectedRemainCount);
    }
}
