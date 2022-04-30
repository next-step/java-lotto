package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        lottoTickets = new LottoTickets();
    }

    @Test
    void addAndCountTest() {
        int lottoCount = 5;

        for (int i = 0; i < lottoCount; ++i) {
            lottoTickets.add();
        }

        assertThat(lottoTickets.count()).isEqualTo(lottoCount);
    }

    @Test
    void findLottoResultTest() {
        lottoTickets = new LottoTickets(List.of(
            LottoTicket.create(0, 1,2,3,4,5,6),
            LottoTicket.create(0, 1,2,3,4,5,6),
            LottoTicket.create(0, 1,2,3,4,5,6)
        ));

        List<LottoResult> lottoResult = lottoTickets.findLottoResult(List.of(1, 2, 3, 4, 5, 6), 0);

        assertThat(lottoResult).hasSize(3);
    }

}