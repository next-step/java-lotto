package lotto;

import lotto.domain.LottoInformation;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoInformationTest {

    @Test
    @DisplayName("[성공] 5개의 로또를 구매하고 6, 5, 4, 3개의 번호가 각각 한번씩 당첨된 경우 수익률을 구한다.")
    void 수익률_4개_당첨() {
        // Given
        LottoTickets lottoTickets = new LottoTickets(List.of(
                new LottoTicket(List.of(1, 2, 42, 43, 44, 45)),
                new LottoTicket(List.of(1, 2, 3, 43, 44, 45)),
                new LottoTicket(List.of(1, 2, 3, 4, 44, 45)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 45)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6))
        ));

        LottoTicket winLottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        LottoStatistics lottoStatistics = new LottoStatistics(lottoTickets, winLottoTicket);
        int purchaseAmount = lottoTickets.size() * 1000;

        // When
        double profit = lottoStatistics.calculateProfitRate(purchaseAmount);

        // Then
        Assertions.assertThat(profit).isEqualTo(400311);
    }

    @Test
    @DisplayName("[성공] 5개의 로또를 구매하고 3개의 번호가 하나 당첨된 경우 수익률을 구한다.")
    void 수익률_3개매칭_1개_당첨() {
        // Given
        LottoTickets lottoTickets = new LottoTickets(List.of(
                new LottoTicket(List.of(1, 2, 42, 43, 44, 45)),
                new LottoTicket(List.of(1, 2, 3, 43, 44, 45)),
                new LottoTicket(List.of(40, 41, 42, 43, 44, 45)),
                new LottoTicket(List.of(40, 41, 42, 43, 44, 45)),
                new LottoTicket(List.of(40, 41, 42, 43, 44, 45))
        ));

        LottoTicket winLottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        LottoStatistics lottoStatistics = new LottoStatistics(lottoTickets, winLottoTicket);
        int purchaseAmount = lottoTickets.size() * 1000;

        // When
        double profit = lottoStatistics.calculateProfitRate(purchaseAmount);

        // Then
        Assertions.assertThat(profit).isEqualTo(1);
    }

}
