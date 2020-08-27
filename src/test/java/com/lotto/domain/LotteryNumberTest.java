package com.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class LotteryNumberTest {

    @Test
    @DisplayName("복권 숫자를 반환하는 메소드가 매번 동일한 인스턴스를 반환하는지 검증")
    void getLotteryNumber() {
        then(LotteryNumber.getLotteryNumber(1)).isEqualTo(LotteryNumber.getLotteryNumber("1"));
    }
}
