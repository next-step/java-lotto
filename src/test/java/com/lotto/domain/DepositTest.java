package com.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.BDDAssertions.then;

class DepositTest {

    @ParameterizedTest
    @DisplayName("금액에 따른 복권 구입 개수 확인")
    @CsvSource(value = {"0:0", "1000:1", "2500:2", "14000:14"}, delimiter = ':')
    void purchaseLottery(int amount, int expected) {
        then(new Deposit(amount).purchaseLottery()).isEqualTo(expected);
    }
}
