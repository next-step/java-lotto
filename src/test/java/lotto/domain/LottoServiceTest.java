package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @Test
    @DisplayName("당첨을 확인한다.")
    void findWinner() {
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(2,3,4,5,6,7)),
                new Lotto(Arrays.asList(3,4,5,6,7,8)),
                new Lotto(Arrays.asList(4,5,6,7,8,9)),
                new Lotto(Arrays.asList(5,6,7,8,9,10)));

        Lotto winnerLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        Map<Integer, Integer> winnerStat = lottoService.findWinnerStats(lottos, winnerLotto);

        assertThat(winnerStat).hasSize(4);
        assertThat(winnerStat.get(3)).isEqualTo(1);
        assertThat(winnerStat.get(4)).isEqualTo(1);
        assertThat(winnerStat.get(5)).isEqualTo(1);
        assertThat(winnerStat.get(6)).isEqualTo(1);
    }
}
