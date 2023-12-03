package lotto;

import lotto.enums.LottoResultType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTypeTest {

  @Test
  @DisplayName("매칭 숫자로 LottoResultType 찾기")
  public void find_type_by_number() {
    //given
    int number = 3;

    // when
    LottoResultType lottoResultType = LottoResultType.valueOf(number);

    // then
    Assertions.assertThat(lottoResultType).isEqualTo(LottoResultType.THREE);
  }


  @Test
  @DisplayName("결과 타입의 최대값 찾기")
  public void find_max_number() {

    // when
    int maxNumber = LottoResultType.findMaxNumber();
    // then
    Assertions.assertThat(maxNumber).isEqualTo(6);
  }

  @Test
  @DisplayName("최소값 찾기")
  public void find_min_number() {

    // when
    int minimumNumber = LottoResultType.findMinimumNumber();

    // then
    Assertions.assertThat(minimumNumber).isEqualTo(3);
  }

}
