package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoMachineTest {

        @Test
        void 구입금액이_1000원_미만인_경우_에러() {
                assertThatThrownBy(() -> new PurchaseAmount(500)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("1000원 이상 입력하셔야합니다. (로또 장당 1000원)");
        }

        @Test
        void 구입금액이_14000원일_경우_14장_티켓_반환() {
                LottoMachine lottoMachine = new LottoMachine();
                PurchaseAmount purchaseAmount = new PurchaseAmount(14_000);
                assertThat(lottoMachine.buy(purchaseAmount)).hasSize(14);
        }
}
