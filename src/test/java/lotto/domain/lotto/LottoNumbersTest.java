package lotto.domain.lotto;

import static lotto.domain.lotto.LottoNumbers.LOTTO_NUMBER_COUNT;
import static lotto.domain.lotto.LottoNumbers.LOTTO_NUMBER_CREATION_FAILURE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumbersTest {

  static Stream<Arguments> winningNumbersSource() {
    return Stream.of(
        arguments((Object) new String[]{"1", "2", "3", "4", "5", "6"}),
        arguments((Object) new String[]{"45", "44", "43", "42", "41", "40"})
    );
  }

  static Stream<Arguments> comparingSource() {
    return Stream.of(
        arguments(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"2", "5", "7", "8", "9", "10"}, 2),
        arguments(new String[]{"45", "44", "43", "42", "41", "40"}, new String[]{"1", "2", "3", "4", "5", "6"}, 0)
    );
  }

  static Stream<LottoNumberCreationStrategy> lottoCreationFailureSource() {
    return Stream.of(
        () -> Stream.of(1, 2, 3, 4, 5)
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList()),
        () -> Stream.of(1, 2, 3, 4, 5, 6, 7)
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList())
    );
  }

  @Test
  @DisplayName("생성")
  void create() {
    LottoNumberCreationStrategy lottoNumberCreationStrategy = () -> Stream.of(1, 2, 3, 4, 5, 6)
        .map(LottoNumber::valueOf)
        .collect(Collectors.toList());
    assertThat(new LottoNumbers(lottoNumberCreationStrategy).size()).isEqualTo(LOTTO_NUMBER_COUNT);
  }

  @ParameterizedTest
  @DisplayName("로또 생성 실패")
  @MethodSource("lottoCreationFailureSource")
  void createFail(LottoNumberCreationStrategy failureStrategy) {
    // given

    // when
    // then
    assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(failureStrategy.create()))
        .withMessage(LOTTO_NUMBER_CREATION_FAILURE);
  }

  @ParameterizedTest
  @DisplayName("당첨번호 목록을 입력받아 생성")
  @MethodSource("winningNumbersSource")
  void createWithWinningNumbers(String[] winningNumbers) {
    assertThat(new LottoNumbers(winningNumbers).size()).isEqualTo(LOTTO_NUMBER_COUNT);
  }

  @ParameterizedTest
  @DisplayName("당첨번호와 비교해 일치한 갯수를 반환한다.")
  @MethodSource("comparingSource")
  void compare(String[] myNumbers, String[] winningNumbers, int expectedCount) {
    // given
    LottoNumbers myLottoNumbers = new LottoNumbers(myNumbers);
    LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumbers);

    // when
    int matchCount = myLottoNumbers.countMatchNumbers(winningLottoNumbers);

    // then
    assertThat(matchCount).isEqualTo(expectedCount);
  }

  @Test
  @DisplayName("LottoNumber 포함여부를 반환한다.")
  void contains() {
    // given
    LottoNumbers lottoNumbers = new LottoNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
    LottoNumber containedLottoNumber = LottoNumber.valueOf("6");
    LottoNumber notContainedLottoNumber = LottoNumber.valueOf("7");

    // when
    // then
    assertAll(
        () -> assertThat(lottoNumbers.contains(containedLottoNumber)).isTrue(),
        () -> assertThat(lottoNumbers.contains(notContainedLottoNumber)).isFalse()
    );
  }
}
