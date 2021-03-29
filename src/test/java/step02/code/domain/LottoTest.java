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
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {
  
  @Test
  @DisplayName("lotto 생성시, 6자리의 숫자가 들어오지 않으면, error")
  public void checkLottoLength() {
    assertThatThrownBy(() -> {
      new Lotto(Arrays.asList(1,2,3,4,5));
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("lotto 생성시, 중복되는 숫자가 존재하면, error")
  public void checkSameNumber() {
    assertThatThrownBy(() -> {
      new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @MethodSource("lottoAndWinningNumberAndMatch")
  @DisplayName("lotto 와 지난주 당첨번호와 비교후, 동일한 숫자 갯수를 리턴")
  public void grade(List<Integer> lottoNumber, String winningNumber, int match) {
    Lotto lotto = new Lotto(lottoNumber);
    Lotto winning = Lotto.makeLottoByString(winningNumber);

    int numberOfMatched = lotto.match(winning);

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

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("winning number 에 들어가는 string 값이, null or empty 값의 경우, error")
  public void checkEmpty(String str) {
    assertThatThrownBy(() -> {
      Lotto.makeLottoByString(str);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {".fwe", "2f"})
  @DisplayName("winning number 에 들어가는 string 값이, 숫자가 아닌 경우, error")
  public void checkNumber(String str) {
    assertThatThrownBy(() -> {
      Lotto.makeLottoByString(str);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @MethodSource("winningNumberStringAndResult")
  @DisplayName("string 값으로 지난주 당첨번호가 의도한 값으로 생성확인")
  public void make(String str, Lotto result) {
    Lotto winningNumber = Lotto.makeLottoByString(str);

    assertThat(winningNumber).isEqualTo(result);
  }

  private static Stream<Arguments> winningNumberStringAndResult() {
    return Stream.of(
      Arguments.of(
        "1, 2, 3, 4, 5, 6",
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
      ),
      Arguments.of(
        "1, 2,3, 4,5 ,6",
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
      )
    );
  }

  @Test
  @DisplayName("로또번호에, 보너스 숫자와 match 된는 값이 있는경우 true")
  public void matchWithBonusNumber() {
    Lotto matched = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto noneMatched = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
    Number bonus = new Number(1);

    assertThat(matched.isMatchBonus(bonus)).isTrue();
    assertThat(noneMatched.isMatchBonus(bonus)).isFalse();
  }

}
