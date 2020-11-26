package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketTest {

  private LottoTicket sampleTicket;

  @BeforeEach
  void setUp() {
    sampleTicket = LottoTicket.of(LottoNumberBundle.of("1, 2, 3, 4, 5, 6"));
  }

  @Test
  @DisplayName("스트링 출력")
  void testToString() {
    String expected = "[1, 2, 3, 4, 5, 6]";

    assertThat(this.sampleTicket.toString())
        .isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"1, 7, 8, 9, 10, 11:1", "1, 45, 6, 38, 9, 2:3"}, delimiter = ':')
  @DisplayName("contain 정상 출력 확인")
  void testContain(String input, int expected) {
    assertThat(this.sampleTicket.guessNumHit(WinningNumber.of(input)))
        .isEqualTo(expected);
  }
}
