package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

        @Test
        void 구입금액_14000원으로_자동만_구입할_경우_자동만_14장_티켓_반환() {
                LottoMachine lottoMachine = new LottoMachine();
                PurchaseAmount purchaseAmount = PurchaseAmount.createPurchaseAmount(14_000);
                List<LottoNumbers> manualLottoNumbers = new ArrayList<>();

                assertThat(lottoMachine.buyTickets(purchaseAmount, manualLottoNumbers).getCountOfTickets()).isEqualTo(
                    14);
        }

        @Test
        void 구입금액_14000원으로_수동과_자동_구입할_경우_수동과_자동_도합_14장_티켓_반환() {
                LottoMachine lottoMachine = new LottoMachine();
                PurchaseAmount purchaseAmount = PurchaseAmount.createPurchaseAmount(14_000);
                List<LottoNumbers> manualLottoNumbers = List.of(new LottoNumbers(1, 2, 3, 4, 5, 6));

                assertThat(lottoMachine.buyTickets(purchaseAmount, manualLottoNumbers)
                    .getCountOfTickets()).isEqualTo(14);
        }
}
