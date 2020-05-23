package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.exception.LottoCountException;
import step2.exception.LottoReduplicateException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

  @DisplayName("로또 번호가 6개인지 검증하는 테스트")
  @ParameterizedTest
  @MethodSource("provideLottoWrongNumbers")
  void 로또_번호_갯수_검증 (List<Integer> lottoNumbers) {
    assertThatExceptionOfType(LottoCountException.class)
      .isThrownBy(() -> Lotto.of(lottoNumbers));
  }

  private static Stream<Arguments> provideLottoWrongNumbers () {
    return Stream.of(
      Arguments.of(Arrays.asList("1,2,3,4,5".split(","))),
      Arguments.of(Arrays.asList("1,2,3,4,5,6,7".split(",")))
    );
  }

  @DisplayName("로또 번호의 중복 여부를 검사")
  @ParameterizedTest
  @MethodSource("provideReduplicateLottoNumbers")
  void 로또_번호_중복_검증 (List<Integer> lottoNumbers) {
    assertThatExceptionOfType(LottoReduplicateException.class)
      .isThrownBy(() -> Lotto.of(lottoNumbers));
  }

  private static Stream<Arguments> provideReduplicateLottoNumbers () {
    return Stream.of(
      Arguments.of(Arrays.asList("1,2,3,4,5,5".split(","))),
      Arguments.of(Arrays.asList("1,1,2,2,3,3".split(",")))
    );
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
        Lotto.ofString(Arrays.asList("5,6,4,1,2,10".split(","))),
        "1,2,4,5,6,10"
      ),
      Arguments.of(
        Lotto.ofString(Arrays.asList("6,5,4,3,2,1".split(","))),
        "1,2,3,4,5,6"
      )
    );
  }
}
