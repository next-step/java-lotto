package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import step2.constant.Prize;
import step2.model.Lotteries;

class WinningTest {

    @ParameterizedTest
    @MethodSource("generateData")
    void 등수를_구하는_테스트(Lotteries lotteries, Prize prize) {
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6));
        List<Prize> pirzeList = winning.getPirzeList(lotteries);

        assertThat(pirzeList.contains(prize)).isEqualTo(true);
    }

    static Stream<Arguments> generateData() {
        Set<Integer> first = new HashSet<>();
        for (int i = 1; i < 7; i++) {
            first.add(i);
        }

        Set<Integer> third = new HashSet<>();
        for (int i = 2; i < 8; i++) {
            third.add(i);
        }

        Set<Integer> fourth = new HashSet<>();
        for (int i = 3; i < 9; i++) {
            fourth.add(i);
        }

        Set<Integer> fifth = new HashSet<>();
        for (int i = 4; i < 10; i++) {
            fifth.add(i);
        }

        Lotteries firstLotteries = new Lotteries();
        Lotteries thirdLotteries = new Lotteries();
        Lotteries fourthLotteries = new Lotteries();
        Lotteries fifthLotteries = new Lotteries();
        firstLotteries.keep(Lottery.of(first));
        thirdLotteries.keep(Lottery.of(third));
        fourthLotteries.keep(Lottery.of(fourth));
        fifthLotteries.keep(Lottery.of(fifth));

        return Stream.of(Arguments.of(firstLotteries, Prize.FIRST),
                         Arguments.of(thirdLotteries, Prize.THIRD),
                         Arguments.of(fourthLotteries, Prize.FOURTH),
                         Arguments.of(fifthLotteries, Prize.FIFTH)
        );
    }
}
