package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

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

}