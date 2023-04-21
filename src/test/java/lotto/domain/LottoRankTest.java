package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class LottoRankTest {

  @Test
  @DisplayName("로또 일치 개수 리스트 반환 테스트")
  public void create_로또_일치_개수_리스트() {
    assertThat(LottoRank.lottoMatchedNumberList()).contains(3, 4, 5, 6);
  }

  @ParameterizedTest(name = "일치하는 개수에 따라 상금 반환 테스트")
  @CsvSource(value =  {"6:2_000_000_000", "5:1_500_000", "4:50_000", "3:5_000", "2:0", "1:0", "0:0"}, delimiter = ':')
  public void 일치하는_개수에_따른_상금_반환(int input, int expected) {
    LottoRank lottoRank = LottoRank.valueOfMatchedCount(input);

    assertThat(LottoRank.prizeMoney(lottoRank)).isEqualTo(expected);
  }
}
