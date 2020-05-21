package lotto.application;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.rank.Ranks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTests {
    private LottoService lottoService;

    @BeforeEach
    public void setup() {
        lottoService = new LottoService();
    }

    @DisplayName("돈을 입력받아서 자동으로 로또를 구매한 뒤 LottoTickets를 반환")
    @Test
    void buyLottoTest() {
        LottoTickets lottoTickets = lottoService.buyLottoTickets(10000);
        assertThat(lottoTickets.size()).isEqualTo(10);
    }

    @DisplayName("당첨 티켓 번호와 구매한 LottoTickets를 받아서 당첨 결과를 반환할 수 있다.")
    @Test
    void rankCalculateTest() {
        List<Integer> winTicketNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTickets lottoTickets = LottoTickets.create(
                Arrays.asList(LottoGenerator.create(), LottoGenerator.create()));

        assertThat(lottoService.calculateRank(winTicketNumbers, lottoTickets)).isInstanceOf(Ranks.class);
    }
}
