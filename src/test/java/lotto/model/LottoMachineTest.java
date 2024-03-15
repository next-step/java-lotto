package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("선택가능한 로또 번호는 45개가 있다")
    @Test
    void size() {
        assertThat(LottoMachine.size()).isEqualTo(45);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    void purchaseThrowException(int given) {
        assertThat(LottoMachine.purchase(given))
                .isEqualTo(LottoMachine.EMPTY_LOTTO_PAPER);
    }

    @Test
    void purchase() {
        int given = 1000;
        assertThat(LottoMachine.purchase(given))
                .isNotNull()
                .isInstanceOf(LottoPaper.class);
    }
}
