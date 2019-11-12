package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottosTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:14000"}, delimiter = ':')
    @DisplayName("당첨 통계 테스트")
    void matchTest(String winngLottoNumbers, int inputMoney) {
        UserLottos userLottos = new UserLottos(new Money(inputMoney));
        userLottos.match(WinningLotto.ofComma(winngLottoNumbers));
        assertThat(userLottos.getRate(inputMoney)).isGreaterThanOrEqualTo(0);
    }
}
