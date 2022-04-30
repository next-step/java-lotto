package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  @DisplayName("구매한 로또의 갯수만큼 로또 객체 생성")
  void createLottoObjectNumberOfPurchasedLotto() {
    // given
    int purchasedLotto = 3;

    // when
    Lottos lottos = Lottos.create(purchasedLotto);

    // then
    assertThat(lottos.getLottos()).hasSize(purchasedLotto);
  }
}