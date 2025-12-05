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
    assertThat(new Lotto("1,2,3,4,5,6")).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
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
    assertThat(new Lotto("1,2,3,4,8,5")).isEqualTo(new Lotto("1,2,3,4,5,8"));
  }

  @DisplayName("로또 번호는 중복 시 예외가 발생한다")
  @Test
  void duplicateLottoNumbers() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("1,2,3,4,8,8"))
        .withMessageContaining("중복");
  }

  static Stream<List<Integer>> invalidLottoSizes() {
    return Stream.of(
        List.of(),
        List.of(1, 2, 3, 4, 5),
        List.of(1, 2, 3, 4, 5, 6, 7)
    );
  }

}
