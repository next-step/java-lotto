package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.core.Lotto;
import study.lotto.dispenser.LottoDispenser;
import study.lotto.dispenser.Lottos;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoDispenserTest {

    @Test
    @DisplayName("로또(자동) 판매 테스트")
    void test_auto() {
        // When
        Lottos lottos = LottoDispenser.auto(10);

        // Then
        assertEquals(lottos.getTotalCount(), 10);
    }
}