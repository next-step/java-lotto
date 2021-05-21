package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class TotalRankingsTest {

  @DisplayName("객체 생성 & 동등성 테스트")
  @Test
  void constructionAndEqualityTest() {
    //given
    List<LottoRanking> given = Arrays.stream(LottoRanking.values())
        .collect(Collectors.toList());

    //when & then
    assertThat(new TotalRankings(given)).isEqualTo(new TotalRankings(given));
  }

}
