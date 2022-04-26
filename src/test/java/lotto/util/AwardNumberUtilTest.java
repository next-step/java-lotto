package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class AwardNumberUtilTest {

  @Test
  void getAwadNumberList() {
    assertThat(AwardNumberUtil.getAwadNumberList("1,2,4")).isEqualTo(List.of(1, 2, 4));
  }
}