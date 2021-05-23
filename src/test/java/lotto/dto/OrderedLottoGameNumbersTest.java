package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class OrderedLottoGameNumbersTest {

  @DisplayName("로또게임의 번호를 출력한다.")
  @ParameterizedTest
  @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "10, 9, 45, 7, 34, 20"})
  void toStringTest(String given) {
    //given
    List<Integer> givenNumbers = Arrays.stream(given.split(", "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    //when & then
    assertThat(new OrderedLottoGameNumbers(givenNumbers).toString()).hasToString(given);
  }
}
