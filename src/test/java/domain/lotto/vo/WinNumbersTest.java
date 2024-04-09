package domain.lotto.vo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinNumbersTest {

  WinNumbers winNumbers;

  @BeforeEach
  void setUp() {
    winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 10);
  }


  @Test
  @DisplayName("당첨 번호가 겹치는 것이 없는지 확인한다")
  void doesntMatchCount() {
    Set<LottoNumber> numbers = Stream.of(11, 12, 13, 14,15, 16).map(LottoNumber::of).collect(
        Collectors.toSet());
    assertThat(winNumbers.getMatchCount(numbers)).isEqualTo(0);
  }

  @Test
  @DisplayName("보너스 당첨 번호가 있으면 카운팅하는지 확인한다")
  void matchCountWithbonus() {
    Set<LottoNumber> numbers = Stream.of(10, 12, 13, 14,15, 16).map(LottoNumber::of).collect(
        Collectors.toSet());
    assertThat(winNumbers.getMatchCount(numbers)).isEqualTo(1);
  }

  @Test
  @DisplayName("당첨 번호가 3개 겹치는지 확인한다")
  void matchCount() {
    Set<LottoNumber> numbers = Stream.of(1, 2, 3, 7, 8, 9).map(LottoNumber::of).collect(
        Collectors.toSet());
    assertThat(winNumbers.getMatchCount(numbers)).isEqualTo(3);
  }
}
