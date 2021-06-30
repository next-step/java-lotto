package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("자동 로또 생성 되는지 테스트")
    @Test
    void makeLottoTest() {
        assertThat(LottoGenerator.makeBunchOfAutoLotto(1).getBunchOfLotto().get(0).getClass()).isEqualTo(Lotto.class);
    }

    @DisplayName("수동 로또 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void makeManualLottoTest(String inputNumber) {

        assertThat(LottoGenerator.makeManualLotto(inputNumber).getClass()).isEqualTo(Lotto.class);
    }

    @DisplayName("로또생성기는 구입 가능한 로또의 수 만큼 자동 로또를 발급한다.")
    @Test
    void getBunchOfAutoLottoTest() {
        PurchaseCalculator purchaseCalculator = new PurchaseCalculator(14000);
        int purchasedLottoCount = purchaseCalculator.getPurchasableLottoCounts();
        BunchOfLotto bunchOfLotto = LottoGenerator.makeBunchOfAutoLotto(purchasedLottoCount);

        Assertions.assertThat(bunchOfLotto.getBunchOfLotto().size()).isEqualTo(purchasedLottoCount);
    }
}
