package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersTest {

  @Test
  void 당첨_번호_개수가_6개가_아니면_예외가_발생한다() {
    assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)));
  }

  @ParameterizedTest
  @CsvSource(value = {
      "1,2,3,4,5,6:6",
      "1,3,4,10,14,20:3",
      "7,8,9,10,11,12:0"
  }, delimiter = ':')
  @DisplayName("구매한 로또의 당첨 번호 갯수 비교")
  void winningNumbersTest(String given, int expected) {

    List<Integer> numbers = Arrays.stream(given.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    assertThat(new Lotto(numbers).findMatchNumberCount(winningNumbers)).isEqualTo(expected);
  }


  @ParameterizedTest
  @CsvSource(value = {
      "0:0",
      "3:5000",
      "4:50000",
      "5:150000",
      "6:2000000000"
  }, delimiter = ':')
  @DisplayName("당청된 숫자 개수에 따른 당청 금액 리턴")
  void winningNumbersTest2(int given, int expected) {
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    int amount = lotto.getWinningPrice(given);
    assertThat(amount).isEqualTo(expected);
  }
}
