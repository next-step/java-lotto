package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

  @Test
  public void 로또숫자는6자리여야한다() {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    lottoNumbers.add(new LottoNumber(1));
    lottoNumbers.add(new LottoNumber(2));
    lottoNumbers.add(new LottoNumber(3));
    lottoNumbers.add(new LottoNumber(4));
    lottoNumbers.add(new LottoNumber(5));

    assertThatThrownBy(() -> {
      new LottoNumbers(lottoNumbers);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("로또 번호는 6개여야 합니다.");
  }

}