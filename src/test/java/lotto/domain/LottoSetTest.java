package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSetTest {

  @Test
  @DisplayName("로또를 구입하고나면 그 갯수만큼 로또가 생성된다.")
  void generateLotto() {
    Lotto lotto1 = Lotto.generateLotto(new RandomLottoGenerator());
    Lotto lotto2 = Lotto.generateLotto(new RandomLottoGenerator());
    LottoSet lottoSet = new LottoSet(List.of(lotto1, lotto2));
    assertThat(lottoSet.size()).isEqualTo(2);
  }
}
