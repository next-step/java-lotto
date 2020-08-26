package com.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
