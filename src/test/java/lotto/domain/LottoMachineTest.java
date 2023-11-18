package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoMachineTest {

        @Test
        void 구입금액이_1000원_미만인_경우_에러() {
                long purchaseAmount = 500;
                assertThatThrownBy(() -> new LottoMachine().buy(purchaseAmount)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("1000원 이상 입력하셔야합니다. (로또 장당 1000원)");
        }
}
