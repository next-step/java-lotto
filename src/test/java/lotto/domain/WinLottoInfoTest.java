package lotto.domain;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoInfoTest {

  @DisplayName("당첨로또에 관련된 로또번호와 보너스번호 생성.")
  @Test
  void 당첨로또정보생성() {
    List<Integer> values = new ArrayList<>();
    range(1, 7).forEach(values::add);

    Lotto lotto = new Lotto(values);
    int bonus = 7;
    WinLottoInfo winLottoInfo = new WinLottoInfo(lotto,bonus);

    assertThat(winLottoInfo.getBonusLottoNumber()).isEqualTo(new LottoNumber(bonus));
    assertThat(winLottoInfo.getLotto()).isEqualTo(new Lotto(values));
    assertThat(winLottoInfo.getLottoNumbers().size()).isEqualTo(6);
  }

  @DisplayName("당첨로또번호와 보너스번호간에 번호 중복시 검증 테스트.")
  @Test
  void 당첨로또번호와보너스번호간의중복검사() {
    List<Integer> values = new ArrayList<>();
    range(1, 7).forEach(values::add);

    Lotto lotto = new Lotto(values);
    int bonus = 1;

    assertThatThrownBy(
        () -> new WinLottoInfo(lotto,bonus)
    )
        .isInstanceOf(IllegalArgumentException.class);
  }
}