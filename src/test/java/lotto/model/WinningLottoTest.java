package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import lotto.exception.LottoNumberDuplicateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

  @Test
  @DisplayName("입력된 지난주 로또번호들의 갯수는 6개이다")
  void checkNumberOfGeneratedLottoNumbers() {
    // given
    WinningLotto lottoNumbers = WinningLotto.create("1, 2, 3, 4, 5, 6", 10);

    // then
    assertThat(lottoNumbers.getWinningLottoNumbers().getLottoNumbers()).hasSize(6);
  }

  @Test
  @DisplayName("중복된 로또 번호가 존재한다면 예외처리를 한다")
  void exceptionDuplicateLottoNumbers() {
    // when & then
    assertThatThrownBy(() -> WinningLotto.create("1, 1, 1, 1, 1, 1", 10))
        .isInstanceOf(LottoNumberDuplicateException.class);
  }

  @ParameterizedTest(name = "지난 우승 로또번호 {0}와 구매한 로또번호 {1}가 일치하는 갯수는 {2}개 이다")
  @MethodSource("winningLottoNumberAndMatchedCount")
  void checkCompareWinningLottoNumberMatches(String lastWinningLotto, String purchasedLotto,
      int expected) {
    // given
    WinningLotto winningLotto = WinningLotto.create(lastWinningLotto, 10);
    Lotto lotto = Lotto.create(purchasedLotto);

    // when
    int matchOfCount = winningLotto.matchWinningLottoNumbers(lotto);

    // then
    assertThat(matchOfCount).isEqualTo(expected);
  }

  @ParameterizedTest(name = "보너스 로또번호는 {0}이며 구매한 로또는 {1}으로 보너스 로또번호가 포함된 결과는 {2}이다")
  @CsvSource({"10,true", "6,false"})
  void checkPurchasedLottoContainsBonusLottoNumber(int bonusNumber, boolean expected) {
    // given
    Lotto lotto = Lotto.create("1, 2, 3, 4, 5, 10");
    WinningLotto winningLotto = WinningLotto.create("1, 2, 3, 4, 5, 6", bonusNumber);
    
    // when
    boolean result = winningLotto.isWinningBonusLottoNumber(lotto);
    
    // then
    assertThat(result).isEqualTo(expected);
  }

  private static Stream<Arguments> winningLottoNumberAndMatchedCount() {
    return Stream.of(
        arguments("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6", 6),
        arguments("1, 2, 3, 4, 5, 6", "10, 2, 3, 4, 5, 6", 5),
        arguments("1, 2, 3, 4, 5, 6", "10, 20, 3, 4, 5, 6", 4),
        arguments("1, 2, 3, 4, 5, 6", "10, 20, 30, 4, 5, 6", 3),
        arguments("1, 2, 3, 4, 5, 6", "10, 20, 30, 40, 5, 6", 2),
        arguments("1, 2, 3, 4, 5, 6", "10, 20, 30, 40, 15, 6", 1),
        arguments("1, 2, 3, 4, 5, 6", "10, 20, 30, 40, 15, 16", 0)
    );
  }
}
