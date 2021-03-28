package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {
  
  @Test
  @DisplayName("lotto 생성시, 6자리의 숫자가 들어오지 않으면, error 출력 테스트")
  public void checkLottoLength() {
    assertThatThrownBy(() -> {
      new Lotto(Arrays.asList(1,2,3,4,5));
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("lotto 생성시, 중복되는 숫자가 존재하면, error 출력 테스트")
  public void checkSameNumber() {
    assertThatThrownBy(() -> {
      new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @MethodSource("lottoAndWinningNumberAndMatch")
  @DisplayName("lotto 와 지난주 당첨번호와 비교후, 동일한 숫자 갯수를 리턴하는지 테스트")
  public void grade(List<Integer> lottoNumber, String winningNumber, int match) {
    Lotto lotto = new Lotto(lottoNumber);
    WinningNumber winning = WinningNumber.makeWinningNumberByString(winningNumber);

    int numberOfMatched = lotto.match(winning.number());

    assertThat(numberOfMatched).isEqualTo(match);
  }

  private static Stream<Arguments> lottoAndWinningNumberAndMatch() {
    return Stream.of(
      Arguments.of(
        Arrays.asList(1, 2, 3, 4, 5, 6),
        "1,2,3,4,5,6",
        6
      ),
      Arguments.of(
        Arrays.asList(1, 2, 3, 4, 5, 6),
        "1,2,3,4,5,7",
        5
      )
    );
  }

}
