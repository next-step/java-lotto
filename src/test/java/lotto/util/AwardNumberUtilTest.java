package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.Test;

class AwardNumberUtilTest {

  @Test
  void getAwadNumberList() {
    assertThat(AwardNumberUtil.getAwadNumberList("1, 2, 4, 5")).contains(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(4),
        new LottoNumber(5));
  }
}