package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketTest {

  private LottoTicket sampleTicket;

  @BeforeEach
  void setUp() {
    int[] rawInput = {5, 6, 3, 4, 1, 2};
    List<LottoNumber> numbers = new ArrayList<>();
    for (int number : rawInput) {
      numbers.add(LottoNumber.of(number));
    }

    sampleTicket = LottoTicket.of(numbers);
  }

  @Test
  @DisplayName("스트링 출력")
  void testToString() {
    String expected = "[1, 2, 3, 4, 5, 6]";

    assertThat(this.sampleTicket.toString()).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"1, 7, 8, 9, 10, 11:1", "1, 45, 6, 38, 9, 2:3"}, delimiter = ':')
  @DisplayName("contain 정상 출력 확인")
  void testContain(String input, int expected) {
    assertThat(this.sampleTicket.guessNumHit(WinningNumber.of(input)))
        .isEqualTo(expected);
  }
}
