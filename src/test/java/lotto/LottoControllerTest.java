package lotto;

import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.PurchaseCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    @DisplayName("로또 머신은 구입 가능한 로또의 수 만큼 로또를 발급한다.")
    @Test
    public void makeBunchOfLottoTest() {
        LottoController lottoMachine = new LottoController();
        Set<Lotto> bunchOfLotto = lottoMachine.makeBunchOfLotto(14);
        Assertions.assertThat(bunchOfLotto.size()).isEqualTo(PurchaseCalculator.countPurchasable(14000));
    }

    @DisplayName("금액 입력시 구입 금액에 해당하는 `로또를 살 수 있다`.")
    @Test
    public void countPurchasableTest() {
        int purchaseAmount = 14000;
        assertThat(purchaseAmount / 1000).isEqualTo(14);
    }
}
