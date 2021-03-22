package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

  private static Stream<Arguments> winner() {
    Lotto case1
        = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto case2
        = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
    Lotto case3
        = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 7));

    return Stream.of(
        Arguments.of(case1, LottoResult.FIRST),
        Arguments.of(case2, LottoResult.SECOND),
        Arguments.of(case3, LottoResult.THIRD)
    );
  }

  @ParameterizedTest
  @MethodSource("winner")
  @DisplayName("로또 결과를 확인한다.")
  void checkLotto(Lotto winner, LottoResult expected) {
    //given
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = LottoMachine.generateManual(numbers);
    //when
    lotto.checkResult(winner);
    //then
    assertEquals(lotto.getResult(), expected);
  }
}