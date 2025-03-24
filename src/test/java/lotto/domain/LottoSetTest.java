package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSetTest {

  @Test
  @DisplayName("로또를 구입금액을 로또 가격으로 나눈 갯수만큼 로또가 생성된다.")
  void generateRandomLotto() {
    LottoSet lottoSet = new LottoSet(14000, new RandomLottoGenerator());
    assertThat(lottoSet.size()).isEqualTo(14);
  }
}
