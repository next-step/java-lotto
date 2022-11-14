package nextstep.lotto;

import static nextstep.lotto.domain.LottoNumber.lottoNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @DisplayName("1-45 이외의 숫자는 입력할 수 없다.")
  @ParameterizedTest
  @ValueSource(ints = {-1, 46})
  public void spec01(final int invalidNumber) {
    assertThatIllegalArgumentException().isThrownBy(() -> lottoNumber(invalidNumber));
  }

  @DisplayName("1-45 의 숫자로 생성 가능하다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 4, 45})
  public void spec02(final int number) {
    assertThatNoException().isThrownBy(() -> lottoNumber(number));
  }

  @DisplayName("같은 번호인지 비교할 수 있다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 5, 8, 19})
  public void spec03(final int number) {
    assertThat(lottoNumber(number)).isEqualTo(lottoNumber(number));
  }

  @DisplayName("로또 번호는 낮은 번호 순으로 정렬 가능하다.")
  @Test
  public void spec04() {

    final List<LottoNumber> lottoNumbers = List.of(
      lottoNumber(3),
      lottoNumber(30),
      lottoNumber(1)
    );

    final List<LottoNumber> sortedLottoNumbers =
      lottoNumbers
        .stream()
        .sorted()
        .collect(Collectors.toList());

    assertThat(sortedLottoNumbers).containsExactly(
      lottoNumber(1),
      lottoNumber(3),
      lottoNumber(30)
    );
  }
}
