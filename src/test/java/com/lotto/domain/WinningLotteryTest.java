package com.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

class WinningLotteryTest {

    private static Stream<Arguments> provideMatchRankArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6}, 45, Rank.FIRST),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 7}, 6, Rank.SECOND),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 7}, 45, Rank.THIRD),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 7, 8}, 45, Rank.FORTH),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 7, 8, 9}, 45, Rank.Fifth),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 7, 8, 9, 10}, 45, Rank.LOSER)
        );
    }

    @ParameterizedTest
    @MethodSource("provideMatchRankArguments")
    @DisplayName("당첨 복권과 비교하여 등수를 반환하는 메소드 검증")
    void matchRank(int[] numbers, int[] winningNumbers, int bonusNumber, Rank expected) {
        Set<LotteryNumber> lotteryNumbers = Arrays.stream(numbers)
                .mapToObj(LotteryNumber::getLotteryNumber)
                .collect(Collectors.toSet());
        Set<LotteryNumber> winningLotteryNumbers = Arrays.stream(winningNumbers)
                .mapToObj(LotteryNumber::getLotteryNumber)
                .collect(Collectors.toSet());
        LotteryNumber bonusLotteryNumber = LotteryNumber.getLotteryNumber(bonusNumber);
        Lottery lottery = new Lottery(lotteryNumbers);
        WinningLottery winningLottery = new WinningLottery(winningLotteryNumbers, bonusLotteryNumber);

        then(winningLottery.matchRank(lottery)).isEqualTo(expected);
    }
}
