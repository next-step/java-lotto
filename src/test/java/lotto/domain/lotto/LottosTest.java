package lotto.domain.lotto;

import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.WinningNumbers;
import lotto.domain.lotto.strategy.LottoGeneratingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    LottoGeneratingStrategy lottoGeneratingStrategyStub = () -> Lotto.valueOf(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("purchaseLotto(): 입력된 구입금액으로 살 수 있는 만큼 로또를 생성한다.")
    void testPurchaseLotto() {
        PurchaseAmountOfMoney purchaseAmountOfMoney = PurchaseAmountOfMoney.valueOf("1000");
        Lottos lottos = Lottos.valueOf(purchaseAmountOfMoney);
        lottos.purchaseLotto(lottoGeneratingStrategyStub);

        assertThat(lottos.lottos().size()).isEqualTo(purchaseAmountOfMoney.numberOfLottoToPurchase());
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 7, 8, 9:3:5", "1, 2, 3, 4, 8, 9:4:50", "1, 2, 3, 4, 5, 9:5:1500", "1, 2, 3, 4, 5, 6:6:2000000"}, delimiter = ':')
    @DisplayName("result(): 로또의 결과(당첨 통계, 수익률)를 반환합니다.")
    void testResult(String winningNumberInput, int matchCount, double expectedRateOfReturn) {
        PurchaseAmountOfMoney purchaseAmountOfMoney = PurchaseAmountOfMoney.valueOf("1000");
        Lottos lottos = Lottos.valueOf(purchaseAmountOfMoney);
        lottos.purchaseLotto(lottoGeneratingStrategyStub);

        WinningNumbers winningNumbers = WinningNumbers.valueOf(winningNumberInput);
        ResultOfLottos lottoResult = lottos.result(winningNumbers);

        assertThat(lottoResult.winningStatic(matchCount)).isEqualTo(1);
        assertThat(lottoResult.rateOfReturn()).isEqualTo(expectedRateOfReturn);
    }
}