package lotto.model;

import lotto.enums.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryResultsTest {

    @Test
    @DisplayName("특정 등급의 결과를 테스트합니다.")
    void result() {
        LotteryResults.increase(Grade.SECOND);
        LotteryResults.increase(Grade.SECOND);
        LotteryResults.increase(Grade.FIRST);
        assertThat(LotteryResults.result()).containsEntry(Grade.SECOND, 2);
    }
}