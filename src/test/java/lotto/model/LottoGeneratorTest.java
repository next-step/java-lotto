package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoGeneratorTest {

    @DisplayName("자동 로또 생성 되는지 테스트")
    @Test
    void makeLottoTest() {
        assertDoesNotThrow(()->LottoGenerator.makeAutoLottos(1));
    }

    @DisplayName("수동 로또 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void makeManualLottoTest(String inputNumber) {

        assertThat(LottoGenerator.makeManualLotto(inputNumber)).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또생성기는 구입 가능한 로또의 수 만큼 자동 로또를 발급한다.")
    @Test
    void getAutoLottosTest() {
        PurchaseCalculator purchaseCalculator = new PurchaseCalculator(14000);
        int purchasedLottoCount = purchaseCalculator.getPurchasableLottoCounts();
        Lottos lottos = LottoGenerator.makeAutoLottos(purchasedLottoCount);

        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(purchasedLottoCount);
    }
}
