package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoMachineTest {

        @Test
        void 구입금액이_1000원_미만인_경우_에러() {
                long purchaseAmount = 500;
                assertThatThrownBy(() -> new LottoMachine().buy(purchaseAmount)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("1000원 이상 입력하셔야합니다. (로또 장당 1000원)");
        }

        @Test
        void 구입금액이_14000원일_경우_14장_티켓_반환() {
                long purchaseAmount = 14_000;
                LottoMachine lottoMachine = new LottoMachine();
                assertThat(lottoMachine.buy(purchaseAmount).size()).isEqualTo(14);
        }
}
