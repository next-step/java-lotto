package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.enums.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryResultTest {

  @Test
  @DisplayName("특정 등급의 결과를 테스트합니다.")
  void result() {
    LotteryResult.increase(Grade.SECOND);
    LotteryResult.increase(Grade.SECOND);
    LotteryResult.increase(Grade.FIRST);
    assertThat(LotteryResult.result()).containsEntry(Grade.SECOND, 2);
  }
}