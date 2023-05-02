package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

  @Test
  void 당첨번호_중에서_몇개를_맞춘경우_검증() {
    LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

    WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 43, 45, 46));

    assertThat(lottoNumbers.countMatch(winningNumbers)).isEqualTo(3);
  }

  @Test
  void 당첨번호_중에서_하나도_맞히지_않은_경우_검증() {
    LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

    WinningNumbers winningNumbers = new WinningNumbers(List.of(11, 12, 13, 43, 45, 46));

    assertThat(lottoNumbers.countMatch(winningNumbers)).isEqualTo(0);
  }


}