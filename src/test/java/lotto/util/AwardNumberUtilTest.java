package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import lotto.model.LottoNo;
import org.junit.jupiter.api.Test;

class AwardNumberUtilTest {

  @Test
  void getAwadNumberList() {
    assertThat(AwardNumberUtil.getAwadNumberList("1, 2, 4, 5")).contains(
        new LottoNo(1),
        new LottoNo(2),
        new LottoNo(4),
        new LottoNo(5));
  }
}