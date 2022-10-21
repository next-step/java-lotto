package lottoGame.model;

import lottoGame.RankResult;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.lotto.WinningLotto;
import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import lottoGame.model.strategy.TestShuffleStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.as;
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
                        new DefaultLottoNumber(6))))
        );
    }

    @ParameterizedTest
    @MethodSource("provideIntInput")
    void create(WinningLotto lotto) {

        Lottery lottery = new Lottery();
        lottery.create(2, testShuffleStrategy);

        assertAll(
                () -> assertThat(lottery.countAllLotto()).isEqualTo(2),
                () -> assertThat(lottery.createRankResult(lotto)).isExactlyInstanceOf(RankResult.class));
    }

    @ParameterizedTest
    @MethodSource("provideIntInput")
    void createRankResult(WinningLotto lotto) {
        RankResult testResult = new RankResult();
        List<Integer> matchNum = List.of(6);
        testResult.putResult(matchNum);
        Lottery lottery = new Lottery();
        lottery.create(1, testShuffleStrategy);
        assertThat(lottery.createRankResult(lotto).getLotteryBoard()).isEqualTo(testResult.getLotteryBoard());
    }

}