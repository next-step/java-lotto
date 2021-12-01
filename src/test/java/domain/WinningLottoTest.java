package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static common.Constants.DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

  @ParameterizedTest
  @MethodSource("lottosMethodSource")
  @DisplayName("당첨로또가 갖는 bonusNumber와 같은 숫자의 lottoNumber를 갖고있는 경우 isContainsBonusNumber의 결과가 true이고," +
          "그렇지 않은 경우 결과가 false임을 검증하기 위한 테스트")
  void containsBonusNumber(Lotto lotto, boolean expected) {
    // given
    int bonusNumber = 7;
    List<LottoNumber> lottoNumbers = makeLottoNumbers("1,2,3,4,5,6");
    WinningLotto winningLotto = new WinningLotto(lottoNumbers, new LottoNumber(bonusNumber));

    // when
    boolean containsBonusNumber = winningLotto.isContainsBonusNumber(lotto);

    // then
    assertThat(containsBonusNumber).isEqualTo(expected);
  }

  static Stream<Arguments> lottosMethodSource() {
    return Stream.of(
            Arguments.of(new Lotto(makeLottoNumbers("1,2,3,4,5,6")), false),
            Arguments.of(new Lotto(makeLottoNumbers("1,2,3,4,5,7")), true)
    );
  }

  private static List<LottoNumber> makeLottoNumbers(String numbers) {
    return Stream.of(numbers.split(DELIMITER))
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
  }

}