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

  @Test
  void createLottoFromString() {
    Lotto lotto = new Lotto("1,2,3,4,5,6");
    assertThat(lotto.numbers()).containsExactly(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6)
    );
  }

  @DisplayName("로또 번호는 6개여야 한다")
  @ParameterizedTest
  @MethodSource("invalidLottoSizes")
  void validLottoSize(List<Integer> numbers) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Lotto.fromIntegers(numbers))
        .withMessageContaining("6개");
  }

  @DisplayName("로또 번호는 정렬된다")
  @Test
  void sortLottoNumbers() {
    Lotto lotto = new Lotto(2, 5, 8, 1, 3, 4);
    List<LottoNumber> expectedNumbers = List.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(8)
    );
    assertThat(lotto.numbers()).containsExactlyElementsOf(expectedNumbers);
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
