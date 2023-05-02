package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {


  @Test
  void 당첨번호가_1번보다_작은경우_실패_테스트() {
    List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5);
    WinningNumbers winningNumbers = new WinningNumbers(numbers);

    assertThat(winningNumbers.isBetweenOneAndFortyFive()).isFalse();
  }

  @Test
  void 당첨번호가_45번보다_큰경우_실패_테스트() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
    WinningNumbers winningNumbers = new WinningNumbers(numbers);

    assertThat(winningNumbers.isBetweenOneAndFortyFive()).isFalse();
  }
}