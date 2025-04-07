package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

  private static Stream<Arguments> provideInvalidLottoNumbers() {
    return Stream.of(
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
    );
  }

  @Test
  void 로또_번호_생성() {
    assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)).getNumbersAsString().split(",")).hasSize(6);
  }

  @ParameterizedTest
  @MethodSource("provideInvalidLottoNumbers")
  void 로또_번호_개수_예외(List<Integer> numbers) {
    assertThatThrownBy(() -> new Lotto(numbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 6개여야 합니다. 하지만 %d개입니다.", numbers.size());
  }

  @ParameterizedTest
  @CsvSource({
      "0, 2, 3, 4, 5, 6, '0는 로또 번호가 될 수 없습니다. 로또 번호는 1부터 45 사이의 숫자여야 합니다.'",
      "1, 2, 3, 4, 5, 51, '51는 로또 번호가 될 수 없습니다. 로또 번호는 1부터 45 사이의 숫자여야 합니다.'"
  })
  void 번호가_범위를_벗어나면_예외_발생(int n1, int n2, int n3, int n4, int n5, int n6, String expectedMessage) {
    assertThatThrownBy(() -> new Lotto(Arrays.asList(n1, n2, n3, n4, n5, n6)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(expectedMessage);
  }

  @Test
  void 로또_번호_중복_예외() {
    assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호에 중복된 숫자가 있습니다.");
  }

  @Test
  void 당첨_번호와_일치하는_개수_계산() {
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

    assertThat(lotto.countMatchingNumbers(winningNumbers)).isEqualTo(3);
  }

  @ParameterizedTest
  @CsvSource({
      "1, 2, 3, 4, 5, 6, 7, false",
      "1, 2, 3, 4, 5, 6, 6, true"
  })
  void 보너스_볼_일치_여부_확인(int n1, int n2, int n3, int n4, int n5, int n6, int bonusBall, boolean expected) {
    assertThat(new Lotto(Arrays.asList(n1, n2, n3, n4, n5, n6)).hasBonusBall(bonusBall)).isEqualTo(expected);
  }
} 