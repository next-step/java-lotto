package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LottoTicketsTest {

  @DisplayName("로또 객체 생성 시 null 또는 빈 값은 예외를 던진다")
  @ParameterizedTest
  @NullAndEmptySource
  void lottoTickets(List<LottoTicket> lottoTickets) {
    assertThatIllegalArgumentException().isThrownBy(() -> new LottoTickets(lottoTickets))
        .withMessageMatching("로또 그룹은 빈 값일 수 없습니다.");
  }

  @DisplayName("로또 그룹의 size()는 로또 티켓 개수를 반환한다")
  @ParameterizedTest
  @MethodSource("provideSize")
  void size(LottoTickets lottoTickets, int expected) {
    assertThat(lottoTickets.randomLottoCount()).isEqualTo(expected);
  }

  private static Stream<Arguments> provideSize() {
    LottoTicket ticketA = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    LottoTicket ticketB = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    LottoTicket ticketC = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));

    return Stream.of(
        arguments(new LottoTickets(List.of(ticketA, ticketB, ticketC)), 3),
        arguments(new LottoTickets(List.of(ticketA, ticketB)), 2),
        arguments(new LottoTickets(List.of(ticketA)), 1)
    );
  }

  @DisplayName("tickets 는 로또 묶음을 반환한다.")
  @ParameterizedTest
  @MethodSource("provideForTickets")
  void tickets(LottoTickets lottoTickets) {
    assertThatNoException().isThrownBy(lottoTickets::tickets);
  }

  @DisplayName("읽기전용 로또 묶음을 수정 시 예외를 던진다")
  @ParameterizedTest
  @MethodSource("provideForTickets")
  void ticketsThrowsException(LottoTickets lottoTickets) {
    List<LottoTicket> unmodifiableTickets = lottoTickets.tickets();
    assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(
        () -> unmodifiableTickets.remove(0));
  }

  private static Stream<Arguments> provideForTickets() {
    LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    return Stream.of(
        arguments(new LottoTickets(List.of(lottoTicket)))
    );
  }

  @DisplayName("로또 묶음에서 당첨금 별 로또 일치 갯수를 반환한다")
  @ParameterizedTest
  @MethodSource("provideForGetMatchedCountPerPrize")
  void getMatchedCountPerPrize(LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket,
      Prize prize, int matchCount) {
    assertThat(lottoTickets.getMatchedCountPerPrize(prize, winningLottoTicket)).isEqualTo(
        matchCount);
  }

  private static Stream<Arguments> provideForGetMatchedCountPerPrize() {
    WinningLottoTicket winningLottoTicket = WinningLottoTicket.of("1,2,3,4,5,6", "7");
    LottoTicket firstPrizeTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    LottoTicket secondPrizeTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));
    LottoTicket thirdPrizeTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 8));
    LottoTicket fourthPrizeTicket = new LottoTicket(List.of(1, 2, 3, 4, 8, 9));
    LottoTicket fifthPrizeTicket = new LottoTicket(List.of(1, 2, 3, 8, 9, 10));
    LottoTicket nonePrizeTicket = new LottoTicket(List.of(8, 9, 10, 11, 12, 13));

    return Stream.of(
        arguments(new LottoTickets(
                List.of(firstPrizeTicket, nonePrizeTicket, nonePrizeTicket, nonePrizeTicket)),
            winningLottoTicket, Prize.FIRST, 1),
        arguments(new LottoTickets(
            List.of(secondPrizeTicket, secondPrizeTicket, nonePrizeTicket, nonePrizeTicket,
                nonePrizeTicket)), winningLottoTicket, Prize.SECOND, 2),
        arguments(new LottoTickets(
            List.of(thirdPrizeTicket, thirdPrizeTicket, thirdPrizeTicket, nonePrizeTicket,
                nonePrizeTicket)), winningLottoTicket, Prize.THIRD, 3),
        arguments(new LottoTickets(
            List.of(fourthPrizeTicket, fourthPrizeTicket, fourthPrizeTicket, fourthPrizeTicket,
                nonePrizeTicket)), winningLottoTicket, Prize.FOURTH, 4),
        arguments(new LottoTickets(
            List.of(fifthPrizeTicket, fifthPrizeTicket, fifthPrizeTicket, fifthPrizeTicket,
                fifthPrizeTicket)), winningLottoTicket, Prize.FIFTH, 5)
    );
  }
}