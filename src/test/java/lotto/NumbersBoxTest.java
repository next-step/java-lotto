package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumbersBoxTest {

  @Test
  public void 로또숫자6개를_반환한다() {
    assertThat(NumbersBox.getLottoNumbers())
        .extracting(LottoNumbers::getSize)
        .isEqualTo(6);
  }

  @Test
  public void 로또숫자6개는_중복되지않는다() {
    LottoNumbers lottoNumbers = NumbersBox.getLottoNumbers();
    List<LottoNumber> numbers = lottoNumbers.getValues();
    assertThat(numbers.stream().distinct().count()).isEqualTo(numbers.size());
  }

}