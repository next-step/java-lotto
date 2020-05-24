package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.InvalidRangeNumberException;
import step2.exception.LottoCountException;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static step2.domain.LottoGenerator.generateLotto;

public class LottoTest {

  @DisplayName("로또 번호가 6개가 아닐경우 LottoCountException 발생")
  @ParameterizedTest
  @ValueSource( strings = { "1,2,3,4,5,6,7", "1,2,3,4,5", "1,2,3,4,5,5", "1,1,2,2,3,3" } )
  void 로또_번호_갯수_검증 (String lottoNumbers) {
    assertThatExceptionOfType(LottoCountException.class)
      .isThrownBy(() -> generateLotto(lottoNumbers));
  }

  @DisplayName("로또 번호의 범위가 1 ~ 45가 아닐 경우 InvalidRangeNumberException 발생")
  @ParameterizedTest
  @ValueSource( strings = { "-1,2,3,4,5,6", "0,1,2,3,4,5", "1,2,3,4,5,46" } )
  void 로또_번호_범위_검증 (String lottoNumbers) {
    assertThatExceptionOfType(InvalidRangeNumberException.class)
      .isThrownBy(() -> generateLotto(lottoNumbers));
  }

  @DisplayName("로또 번호에 중복이 있는 경우, 중복 번호 제거")
  @ParameterizedTest
  @ValueSource( strings = { "1,2,3,4,5,6,6", "1,1,2,2,3,3,4,4,5,5,6,6" } )
  void 로또_번호_중복_제거 (String lottoNumbers) {
    String expected = "1,2,3,4,5,6";
    Lotto lotto = generateLotto(lottoNumbers);
    assertEquals(expected, lotto.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(",")));
  }

  @DisplayName("로또 생성시 오름차순 정렬이 되는지 검사")
  @ParameterizedTest
  @MethodSource("provideNotSortedLottoNumbers")
  void 로또_번호_오름차순_검사 (Lotto lotto, String expected) {
    assertEquals(expected, lotto.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(",")));
  }

  private static Stream<Arguments> provideNotSortedLottoNumbers () {
    return Stream.of(
      Arguments.of(
        generateLotto("5,6,4,1,2,10"),
        "1,2,4,5,6,10"
      ),
      Arguments.of(
        generateLotto("6,5,4,3,2,1"),
        "1,2,3,4,5,6"
      )
    );
  }
}
