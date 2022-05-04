package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.Test;

class AwardNumberUtilTest {

  @Test
  void getAwadNumberList() {
    assertThat(AwardNumberUtil.getAwardNumberList("1, 2, 4, 5")).contains(1,2,4,5);
  }
}