package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class OrderedLottoGameNumbersTest {

  @DisplayName("객체 생성 & 동등성 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "10, 9, 45, 7, 34, 20"})
  void constructionAndEqualityTest(String given) {
    //given
    List<Integer> givenNumbers = Arrays.stream(given.split(", "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    //when & then
    assertThat(new OrderedLottoGameNumbers(givenNumbers)).isEqualTo(new OrderedLottoGameNumbers(givenNumbers));
  }

  @DisplayName("toString 값 테스트")
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
