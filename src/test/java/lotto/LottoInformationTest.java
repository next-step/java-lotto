package lotto;

import lotto.domain.LottoInformation;
import lotto.domain.LottoStatisticsMap;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoInformationTest {

    @Test
    @DisplayName("[성공] 로또 통계 정보를 기반으로 수익률을 구한다.")
    void 수익률() {
        // Given
        LottoTickets lottoTickets = new LottoTickets(List.of(
                new LottoTicket(List.of(1, 2, 42, 43, 44, 45)),
                new LottoTicket(List.of(1, 2, 3, 43, 44, 45)),
                new LottoTicket(List.of(1, 2, 3, 4, 44, 45)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 45)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6))
        ));

        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoStatisticsMap lottoStatistics = new LottoStatisticsMap(lottoTickets, winNumbers);
        int purchaseAmount = lottoTickets.size() * 1000;

        // When
        double profit = LottoInformation.calculateProfitRate(lottoStatistics, purchaseAmount);

        // Then
        Assertions.assertThat(profit).isEqualTo(400311);
    }

}
