package lotto.domain;

import lotto.dto.PrizeInfo;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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

  @DisplayName("출력용 당첨 결과 DTO 목록을 반환한다.")
  @ParameterizedTest
  @EnumSource(value = LottoRanking.class, names = {"NONE"}, mode = EnumSource.Mode.EXCLUDE)
  void createPrizeInfos(LottoRanking given) {
    assertThat(new TotalRankings(Lists.newArrayList(given)).createPrizeInfos()).isEqualTo(Lists.newArrayList(new PrizeInfo(given, 1)));
  }

  @DisplayName("출력용 당첨 결과 DTO 목록을 반환할 때 NONE이 포함된 결과는 제외하고 반환한다.")
  @ParameterizedTest
  @EnumSource(value = LottoRanking.class, names = {"NONE"}, mode = EnumSource.Mode.INCLUDE)
  void createPrizeInfosExcludeNone(LottoRanking given) {
    assertThat(new TotalRankings(Lists.newArrayList(given)).createPrizeInfos()).isEmpty();
  }

}
