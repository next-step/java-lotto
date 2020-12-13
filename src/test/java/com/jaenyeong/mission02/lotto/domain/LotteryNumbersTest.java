package com.jaenyeong.mission02.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Lotto 게임에 복권 번호 리스트의 래핑 객체(일급 컬렉션) LotteryNumbers 클래스 테스트")
class LotteryNumbersTest {

    @Test
    void createLotteryNumbers() {
        final LotteryNumbers lotteryNumbers = new LotteryNumbers();

        final List<Integer> lottery = lotteryNumbers.getLotteryNumbers();

        final int max = 6;
        final int start = 1;
        final int end = 45;

        assertEquals(lottery.size(), max);

        lottery.forEach((lotteryNumber) ->
            assertThat(lotteryNumber).isBetween(start, end));
    }
}
