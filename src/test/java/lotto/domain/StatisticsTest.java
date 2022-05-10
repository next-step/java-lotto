package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StatisticsTest {

  @DisplayName("당첨통계는 수익율을 반환한다")
  @ParameterizedTest
  @MethodSource("provideForStatistics")
  void statistics(WinningLottoTicket winningLottoTicket, LottoTickets lottoTickets) {
    Statistics statistics = new Statistics(winningLottoTicket, lottoTickets, Money.createWon(1000));
    assertThat(statistics.rateOfReturn()).isCloseTo(0.35, offset(0.1));
  }

  private static Stream<Arguments> provideForStatistics() {

    WinningLottoTicket winningLottoTicket = new WinningLottoTicket("1,2,3,4,5,6");
    List<LottoTicket> lottos = List.of(
        new LottoTicket(List.of(26, 14, 37, 20, 8, 15)),
        new LottoTicket(List.of(13, 8, 29, 37, 11, 6)),
        new LottoTicket(List.of(26, 12, 20, 30, 2, 24)),
        new LottoTicket(List.of(45, 4, 32, 22, 40, 20)),
        new LottoTicket(List.of(43, 37, 31, 25, 19, 6)),
        new LottoTicket(List.of(45, 42, 29, 25, 32, 40)),
        new LottoTicket(List.of(38, 22, 3, 25, 2, 1)),
        new LottoTicket(List.of(20, 26, 3, 22, 36, 42)),
        new LottoTicket(List.of(41, 43, 14, 44, 29, 2)),
        new LottoTicket(List.of(37, 24, 33, 20, 29, 13)),
        new LottoTicket(List.of(21, 13, 17, 19, 5, 18)),
        new LottoTicket(List.of(10, 43, 29, 11, 24, 12)),
        new LottoTicket(List.of(16, 43, 3, 36, 41, 29)),
        new LottoTicket(List.of(13, 42, 18, 29, 30, 17))
    );
    LottoTickets lottoTickets = new LottoTickets(lottos);
    return Stream.of(
        arguments(winningLottoTicket, lottoTickets)
    );
  }
}