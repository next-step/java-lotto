package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.LottoCountException;
import step2.exception.LottoReduplicateException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

  @DisplayName("로또 번호가 6개가 아닐경우 LottoCountException 발")
  @ParameterizedTest
  @ValueSource( strings = { "1,2,3,4,5,6,7", "1,2,3,4,5" } )
  void 로또_번호_갯수_검증 (String lottoNumbers) {
    assertThatExceptionOfType(LottoCountException.class)
      .isThrownBy(() -> Lotto.of(lottoNumbers));
  }

  @DisplayName("로또 번호에 중복이 있을 경우 LottoReduplicateException 발생")
  @ParameterizedTest
  @ValueSource( strings = { "1,2,3,4,5,5", "1,1,2,2,3,3" } )
  void 로또_번호_중복_검증 (String lottoNumbers) {
    assertThatExceptionOfType(LottoReduplicateException.class)
      .isThrownBy(() -> Lotto.of(lottoNumbers));
  }

  @DisplayName("로또 생성시 오름차순 정렬이 되는지 검사")
  @ParameterizedTest
  @MethodSource("provideNotSortedLottoNumbers")
  void 로또_번호_오름차순_검사 (Lotto lotto, String expected) {
    assertThat(expected)
      .isEqualTo(lotto.stream().map(String::valueOf).collect(Collectors.joining(",")));
  }

  private static Stream<Arguments> provideNotSortedLottoNumbers () {
    return Stream.of(
      Arguments.of(
        Lotto.of("5,6,4,1,2,10"),
        "1,2,4,5,6,10"
      ),
      Arguments.of(
        Lotto.of("6,5,4,3,2,1"),
        "1,2,3,4,5,6"
      )
    );
  }
}
