package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.exception.LottoSizeException;
import lotto.exception.MoneyNumberException;
import lotto.util.AwardNumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuestTest {

  @Test
  @DisplayName("1000원이하의 돈으로 로또를 구입 할 수 없습니다.")
  void lottoEmptySizeTest() {
    assertThrows(MoneyNumberException.class, () -> {
      Guest guest = new Guest(999);
    });
  }

}
