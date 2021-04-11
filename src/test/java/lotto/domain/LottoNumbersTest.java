package lotto.domain;

import lotto.function.SixLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumbersTest {

  @Test
  @DisplayName("6개의 임의의 로또 숫자를 생성한다.")
  void generateSixNumbers() {
    // given
    LottoNumbers lottoNumbers = LottoNumbers.generateSixNumbers(new SixLottoNumbers());

    // when
    int actual = lottoNumbers.size();

    // then
    assertThat(actual).isEqualTo(6);
  }

  @Test
  @DisplayName("생성된 로또 번호들에 대해 추가/수정/삭제를 할 수 없다.")
  void generateSixNumbers_immutableList() {
    // given
    List<LottoNumber> list = LottoNumbers.generateSixNumbers(new SixLottoNumbers())
            .getValues();

    // when

    // then
    assertAll(() -> assertThatThrownBy(() -> list.add(LottoNumber.generate(1))).isInstanceOf(UnsupportedOperationException.class)
            , () -> assertThatThrownBy(() -> list.remove(0)).isInstanceOf(UnsupportedOperationException.class)
            , () -> assertThatThrownBy(() -> list.replaceAll(lotto -> LottoNumber.generate(1))).isInstanceOf(UnsupportedOperationException.class)
    );
  }

  @ParameterizedTest
  @MethodSource("getMatchLottoNumberArgument")
  @DisplayName("로또 당첨 번호와 비교하여 총 맞은 번호 갯수를 반환한다.")
  void matchLottoNumber(int startNumber, int endNumber, int matchCount) {
    // given
    LottoNumbers lottoWiningNumbers = getLottoNumbers(1, 6);

    // when
    LottoNumbers lottoNumbers = getLottoNumbers(startNumber, endNumber);

    // then
    assertThat(lottoWiningNumbers.matchLottoNumber(lottoNumbers))
            .isEqualTo(matchCount);
  }

  private LottoNumbers getLottoNumbers(final int startNumber, final int endNumber) {
    return LottoNumbers.generateSixNumbers(() -> IntStream.rangeClosed(startNumber, endNumber)
            .mapToObj(LottoNumber::generate)
            .collect(Collectors.toList()));
  }

  static Stream<Arguments> getMatchLottoNumberArgument() {
    return Stream.of(
              Arguments.of(1, 6, 6)
            , Arguments.of(2, 7, 5)
            , Arguments.of(3, 8, 4)
            , Arguments.of(4, 9, 3)
            , Arguments.of(5, 10, 2)
            , Arguments.of(6, 11, 1)
            , Arguments.of(7, 12, 0)
    );
  }
}
