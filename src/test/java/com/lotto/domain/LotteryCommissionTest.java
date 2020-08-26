package com.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class LotteryCommissionTest {

    private LotteryCommission lotteryCommission;

    @BeforeEach
    void setUp() {
        lotteryCommission = new LotteryCommission();
    }

    @ParameterizedTest
    @DisplayName("금액에 따른 복권 개수 확인")
    @CsvSource(value = {"0:0", "1000:1", "2500:2", "14000:14"}, delimiter = ':')
    void publishLotteries(int amount, int expected) {
        then(lotteryCommission.publishLotteries(new Deposit(amount)).size()).isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("당첨 통계 검증")
    @CsvSource(value = {
            "1:2:3:4:5:6:0:0:0:1",
            "1:2:3:4:5:7:0:0:1:0",
            "1:2:3:4:7:8:0:1:0:0",
            "1:2:3:7:8:9:1:0:0:0",
    }, delimiter = ':')
    void calculateWinningStatistics(int num1, int num2, int num3, int num4, int num5, int num6,
                                    int expected1, int expected2, int expected3, int expected4) {
        Lottery left = new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottery right = new Lottery(Arrays.asList(num1, num2, num3, num4, num5, num6));
        List<int[]> statistics = lotteryCommission.calculateWinningStatistics(Collections.singletonList(left), right);
        int[][] target = statistics.toArray(new int[3][statistics.size()]);

        then(target[0][LotteryCommission.LOTTERY_COUNT_INDEX]).isEqualTo(expected1);
        then(target[1][LotteryCommission.LOTTERY_COUNT_INDEX]).isEqualTo(expected2);
        then(target[2][LotteryCommission.LOTTERY_COUNT_INDEX]).isEqualTo(expected3);
        then(target[3][LotteryCommission.LOTTERY_COUNT_INDEX]).isEqualTo(expected4);
    }
}
