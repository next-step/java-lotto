package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoNumberTest {

  @DisplayName("로또 번호가 1과 45 사이가 아닌 경우 예외를 발생시킨다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  void testLottoNumberRange(int number) {
    assertThatThrownBy(() -> new LottoNumber(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1과 45 사이여야 합니다.");
  }

  @DisplayName("로또 번호 비교를 테스트한다.")
  @Test
  void testCompareLottoNumber() {
    LottoNumber lottoNumber1 = new LottoNumber(1);
    LottoNumber lottoNumber2 = new LottoNumber(2);
    LottoNumber lottoNumber3 = new LottoNumber(3);
    LottoNumber lottoNumber4 = new LottoNumber(4);
    LottoNumber lottoNumber5 = new LottoNumber(5);
    LottoNumber lottoNumber6 = new LottoNumber(6);

    List<LottoNumber> lottoNumbers = Arrays.asList(lottoNumber6, lottoNumber5, lottoNumber4, lottoNumber3, lottoNumber2, lottoNumber1);
    Collections.sort(lottoNumbers);

    assertThat(lottoNumbers).containsExactly(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6);
  }
}