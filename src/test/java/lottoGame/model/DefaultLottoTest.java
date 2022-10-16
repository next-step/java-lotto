package lottoGame.model;

import lottoGame.model.factory.DefaultLottoFactory;
import lottoGame.model.factory.TestLottoFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefaultLottoTest {

    @Test
    void isContain() {
        List<Integer> winnerNum = List.of(1, 2, 3, 4, 5, 6);
        TestLottoFactory testLottoStrategy = new TestLottoFactory();
        DefaultLotto lotto = testLottoStrategy.createLotto();
        assertEquals(lotto.isContain(winnerNum), 6);
    }
}