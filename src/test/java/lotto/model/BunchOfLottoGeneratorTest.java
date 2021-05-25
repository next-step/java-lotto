package lotto.model;

import lotto.model.BunchOfLottoGenerator;
import lotto.model.Lotto;
import lotto.model.PurchaseCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BunchOfLottoGeneratorTest {

    @DisplayName("로또생성기는 구입 가능한 로또의 수 만큼 로또를 발급한다.")
    @Test
    void getBunchOfLottoTest() {
        PurchaseCalculator purchaseCalculator = new PurchaseCalculator(14000);
        int purchasedLottoCount = purchaseCalculator.CalculatePurchasableCount();
        BunchOfLottoGenerator bunchOfLottoGenerator = new BunchOfLottoGenerator(purchasedLottoCount);
        List<Lotto> bunchOfLotto = bunchOfLottoGenerator.getBunchOfLotto();

        Assertions.assertThat(bunchOfLotto.size()).isEqualTo(purchasedLottoCount);
    }
}
