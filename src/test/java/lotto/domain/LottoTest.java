package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

  private LottoMachine lottoMachine = new LottoMachine();

  private static Stream<Arguments> winner() {
    Lotto case1
        = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto case2
        = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
    Lotto case3
        = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 7));

    LottoNumber bonusNumber = new LottoNumber(7);

    return Stream.of(
        Arguments.of(case1, bonusNumber, LottoResult.FIRST),
        Arguments.of(case2, bonusNumber, LottoResult.SECOND),
        Arguments.of(case3, bonusNumber, LottoResult.FOURTH)
    );
  }

  @ParameterizedTest
  @MethodSource("winner")
  @DisplayName("로또 결과를 확인한다.")
  void checkLotto(Lotto lotto, LottoNumber bonusNumber, LottoResult expected) {
    //given
    Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    //when
    lotto.checkResult(winner, bonusNumber);
    //then
    assertEquals(lotto.getResult(), expected);
  }
}