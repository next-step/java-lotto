package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 로또번호는_45개() {
        assertThat(LottoMachine.size()).isEqualTo(45);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    void 천원미만_구매요청시_빈_로또종이를_반환한다(int given) {
        assertThat(LottoMachine.purchase(given))
                .isEqualTo(LottoMachine.EMPTY_LOTTO_PAPER);
    }

    @Test
    void 천원이상_구매요청시_로또종이를_생성하여_반환한다() {
        int given = 1000;
        assertThat(LottoMachine.purchase(given))
                .isNotNull()
                .isInstanceOf(LottoPaper.class);
    }
}
