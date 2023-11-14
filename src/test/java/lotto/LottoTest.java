package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

class LottoTest {

        @Test
        void 구입금액이_1000원_미만인_경우_에러() {
                long purchaseAmount = 500;
                assertThatThrownBy(() -> new Lotto(purchaseAmount)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("1000원 이상 입력하셔야합니다. (로또 장당 1000원)");
        }

}
