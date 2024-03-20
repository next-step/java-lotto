package lotto.model;

import lotto.dto.OrderRequest;
import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    void 천원미만_구매요청시_빈_로또종이를_반환한다(int given) {
        assertThatThrownBy(() -> LottoMachine.purchase(new OrderRequest(new Money(given), Collections.emptyList())))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 천원이상_구매요청시_로또종이를_생성하여_반환한다() {
        int given = 1000;
        assertThat(LottoMachine.purchase(new OrderRequest(new Money(given), Collections.emptyList())))
                .isNotNull()
                .isInstanceOf(LottoPaper.class);
    }
}
