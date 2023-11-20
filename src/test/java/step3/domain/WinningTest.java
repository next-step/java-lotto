package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import step3.constant.Prize;
import step3.model.Lotteries;

class WinningTest {

    @ParameterizedTest
    @MethodSource("generateData")
    void 등수를_구하는_테스트(Lotteries lotteries, Prize prize) {
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6));
        winning.setBonusWinNumber("7");
        List<Prize> pirzeList = winning.getPrizes(lotteries);

        assertThat(pirzeList.contains(prize)).isEqualTo(true);
    }

    static Stream<Arguments> generateData() {
        Set<Integer> first = new HashSet<>(List.of(1, 2, 3, 4, 5, 6));
        Set<Integer> second = new HashSet<>(List.of(2, 3, 4, 5, 6, 7));
        Set<Integer> third = new HashSet<>(List.of(2, 3, 4, 5, 6, 10));
        Set<Integer> fourth = new HashSet<>(List.of(3, 4, 5, 6, 7, 8));
        Set<Integer> fifth = new HashSet<>(List.of(4, 5, 6, 7, 8, 9));

        Lotteries firstLotteries = new Lotteries();
        Lotteries thirdLotteries = new Lotteries();
        Lotteries secondLotteries = new Lotteries();
        Lotteries fourthLotteries = new Lotteries();
        Lotteries fifthLotteries = new Lotteries();

        firstLotteries.keep(Lottery.of(first));
        secondLotteries.keep(Lottery.of(second));
        thirdLotteries.keep(Lottery.of(third));
        fourthLotteries.keep(Lottery.of(fourth));
        fifthLotteries.keep(Lottery.of(fifth));

        return Stream.of(Arguments.of(firstLotteries, Prize.FIRST),
                         Arguments.of(secondLotteries, Prize.SECOND),
                         Arguments.of(thirdLotteries, Prize.THIRD),
                         Arguments.of(fourthLotteries, Prize.FOURTH),
                         Arguments.of(fifthLotteries, Prize.FIFTH)
        );
    }
}
