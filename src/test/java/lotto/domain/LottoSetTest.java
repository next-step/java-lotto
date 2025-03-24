package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSetTest {

  @Test
  @DisplayName("입력 금액으로 몇 장의 로또를 살 수 있는지 계산한다.")
  void calculateLottoCount() {
    LottoSet lottoSet = new LottoSet(14000);
    assertThat(lottoSet.getLottoCount()).isEqualTo(14000/LottoSet.LOTTO_PRICE);
  }

  @Test
  @DisplayName("로또를 구입하고나면 그 갯수만큼 로또가 생성된다.")
  void generateLotto() {
    LottoSet lottoSet = new LottoSet(14000);
    assertThat(lottoSet.getLottos().size()).isEqualTo(14000/LottoSet.LOTTO_PRICE);
  }
}
