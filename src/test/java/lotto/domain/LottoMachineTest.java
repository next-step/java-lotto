package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

  @Test
  @DisplayName("로또 자동 발급이 가능하다.")
  void generateRandomLotto() {
    LottoMachine lottoMachine = new LottoMachine();
    LottoSet lottoSet = lottoMachine.generateRandomLotto(new LottoPurchase(3*LottoPurchase.PRICE));

    assertThat(lottoSet.size()).isEqualTo(3);
  }

  @Test
  @DisplayName("로또 수동 발급이 가능하다.")
  void generateManualLotto() {
    LottoMachine lottoMachine = new LottoMachine();
    Lotto lotto1 = Lotto.of("1, 2, 3, 4, 5, 6");
    Lotto lotto2 = Lotto.of("1, 2, 3, 4, 5, 7");
    Lotto lotto3 = Lotto.of("1, 2, 3, 4, 5, 8");
    LottoSet lottoSet = lottoMachine.generateManualLotto(new LottoPurchase(3*LottoPurchase.PRICE), Arrays.asList(lotto1, lotto2, lotto3));

    assertThat(lottoSet.size()).isEqualTo(3);
  }

  @Test
  @DisplayName("로또 자동+수동 발급이 가능하다.")
  void generateManualAndRandomLotto() {
    LottoMachine lottoMachine = new LottoMachine();
    Lotto lotto1 = Lotto.of("1, 2, 3, 4, 5, 6");
    Lotto lotto2 = Lotto.of("1, 2, 3, 4, 5, 7");
    Lotto lotto3 = Lotto.of("1, 2, 3, 4, 5, 8");
    LottoSet lottoSet = lottoMachine.generateManualAndRandomLotto(new LottoPurchase(5*LottoPurchase.PRICE), Arrays.asList(lotto1, lotto2, lotto3));

    assertThat(lottoSet.size()).isEqualTo(5);
  }
}
