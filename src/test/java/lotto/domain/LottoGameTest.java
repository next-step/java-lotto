package lotto.domain;

import lotto.domain.model.LottoNumber;
import lotto.exception.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

  private static final List<LottoNumber> LOTTO_NUMBERS = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
      new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

  @ParameterizedTest
  @MethodSource("provideConstructorMaterial")
  void 객체생성_테스트(List<LottoNumber> lottoNumbers, String[] expect) {
    assertThat(new LottoGame(lottoNumbers)).isEqualTo(new LottoGame(expect));
  }

  @ParameterizedTest
  @MethodSource("provideConstructorFailMaterial")
  void 객체생성_실패_테스트(String[] input) {
    assertThatThrownBy(() -> new LottoGame(input))
        .isInstanceOf(LottoGameException.class);
  }

  @DisplayName("toString 테스트")
  @ParameterizedTest
  @MethodSource("provideToStringMaterial")
  void toString_테스트(List<LottoNumber> lottoNumbers, String expect) {
    assertThat(new LottoGame(lottoNumbers).toString()).isEqualTo(expect);
  }

  static Stream<Arguments> provideConstructorMaterial() {
    List<LottoNumber> LOTTO_NUMBERS = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    return Stream.of(Arguments.of(
        LOTTO_NUMBERS,
        new String[]{"1", "2", "3", "4", "5", "6"}
        )
    );
  }

  static Stream<Arguments> provideConstructorFailMaterial() {
    return Stream.of(
        Arguments.of((Object) new String[]{"a", "b", "1", "23", "44", "21"}),
        Arguments.of((Object) new String[]{"100", "2", "3", "3", "44", "21"}),
        Arguments.of((Object) new String[]{"-1", "1", "2", "23", "44", "21"})
    );
  }

  static Stream<Arguments> provideToStringMaterial() {
    return Stream.of(
        Arguments.of(LOTTO_NUMBERS, "[1, 2, 3, 4, 5, 6]")
    );
  }

}