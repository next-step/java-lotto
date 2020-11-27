package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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
    assertThat(this.sampleTicket.guessNumHit(WinningNumber.of(LottoNumberBundle.of(input))))
        .isEqualTo(expected);
  }

  private static Stream<Arguments> expectedResult() {
    WinningNumber first = makeWinningNumber("1, 2, 3, 4, 5, 6", 9);
    WinningNumber second = makeWinningNumber("1, 8, 6, 4, 3, 2", 5);
    WinningNumber third = makeWinningNumber("1, 3, 4, 5, 6, 7", 8);
    WinningNumber fifth = makeWinningNumber("7, 2, 3, 1, 9, 10", 45);
    WinningNumber miss = makeWinningNumber("7, 3, 8, 9, 10, 11", 45);

    return Stream.of(
        Arguments.of(first, Rank.FIRST),
        Arguments.of(second, Rank.SECOND),
        Arguments.of(third, Rank.THIRD),
        Arguments.of(fifth, Rank.FIFTH),
        Arguments.of(miss, Rank.MISS)
    );
  }

  private static WinningNumber makeWinningNumber(String input, int bonus) {
    WinningNumber temp = WinningNumber.of(LottoNumberBundle.of(input));
    temp.addBonusNumber(LottoNumber.of(bonus));
    return temp;
  }

  @ParameterizedTest
  @MethodSource("expectedResult")
  @DisplayName("티켓 결과 확인")
  void checkMakingCorrectResult(WinningNumber input, Rank expected) {
    assertThat(this.sampleTicket.decideRewardWithBonusBall(input)).isEqualTo(expected);
  }
}
