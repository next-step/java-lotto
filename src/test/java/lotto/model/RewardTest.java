package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lotto.enums.Grade;
import lotto.util.AwardNumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardTest {

  @Test
  @DisplayName("당첨 번호가 몇개 일치 하는지 확인")
  void awardCount() {
    assertThat(AwardNumberUtil.matchCount(Set.of(1, 2, 3, 4, 5, 6), Set.of(1, 2, 3, 9, 10, 20)))
        .isEqualTo(3);
  }

}