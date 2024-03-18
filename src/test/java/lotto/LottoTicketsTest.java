package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Nested
    @DisplayName("로또 당첨 통계 구하기")
    class LottoStatistics {

        @ParameterizedTest(name = "[{index}] {0}개 일치 - {1}개")
        @CsvSource(value = {"3:1", "4:1", "5:1"}, delimiter = ':')
        @DisplayName("[성공] 3개 당첨 1개, 4개 당첨 1개, 5개 당첨 1개에 대한 통계를 구한다.")
        void 당첨_통계_1(int hit, int count) {
            // Given
            LottoTickets lottoTickets = new LottoTickets(List.of(
                    new LottoTicket(List.of(1, 2, 42, 43, 44, 45)),
                    new LottoTicket(List.of(1, 2, 3, 43, 44, 45)),
                    new LottoTicket(List.of(1, 2, 3, 4, 44, 45)),
                    new LottoTicket(List.of(1, 2, 3, 4, 5, 45)),
                    new LottoTicket(List.of(1, 2, 3, 4, 5, 6))
            ));

            // When
            List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
            Map<Integer, Integer> lottoStatistics = lottoTickets.getLottoStatistics(winNumbers);

            // Then
            assertThat(lottoStatistics.get(hit)).isEqualTo(count);
        }

        @ParameterizedTest(name = "[{index}] {0}개 일치 - {1}개")
        @CsvSource(value = {"3:3", "4:2", "6:1"}, delimiter = ':')
        @DisplayName("[성공] 3개 당첨 3개, 4개 당첨 2개, 6개 당첨 1개에 대한 통계를 구한다.")
        void 당첨_통계_2(int hit, int count) {
            // Given
            LottoTickets lottoTickets = new LottoTickets(List.of(
                    new LottoTicket(List.of(1, 2, 3, 43, 44, 45)),
                    new LottoTicket(List.of(1, 2, 3, 43, 44, 45)),
                    new LottoTicket(List.of(1, 2, 3, 43, 44, 45)),
                    new LottoTicket(List.of(1, 2, 3, 4, 44, 45)),
                    new LottoTicket(List.of(1, 2, 3, 4, 44, 45)),
                    new LottoTicket(List.of(1, 2, 3, 4, 5, 6))
            ));

            // When
            List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
            Map<Integer, Integer> lottoStatistics = lottoTickets.getLottoStatistics(winNumbers);

            // Then
            assertThat(lottoStatistics.get(hit)).isEqualTo(count);
        }

    }

}
