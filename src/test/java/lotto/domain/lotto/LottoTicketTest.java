package lotto.domain.lotto;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketTest {

  private List<LottoNumber> winning;

  @BeforeEach
  void setUp() {
    winning = List.of(
        LottoNumber.of(1), LottoNumber.of(2),
        LottoNumber.of(3), LottoNumber.of(4),
        LottoNumber.of(5), LottoNumber.of(6));
  }

  @Test
  void lottoTicketNotHas6LottoNumbersThrowsException() {
    assertThatThrownBy(() ->
        new LottoTicket(List.of(1))).isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() ->
        new LottoTicket(List.of(1, 2, 3, 4, 5))
    ).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource({
      "0, 7, 8, 9, 10, 11, 12",
      "3, 1, 2, 3, 7, 8, 9",
      "4, 1, 2, 3, 4, 7, 8",
      "5, 1, 2, 3, 4, 5, 7",
      "6, 1, 2, 3, 4, 5, 6"
  })
  void countMatchingNumbers_rank(int expectedMatches, int n1, int n2, int n3, int n4, int n5,
      int n6) {
    LottoTicket ticket = new LottoTicket(List.of(n1, n2, n3, n4, n5, n6));
    assertThat(ticket.countMatchingNumbers(winning)).isEqualTo(expectedMatches);
  }

  @ParameterizedTest
  @CsvSource({
      "5, 5, 4, 3, 2, 1, 7",
      "5, 1, 7, 2, 3, 4, 5"
  })
  void countMatchingNumbers_order(int expectedMatches, int n1, int n2, int n3, int n4, int n5,
      int n6) {
    LottoTicket ticket = new LottoTicket(List.of(n1, n2, n3, n4, n5, n6));
    assertThat(ticket.countMatchingNumbers(winning)).isEqualTo(expectedMatches);
  }
}