package lotto.model;

import lotto.dto.OrderRequest;
import lotto.dto.OrderResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    void 천원미만_구매요청시_빈_로또종이를_반환한다(int given) {
        assertThat(LottoMachine.purchase(new OrderRequest(given)))
                .isEqualTo(new OrderResponse(0, LottoMachine.EMPTY_LOTTO_PAPER));
    }

    @Test
    void 천원이상_구매요청시_로또종이를_생성하여_반환한다() {
        int given = 1000;
        assertThat(LottoMachine.purchase(new OrderRequest(given)))
                .isNotNull()
                .isInstanceOf(OrderResponse.class);
    }
}
