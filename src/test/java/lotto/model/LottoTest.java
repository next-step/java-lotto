package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.exception.LottoNumberDuplicateException;
import lotto.strategy.DuplicateNumberGenerateStrategy;
import lotto.strategy.FixedNumberGenerateStrategy;
import lotto.strategy.RandomNumberGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

  @Test
  @DisplayName("생성된 로또번호들의 갯수는 6개이다")
  void checkNumberOfGeneratedLottoNumbers() {
    // given & when
    Lotto lotto = Lotto.create(new RandomNumberGenerateStrategy());

    // then
    assertThat(lotto.getLottoNumbers()).hasSize(6);
  }

  @Test
  @DisplayName("문자열로 생성된 로또번호들의 갯수는 6개이다")
  void checkListNumberOfGeneratedLottoNumbers() {
    // given & when
    Lotto lotto = Lotto.create("1, 2, 3, 4, 5, 6");

    // then
    assertThat(lotto.getLottoNumbers()).hasSize(6);
  }

  @Test
  @DisplayName("로또가 NULL이거나 EMPTY인 경우, 예외처리를 한다.")
  void exceptionNullOrEmptyLotto() {
    // given
    List<LottoNumber> lottoNumbers = new ArrayList<>();

    // when & then
    assertThatThrownBy(() -> new Lotto(lottoNumbers))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("중복된 로또 번호가 존재한다면 예외처리를 한다")
  void exceptionDuplicateLottoNumbers() {
    // when & then
    assertThatThrownBy(() -> Lotto.create(new DuplicateNumberGenerateStrategy()))
        .isInstanceOf(LottoNumberDuplicateException.class);
  }

  @ParameterizedTest
  @MethodSource("winningLottoNumberAndMatchedCount")
  @DisplayName("구매한 로또번호와 지난 우승 로또번호와 일치하는 갯수")
  void checkNumberMatchingLottoNumbers(String winningLottoNumbers, int matchedCount) {
    // given
    Lotto lotto = Lotto.create(new FixedNumberGenerateStrategy());
    WinningLotto winningLotto = WinningLotto.create(winningLottoNumbers);

    // when
    int matchResult = lotto.matchWinningLottoNumbers(winningLotto.getWinningLottoNumbers());

    // then
    assertThat(matchResult).isEqualTo(matchedCount);
  }

  private static Stream<Arguments> winningLottoNumberAndMatchedCount() {
    return Stream.of(
        arguments("1, 2, 3, 4, 5, 6", 6),
        arguments("1, 2, 3, 4, 10, 6", 5)
    );
  }
}
