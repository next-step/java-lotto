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

class StatisticInfoTest {

  @DisplayName("당첨통계는 수익율을 반환한다")
  @ParameterizedTest
  @MethodSource("provideForStatistics")
  void statistics(WinningLottoTicket winningLottoTicket, LottoTickets lottoTickets) {
    StatisticInfo statisticInfo = StatisticInfo.of(winningLottoTicket, lottoTickets,
        Money.createWon(1000));
    assertThat(statisticInfo.rateOfReturn()).isCloseTo(0.35, offset(0.1));
  }

  private static Stream<Arguments> provideForStatistics() {

    WinningLottoTicket winningLottoTicket = WinningLottoTicket.of("1,2,3,4,5,6", "7");
    List<LottoTicket> lottos = List.of(
        LottoTicket.createLottoTicket(List.of(26, 14, 37, 20, 8, 15)),
        LottoTicket.createLottoTicket(List.of(13, 8, 29, 37, 11, 6)),
        LottoTicket.createLottoTicket(List.of(26, 12, 20, 30, 2, 24)),
        LottoTicket.createLottoTicket(List.of(45, 4, 32, 22, 40, 20)),
        LottoTicket.createLottoTicket(List.of(43, 37, 31, 25, 19, 6)),
        LottoTicket.createLottoTicket(List.of(45, 42, 29, 25, 32, 40)),
        LottoTicket.createLottoTicket(List.of(38, 22, 3, 25, 2, 1)),
        LottoTicket.createLottoTicket(List.of(20, 26, 3, 22, 36, 42)),
        LottoTicket.createLottoTicket(List.of(41, 43, 14, 44, 29, 2)),
        LottoTicket.createLottoTicket(List.of(37, 24, 33, 20, 29, 13)),
        LottoTicket.createLottoTicket(List.of(21, 13, 17, 19, 5, 18)),
        LottoTicket.createLottoTicket(List.of(10, 43, 29, 11, 24, 12)),
        LottoTicket.createLottoTicket(List.of(16, 43, 3, 36, 41, 29)),
        LottoTicket.createLottoTicket(List.of(13, 42, 18, 29, 30, 17))
    );
    LottoTickets lottoTickets = new LottoTickets(lottos);
    return Stream.of(
        arguments(winningLottoTicket, lottoTickets)
    );
  }
}