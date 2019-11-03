package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "20000:20", "5500:5"}, delimiter = ':')
    @DisplayName("금액 입력받아 몇개 구매하는지 리턴한다.")
    void buyTicket(int amount, int result) {

        LottoService lottoService = new LottoService();

        assertThat(lottoService.buyTicket(amount)).isEqualTo(result);
    }

    @Test
    @DisplayName("구매 개수만큼 로또티켓들을 생성한다.")
    void createLottoTickets() {
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.createLottoTickets(5);

        assertThat(lottos).hasSize(5);
    }
}
