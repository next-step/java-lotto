package lotto.domain.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketsTest {

  LottoTickets lottoTickets;

  @BeforeEach
  void setUp() {
    LottoTicket ticket1 = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(15), new LottoNumber(40),
            new LottoNumber(25), new LottoNumber(22), new LottoNumber(4)));

    LottoTicket ticket2 = new LottoTicket(Arrays.asList(new LottoNumber(15), new LottoNumber(40), new LottoNumber(26),
            new LottoNumber(5), new LottoNumber(10),  new LottoNumber(32)));

    lottoTickets = new LottoTickets(Arrays.asList(ticket1, ticket2));
  }

  @ParameterizedTest
  @MethodSource("makeWinningTicket")
  @DisplayName("n개의 번호가 맞는 로또 티켓의 수를 반환한다.")
  void getCountOfMatch(LottoTicket winning, int matchedCount, int result) {
    assertEquals(result, lottoTickets.getCountOfMatch(winning, matchedCount));
  }

  private static Stream<Arguments> makeWinningTicket() {
    return Stream.of(
            Arguments.of(new LottoTicket(Arrays.asList(new LottoNumber(3), new LottoNumber(20), new LottoNumber(40),
                    new LottoNumber(28), new LottoNumber(15), new LottoNumber(9))), 2, 2),
            Arguments.of(new LottoTicket(Arrays.asList(new LottoNumber(5), new LottoNumber(9), new LottoNumber(15),
                    new LottoNumber(40), new LottoNumber(27), new LottoNumber(12))),3, 1));

  }

}