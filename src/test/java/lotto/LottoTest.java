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

public class LottoTest {

  @Test
  void Lotto_생성_성공() {
    assertDoesNotThrow(() -> new Lotto());
  }

  @Test
  void Set으로_Lotto_생성_성공() {
    Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
    assertDoesNotThrow(() -> new Lotto(set));
  }

  @ParameterizedTest(name = "{0} 으로 Lotto 생성이 실패함")
  @MethodSource("invalidLottoNumberSet")
  void Set으로_Lotto_생성_실패(Set<Integer> invalidLottoNumberSet) {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Lotto(invalidLottoNumberSet)
    );
  }

  private static Stream<Arguments> invalidLottoNumberSet() {
    return Stream.of(
        Arguments.of(Set.of(1, 2, 3, 4, 5)),
        Arguments.of(Set.of("hi, hello")),
        Arguments.of(Set.of())
    );
  }

  @ParameterizedTest(name = "{1}과 {0}개 일치함")
  @MethodSource("expectedMatchedCountAndOtherLotto")
  void matches_true_반환(int expectedMatchedCount, Lotto other) {
    Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

    assertThat(lotto.matches(expectedMatchedCount, other)).isTrue();
  }

  private static Stream<Arguments> expectedMatchedCountAndOtherLotto() {
    return Stream.of(
        Arguments.of(1, new Lotto(Set.of(1, 12, 13, 14, 15, 16))),
        Arguments.of(2, new Lotto(Set.of(1, 2, 13, 14, 15, 16))),
        Arguments.of(3, new Lotto(Set.of(1, 2, 3, 14, 15, 16))),
        Arguments.of(4, new Lotto(Set.of(1, 2, 3, 4, 15, 16))),
        Arguments.of(5, new Lotto(Set.of(1, 2, 3, 4, 5, 16))),
        Arguments.of(6, new Lotto(Set.of(1, 2, 3, 4, 5, 6)))
        );
  }

  @Test
  void matches_false_반환() {
    Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    Lotto otherLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    int expectedMatchedCount = 0;

    assertThat(lotto.matches(expectedMatchedCount, otherLotto)).isFalse();
  }

  @Test
  void toString_성공() {
    Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    String expectedLottoString = "[1, 2, 3, 4, 5, 6]";

    assertThat(lotto.toString()).isEqualTo(expectedLottoString);
  }
}
