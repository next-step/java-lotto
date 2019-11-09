package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"1001:1", "3500:3", "7900:7", "13400:13"}, delimiter = ':')
    @DisplayName("입력한 금액으로 구입가능한 로또 수 테스트")
    void numberOfLottoPurchasedTest(int inputMoney, int result) {
        Money money = new Money(inputMoney);
        assertThat(money.numberOfLottoPurchased()).isEqualTo(result);
    }
}