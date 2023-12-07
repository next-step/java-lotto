package lotto;

import lotto.enums.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

  @Test
  @DisplayName("매칭 숫자로 LottoResultType 찾기")
  public void find_type_by_number() {
    //given
    int number = 3;

    // when
    Rank rank = Rank.valueOf(number);

    // then
    Assertions.assertThat(rank).isEqualTo(Rank.THREE);
  }

}
