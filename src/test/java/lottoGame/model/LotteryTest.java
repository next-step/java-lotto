package lottoGame.model;

import lottoGame.Rank;
import lottoGame.RankResult;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.lotto.Lotto;
import lottoGame.model.lotto.WinningLotto;
import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import lottoGame.model.strategy.SecondStrategy;
import lottoGame.model.strategy.TestShuffleStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {
    private final TestShuffleStrategy testShuffleStrategy = new TestShuffleStrategy();

    private static Stream<Arguments> provideIntInput() {
        return Stream.of(
                Arguments.of(new WinningLotto(List.of(
                        new DefaultLottoNumber(1),
                        new DefaultLottoNumber(2),
                        new DefaultLottoNumber(3),
                        new DefaultLottoNumber(4),
                        new DefaultLottoNumber(5),
                        new DefaultLottoNumber(6)), new DefaultLottoNumber(7)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideIntInput")
    void create() {
        Lotto lotto1 = new Lotto(List.of(
                new DefaultLottoNumber(1),
                new DefaultLottoNumber(2),
                new DefaultLottoNumber(3),
                new DefaultLottoNumber(4),
                new DefaultLottoNumber(5),
                new DefaultLottoNumber(6)));
        Lottery lottery = new Lottery();
        lottery.create(2, testShuffleStrategy);

        assertAll(
                () -> assertThat(lottery.countAllLotto()).isEqualTo(2),
                () -> assertThat(lottery.getLottery()).contains(lotto1));
    }

    @ParameterizedTest
    @MethodSource("provideIntInput")
    void find_bonus(WinningLotto lotto) {
        Lotto lotto1 = new Lotto(List.of(
                new DefaultLottoNumber(1),
                new DefaultLottoNumber(2),
                new DefaultLottoNumber(3),
                new DefaultLottoNumber(4),
                new DefaultLottoNumber(5),
                new DefaultLottoNumber(7)));
        Lottery lottery = new Lottery();
        lottery.create(1, new SecondStrategy());
        RankResult rankResult = lottery.createRankResult(lotto, new RankResult());
        System.out.println(rankResult.getLotteryBoard());
    }

    @ParameterizedTest
    @MethodSource("provideIntInput")
    void createRankResult(WinningLotto lotto) {
        RankResult testResult = new RankResult();
        List<Rank> matchNum = List.of(Rank.FIRST);
        testResult.putResult(matchNum);
        Lottery lottery = new Lottery();
        lottery.create(1, testShuffleStrategy);
        assertThat(lottery.createRankResult(lotto,new RankResult()).getLotteryBoard()).isEqualTo(testResult.getLotteryBoard());
    }

}