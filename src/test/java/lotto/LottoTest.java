package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

  @DisplayName("로또를 생성한다")
  @Test
  void createLotto() {
    Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
    assertThat(lotto).isNotNull();
  }

  @DisplayName("로또 번호는 6개여야 한다")
  @ParameterizedTest
  @MethodSource("invalidLottoSizes")
  void validLottoSize(List<Integer> numbers) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new Lotto(numbers))
        .withMessageContaining("6개");
  }

  @DisplayName("로또 번호는 1~45 사이의 숫자로 구성된다")
  @ParameterizedTest
  @MethodSource("invalidLottoNumberRange")
  void validLottoNumberRange(List<Integer> numbers) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new Lotto(numbers))
        .withMessageContaining("1~45");
  }

  @DisplayName("로또 번호는 중복될 수 없다")
  @Test
  void validateNoDuplicates() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new Lotto(1, 1, 2, 3, 4, 5))
        .withMessageContaining("중복");
  }

  @DisplayName("로또 번호는 정렬된다")
  @Test
  void sortLottoNumbers() {
    Lotto lotto = new Lotto(2, 5, 8, 1, 3, 4);
    List<Integer> expected = List.of(1, 2, 3, 4, 5, 8);
    assertThat(lotto.numbers()).isEqualTo(expected);
  }

  @DisplayName("일치하는 번호가 없으면 0을 반환한다")
  @Test
  void compareNumbers_NoneEqual() {
    Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
    Lotto winningNumbers = new Lotto(7, 8, 9, 10, 11, 12);
    assertThat(lotto.countMatchingNumbers(winningNumbers)).isEqualTo(0);
  }

  @DisplayName("전부 일치하면 6을 반환한다")
  @Test
  void compareNumbers_AllEqual() {
    Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
    Lotto winningNumbers = new Lotto(1, 2, 3, 4, 5, 6);
    assertThat(lotto.countMatchingNumbers(winningNumbers)).isEqualTo(6);
  }


  static Stream<List<Integer>> invalidLottoSizes() {
    return Stream.of(
        List.of(),
        List.of(1, 2, 3, 4, 5),
        List.of(1, 2, 3, 4, 5, 6, 7)
    );
  }

  static Stream<List<Integer>> invalidLottoNumberRange() {
    return Stream.of(
        List.of(-1, 2, 3, 4, 5, 6),
        List.of(0, 2, 3, 4, 5, 6),
        List.of(1, 2, 3, 4, 5, 46)
    );
  }

}
