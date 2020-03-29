package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {
    private Buyer buyer;
    private LottoTicket winningTicket;

    @BeforeEach
    void setUp() {
        buyer = new Buyer();
        winningTicket = createTicket(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @DisplayName("가격에 맞는 개수만큼 로또 티켓 구매 확인")
    @CsvSource(value = {"3500:3", "9800:9", "15920:15"}, delimiter = ':')
    void checkTicketCountByPayMoney(int money, int expectedLottoTicketCount) {
        List<LottoTicket> lottoTickets = buyer.buyLottoTickets(money);
        assertThat(lottoTickets).hasSize(expectedLottoTicketCount);
    }

    @Test
    @DisplayName("2등 1장, 4등 1장일때 result 확인")
    void checkByGetResult() {
        LottoTicket secondTicket = createTicket(1, 2, 3, 4, 5, 16);
        LottoTicket fourthTicket = createTicket(1, 2, 3, 14, 15, 16);

        Buyer newBuyer = new Buyer(Arrays.asList(secondTicket, fourthTicket));
        BuyerResult result = newBuyer.getResult(winningTicket);

        assertThat(result.getWinningResult().size()).isEqualTo(2);
        assertThat(result.getProfitRate()).isEqualTo(752.5);
    }

    private LottoTicket createTicket(int... numbers) {
        return new LottoTicket(Arrays.asList(
                LottoNumber.of(numbers[0]),
                LottoNumber.of(numbers[1]),
                LottoNumber.of(numbers[2]),
                LottoNumber.of(numbers[3]),
                LottoNumber.of(numbers[4]),
                LottoNumber.of(numbers[5])
        ));
    }
}