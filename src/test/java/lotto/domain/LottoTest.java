package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

  @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
  @Test
  void createLottoByInvalidSize() {
    // given
    List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);

    // when & then
    assertThatThrownBy(() -> new Lotto(invalidNumbers))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @Test
  void createLottoByDuplicatedNumber() {
    // given
    List<Integer> duplicatedNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

    // when & then
    assertThatThrownBy(() -> new Lotto(duplicatedNumbers))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호와 당첨 번호의 일치하는 개수를 반환한다.")
  @ParameterizedTest
  @MethodSource("provideLottoNumbersAndWinningNumbers")
  void countMatchingNumbers(
      List<Integer> lottoNumbers, List<Integer> winningNumbers, int expected) {
    // given
    Lotto lotto = new Lotto(lottoNumbers);
    Lotto winningLotto = new Lotto(winningNumbers);

    // when
    int actual = lotto.countMatchingNumbers(winningLotto);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  @DisplayName("로또 번호가 보너스 번호를 포함하는지 확인한다.")
  @Test
  void containsBonusNumber() {
    // given
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoNumber bonusNumber = new LottoNumber(6);

    // when
    boolean contains = lotto.containsNumber(bonusNumber.getNumber());

    // then
    assertThat(contains).isTrue();
  }

  @DisplayName("로또 번호가 보너스 번호를 포함하지 않는지 확인한다.")
  @Test
  void notContainsBonusNumber() {
    // given
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoNumber bonusNumber = new LottoNumber(7);

    // when
    boolean contains = lotto.containsNumber(bonusNumber.getNumber());

    // then
    assertThat(contains).isFalse();
  }

  @DisplayName("LottoNumber 객체를 직접 사용하여 로또를 생성할 수 있다.")
  @Test
  void createLottoWithLottoNumbers() {
    // given
    List<LottoNumber> lottoNumbers =
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(Collectors.toList());

    // when
    Lotto lotto = new Lotto(lottoNumbers, true);

    // then
    assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
  }

  private static Stream<Arguments> provideLottoNumbersAndWinningNumbers() {
    return Stream.of(
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 6),
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(7, 8, 9, 10, 11, 12), 0),
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 7, 8, 9), 3));
  }
}
