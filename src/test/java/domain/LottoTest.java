package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

  @Test
  @DisplayName("로또 기본생성자는 숫자를 6개 갖는 로또 객체를 생성함을 검증하는 테스트.")
  void lottoDefaultConstructor() {
    // given, when
    Lotto lotto = new Lotto();
    List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

    // then
    assertThat(lottoNumbers).isNotEmpty();
    assertThat(lottoNumbers.size()).isEqualTo(Lotto.LOTTO_SIZE);
  }

  @Test
  @DisplayName("6개의 정수를 임의로 지정해서 로또 객체를 생성할 수 있는지 검증하기 위한 테스트.")
  void createCustomLotto() {
    // given
    List<LottoNumber> customNumbers = new ArrayList(6);
    IntStream.rangeClosed(1, 6).forEach(number -> customNumbers.add(new LottoNumber(number)));

    // when
    Lotto lotto = new Lotto(customNumbers);

    // then
    assertThat(lotto.getLottoNumbers().size()).isEqualTo(Lotto.LOTTO_SIZE);
  }

  @ParameterizedTest
  @MethodSource("invalidLottoNumbersSource")
  @DisplayName("로또 객체를 생성하기 위한 정수가 6개가 아닌 경우 예외가 발생함을 검증하기 위한 테스트.")
  void createCustomLottoWithFiveNumbers(List<LottoNumber> customLottoNumbers) {
    assertThatThrownBy(() -> {
      // when
      new Lotto(customLottoNumbers);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  static Stream<Arguments> invalidLottoNumbersSource() {
    return Stream.of(
            Arguments.of(IntStream.rangeClosed(1, 5).mapToObj(LottoNumber::new).collect(toList())),
            Arguments.of(IntStream.rangeClosed(1, 7).mapToObj(LottoNumber::new).collect(toList()))
    );
  }

}
