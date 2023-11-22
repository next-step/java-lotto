package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

        @Test
        void 구입금액_14000원으로_자동만_구입할_경우_자동만_14장_티켓_반환() {
                LottoMachine lottoMachine = new LottoMachine();
                PurchaseAmount purchaseAmount = PurchaseAmount.createPurchaseAmountOfScanned(14_000);

                assertThat(lottoMachine.buyOnlyAutoTickets(purchaseAmount).getCountOfTickets()).isEqualTo(14);
        }

        @Test
        void 구입금액_14000원으로_자동만_구입할_경우_자동과_수동_도합_14장_티켓_반환() {
                LottoMachine lottoMachine = new LottoMachine();
                List<LottoNumbers> manualLottoNumbers = List.of(new LottoNumbers(1, 2, 3, 4, 5, 6));
                PurchaseAmount purchaseAmount = PurchaseAmount.createPurchaseAmountOfScanned(14_000);
                
                assertThat(lottoMachine.buyAutoAndManualTickets(purchaseAmount, manualLottoNumbers)
                    .getCountOfTickets()).isEqualTo(14);
        }
}
