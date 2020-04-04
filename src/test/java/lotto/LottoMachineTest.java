package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.ManualLottoOrderSheet;
import lotto.domain.Money;
import lotto.domain.PurchaseResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("로또기계 생성 테스트")
    void createLottoMachineTest() {
        new LottoMachine();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 9})
    @DisplayName("로또기계로 돈만큼 자동 로또 구매 테스트")
    void purchaseManualLottosTest(int input) {
        PurchaseResult purchaseResult = new LottoMachine().purchaseAutomaticLottos(new Money(input * 1000));
        assertThat(
                purchaseResult.getPurchasedLottos().size()
        ).isEqualTo(input);
    }

    @Test
    @DisplayName("로또기계로 돈만큼 수동 로또 구매 테스트")
    void purchaseAutomaticLottosTest() {
        PurchaseResult purchaseResult = new LottoMachine().purchaseManualLottos(
                new Money(3000), new ManualLottoOrderSheet(Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6"))
        );

        assertThat(
                purchaseResult.getPurchasedLottos().size()
        ).isEqualTo(3);
    }
}
