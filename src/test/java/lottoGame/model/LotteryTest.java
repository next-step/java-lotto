package lottoGame.model;

import lottoGame.model.factory.TestLottoFactory;
import lottoGame.model.strategy.TestLottoStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {
    private final TestLottoFactory testLottoFactory = new TestLottoFactory();

    @Test
    void create() {
        TestLottoFactory testLottoFactory = new TestLottoFactory();
        DefaultLotto lotto = testLottoFactory.createLotto();

        Lottery lottery = new Lottery(testLottoFactory);
        List<Lotto> actual = lottery.create(2);

        assertAll(
                () -> assertThat(actual).hasSize(2),
                () -> assertThat(actual).contains(lotto));
    }

    @Test
    void calculateWinning3() {
        List<Integer> winningNumer = List.of(1, 2, 3, 43, 44, 45);
        Lottery lottery = new Lottery(testLottoFactory);
        lottery.create(1);
        assertEquals(lottery.calculate(winningNumer), 5000);
    }

    @Test
    void calculateWinning4() {
        List<Integer> winningNumer = List.of(1, 2, 3, 4, 44, 45);
        Lottery lottery = new Lottery(testLottoFactory);
        lottery.create(1);
        assertEquals(lottery.calculate(winningNumer), 50000);
    }

    @Test
    void calculateWinning5() {
        List<Integer> winningNumer = List.of(1, 2, 3, 4, 5, 45);
        Lottery lottery = new Lottery(testLottoFactory);
        lottery.create(1);
        assertEquals(lottery.calculate(winningNumer), 1500000);
    }

    @Test
    void calculateWinning6() {
        List<Integer> winningNumer = List.of(1, 2, 3, 4, 5, 6);
        Lottery lottery = new Lottery(testLottoFactory);
        lottery.create(1);
        assertEquals(lottery.calculate(winningNumer), 2000000000);
    }
}