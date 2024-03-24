package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConditionTest {
  @Test
  void 조건에_부합하는_결과에_true_반환() {
    Condition condition = new Condition(5, BonusBallCondition.DONT_CARE);
    assertThat(condition.accept(Result.of(5, false))).isTrue();
  }

  @Test
  void 조건에_부합하지_않으면_결과에_false_반환() {
    Condition condition = new Condition(4, BonusBallCondition.TRUE);
    assertThat(condition.accept(Result.of(4, false))).isFalse();
  }
}
