package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.exception.LottoCountException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

  @DisplayName("로또 번호가 6개인지 검증하는 테스트")
  @ParameterizedTest
  @MethodSource("provideLottoNumbers")
  void 로또_번호_갯수_검증 (List<Integer> lottoNumbers) {
    assertThatExceptionOfType(LottoCountException.class)
      .isThrownBy(() -> Lotto.of(lottoNumbers));
  }

  private static Stream<Arguments> provideLottoNumbers () {
    return Stream.of(
      Arguments.of(Arrays.asList("1,2,3,4,5".split(","))),
      Arguments.of(Arrays.asList("1,2,3,4,5,6,7".split(",")))
    );
  }
}
