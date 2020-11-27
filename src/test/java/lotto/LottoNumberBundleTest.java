package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.lottoexception.DuplicatedNumberException;
import lotto.lottoexception.InvalidLottoFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberBundleTest {

  LottoNumberBundle sampleLottoNumberBundle;

  @BeforeEach
  void setUp() {
    this.sampleLottoNumberBundle = LottoNumberBundle.of("1, 2, 3, 4, 5, 6");
  }

  @ParameterizedTest
  @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
  @DisplayName("적거나, 많은 숫자에 대한 처리")
  void testInvalidFormat(String input) {
    assertThatExceptionOfType(InvalidLottoFormatException.class).isThrownBy(
        () -> LottoNumberBundle.of(input)
    );
  }

  @Test
  @DisplayName("중복된 숫자에 대한 예외 처리")
  void testDuplicatedCase() {
    assertThatExceptionOfType(DuplicatedNumberException.class).isThrownBy(
        () -> LottoNumberBundle.of("1, 2, 3, 3, 4, 5")
    );
  }

  @Test
  @DisplayName("contains() 지원")
  void testContains() {
    assertThat(LottoNumberBundle.of("1, 2, 3, 4, 5, 6").contains(LottoNumber.of(1)))
        .isEqualTo(true);
  }

  @Test
  @DisplayName("toString()")
  void testToSting() {
    assertThat(LottoNumberBundle.of("1, 2, 3, 4, 5, 6").toString())
        .isEqualTo("[1, 2, 3, 4, 5, 6]");
  }

  @Test
  @DisplayName("Iterable 테스트")
  void testIterable() {
    int idx = 1;
    for (LottoNumber number : this.sampleLottoNumberBundle) {
      assertThat(number).isEqualTo(LottoNumber.of(idx));
      idx += 1;
    }
  }

  @Test
  @DisplayName("동일성 테스트")
  void testEquality() {
    assertThat(LottoNumberBundle.of("1, 2, 3, 4, 5, 6"))
        .isEqualTo(LottoNumberBundle.of("3, 1, 4, 5, 2, 6"));
  }
}
