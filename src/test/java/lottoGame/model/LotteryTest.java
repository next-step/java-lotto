package lottoGame.model;

import lottoGame.WinningRanks;
import lottoGame.model.factory.TestLottoFactory;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {
    private final TestLottoFactory testLottoFactory = new TestLottoFactory();
    private final EnumMap<WinningRanks, Integer> lotteryBoard = new EnumMap<>(WinningRanks.class);

    @Test
    void create() {
        TestLottoFactory testLottoFactory = new TestLottoFactory();
        DefaultLotto lotto = testLottoFactory.createLotto();

        Lottery lottery = new Lottery();
        List<Lotto> actual = lottery.create(2,testLottoFactory);

        assertAll(
                () -> assertThat(actual).hasSize(2),
                () -> assertThat(actual).contains(lotto));
    }

}