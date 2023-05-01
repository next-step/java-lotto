package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumbersTest {

  private static final int TEST_NUMBER = 6;

  @Test
  @DisplayName("입력한 수 만큼 LottoNumber를 가져온다")
  void lottoNumberCountTest() {
    List<LottoNumber> pick = LottoNumbers.pickBySize(TEST_NUMBER);

    assertThat(pick).hasSize(TEST_NUMBER);
  }

  @Test
  @DisplayName("원하는 번호를 얻어온다")
  void pickTest() {
    LottoNumber three = LottoNumbers.pick("3");

    assertThat(three.value()).isEqualTo(3);
  }

  @Test
  @DisplayName("같은 타입의 요청이라면 같은 LottoNumber 객체를 가져온다")
  void lottoNumberSameAddressTest() {
    LottoNumber pickFirst = LottoNumbers.pick(String.valueOf(TEST_NUMBER));
    LottoNumber pickSecond = LottoNumbers.pick(String.valueOf(TEST_NUMBER));

    assertThat(pickFirst).isSameAs(pickSecond);
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 46})
  @DisplayName("Number의 범위를 벗어나면 예외를 발생시킨다")
  void lottoNumberBoundaryExceptionTest(int number) {
    assertThatThrownBy(() -> LottoNumbers.pick(String.valueOf(number)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(String.format("숫자는 %d ~ %d 사이의 값만 들어올 수 있습니다.", LottoNumbers.LOTTO_NUMBER_INBOUND, LottoNumbers.LOTTO_NUMBER_OUTBOUND));
  }

  @Test
  @DisplayName("숫자가 아닌 값을 입력하면 예외를 발생시킨다")
  void nonNumberExceptionTest() {
    assertThatThrownBy(() -> LottoNumbers.pick("ONE"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("숫자만 입력할 수 있습니다. 입력된 값 : " + "ONE");
  }
}