package study.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.LottoRank;
import study.lotto.domain.LottoResult;
import study.lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private List<Integer> lottoTicketParam;

    @BeforeEach
    void setUp() {
        lottoTicketParam = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("추가한 로또 결과를 저장할 수 있다.")
    @Test
    void addWinner() {
        LottoResult lottoResult = new LottoResult(1000);
        lottoResult.addWinningTicket(LottoRank.FIRST,
                new LottoTicket(lottoTicketParam));

        assertThat(lottoResult.getWinningTickets(LottoRank.FIRST).size())
                .isEqualTo(1);
        assertThat(lottoResult.getWinningTickets(LottoRank.SECOND).size())
                .isEqualTo(0);
    }

    @DisplayName("수익률을 구할 수 있다.")
    @Test
    void getRateOfReturn() {
        LottoResult lottoResult = new LottoResult(20000);
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(0);

        lottoResult.addWinningTicket(LottoRank.FOURTH,
                new LottoTicket(lottoTicketParam));
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(0.25);

        lottoResult.addWinningTicket(LottoRank.THIRD,
                new LottoTicket(lottoTicketParam));
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(2.75);
    }
}
