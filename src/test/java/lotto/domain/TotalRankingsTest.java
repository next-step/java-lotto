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

  @DisplayName("특정 등수에 몇 번 당첨 당첨되었는지 알수 있는 목록을 반환한다.")
  @ParameterizedTest
  @EnumSource(value = LottoRanking.class, names = {"NONE"}, mode = EnumSource.Mode.EXCLUDE)
  void createPrizeInfos(LottoRanking given) {
    assertThat(new TotalRankings(Lists.newArrayList(given)).createPrizeInfos()).isEqualTo(Lists.newArrayList(new PrizeInfo(given, 1)));
  }

  @DisplayName("특정 등수에 몇 번 당첨 당첨되었는지 알수 있는 목록을 반환할 때 의미없는 등수는 반환하지 않는다.")
  @ParameterizedTest
  @EnumSource(value = LottoRanking.class, names = {"NONE"}, mode = EnumSource.Mode.INCLUDE)
  void createPrizeInfosExcludeNone(LottoRanking given) {
    assertThat(new TotalRankings(Lists.newArrayList(given)).createPrizeInfos()).isEmpty();
  }

}
