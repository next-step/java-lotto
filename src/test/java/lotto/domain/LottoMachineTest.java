package lotto.domain;

import lotto.domain.strategy.RandomLottoNumberStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoMachineTest {

    @Test
    void 로또번호를_1000원_단위로_살_수_있다() {
        assertDoesNotThrow(() -> new LottoMachine(new RandomLottoNumberStrategy(), 14000));
    }

    @Test
    void 로또번호를_1000원_단위로_살_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> new LottoMachine(new RandomLottoNumberStrategy(), 14500));
    }

}
