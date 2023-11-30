package lotto;

import lotto.enums.LottoResultType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTypeTest {

  @Test
  @DisplayName("")
  public void find_type_by_number() {
    //given
    int number = 3;

    // when
    LottoResultType lottoResultType = LottoResultType.valueOf(number);

    // then
    Assertions.assertThat(lottoResultType).isEqualTo(LottoResultType.THREE);
  }

}
