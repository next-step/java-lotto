package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTest {

    private Lotto lotto = new Lotto();

    @Test
    void getResult() {
        Integer[] winningNumbers = lotto.getTicket().toArray(new Integer[6]);
        Assertions.assertEquals(6, lotto.getResult(winningNumbers));
    }
}
