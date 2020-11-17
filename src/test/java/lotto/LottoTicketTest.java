package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  @DisplayName("중복된 숫자에 대한 예외 처리")
  void testDuplicatedCase() {
    int[] rawInput = {5, 6, 4, 4, 1, 2};
    List<LottoNumber> numbers = new ArrayList<>();
    for (int number : rawInput) {
      numbers.add(LottoNumber.of(number));
    }

    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
        () -> LottoTicket.of(numbers)
    );
  }

  @Test
  @DisplayName("스트링 출력")
  void testToString() {
    int[] rawInput = {5, 6, 3, 4, 1, 2};
    List<LottoNumber> numbers = new ArrayList<>();
    for (int number : rawInput) {
      numbers.add(LottoNumber.of(number));
    }

    LottoTicket input = LottoTicket.of(numbers);
    String expected = "[1, 2, 3, 4, 5, 6]";

    assertThat(input.toString()).isEqualTo(expected);
  }
}
