package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketSellerTest {

    @Test
    void 부족한_구입금액_입력테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoTicketSeller.purchaseRandomGames(100);
        }).withMessage("로또 구입 금액이 부족합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "3000:3", "4000:4", "5000:5"}, delimiter = ':')
    void 정상금액_구입테스트(int money, int ticketNumber) {
        LottoTickets purchasedTickets = LottoTicketSeller.purchaseRandomGames(money);
        assertThat(purchasedTickets.size()).isEqualTo(ticketNumber);
    }
}