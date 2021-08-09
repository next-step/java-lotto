package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoListGeneratorTest {

    @Test
    void creatLottos() {
        int ticketNumber = 3;
        List<Lotto> lottos = LottoListGenerator.creatLottos(ticketNumber);
        assertEquals(lottos.size(), ticketNumber);
    }
}