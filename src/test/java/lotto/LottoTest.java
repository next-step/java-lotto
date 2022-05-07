package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

  @Test
  void Lotto_생성_성공() {
    assertDoesNotThrow(() -> Lotto.create());
  }

  @ParameterizedTest(name = "{0} 으로 Lotto 생성이 성공함")
  @ValueSource(strings = {"1, 2, 3, 4, 5 ,6", "1 ,2 ,3 ,4 ,5 ,6", " 1 , 2 , 3 , 4 , 5 , 6"})
  void String로_Lotto_생성_성공(String given) {
    assertDoesNotThrow(() -> Lotto.create(given));
  }

  @ParameterizedTest(name = "{0} 으로 Lotto 생성이 실패함")
  @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, ", "1, 1, 1, 1, 1, 1 "})
  void String로_Lotto_생성_실패(String given) {
    assertThrows(IllegalArgumentException.class, () -> Lotto.create(given));
  }

  @Test
  void Set으로_Lotto_생성_성공() {
    Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
    assertDoesNotThrow(() -> Lotto.create(set));
  }

  @ParameterizedTest(name = "{0} 으로 Lotto 생성이 실패함")
  @MethodSource("invalidLottoNumberSet")
  void Set으로_Lotto_생성_실패(Set<Integer> invalidLottoNumberSet) {
    assertThrows(
        IllegalArgumentException.class,
        () -> Lotto.create(invalidLottoNumberSet)
    );
  }

  private static Stream<Arguments> invalidLottoNumberSet() {
    return Stream.of(
        Arguments.of(Set.of(1, 2, 3, 4, 5)),
        Arguments.of(Set.of(1, 2, 3, 4, 5, -1)),
        Arguments.of(Set.of())
    );
  }

  @ParameterizedTest(name = "{1}과 {0}개 일치함")
  @MethodSource("expectedMatchedCountAndOtherLotto")
  void getMatchedCount_성공(int expectedMatchedCount, Lotto other) {
    Lotto lotto = Lotto.create(Set.of(1, 2, 3, 4, 5, 6));

    assertThat(lotto.getMatchedCount(other)).isEqualTo(expectedMatchedCount);
  }

  private static Stream<Arguments> expectedMatchedCountAndOtherLotto() {
    return Stream.of(
        Arguments.of(1, Lotto.create(Set.of(1, 12, 13, 14, 15, 16))),
        Arguments.of(2, Lotto.create(Set.of(1, 2, 13, 14, 15, 16))),
        Arguments.of(3, Lotto.create(Set.of(1, 2, 3, 14, 15, 16))),
        Arguments.of(4, Lotto.create(Set.of(1, 2, 3, 4, 15, 16))),
        Arguments.of(5, Lotto.create(Set.of(1, 2, 3, 4, 5, 16))),
        Arguments.of(6, Lotto.create(Set.of(1, 2, 3, 4, 5, 6)))
        );
  }

  @Test
  void hasNumber_성공() {
    Lotto lotto = Lotto.create(Set.of(1, 2, 3, 4, 5, 6));
    LottoNumber number = new LottoNumber(6);

    assertThat(lotto.hasNumber(number)).isTrue();
  }

  @Test
  void hasNumber_실패() {
    Lotto lotto = Lotto.create(Set.of(1, 2, 3, 4, 5, 6));
    LottoNumber number = new LottoNumber(7);

    assertThat(lotto.hasNumber(number)).isFalse();
  }
}
