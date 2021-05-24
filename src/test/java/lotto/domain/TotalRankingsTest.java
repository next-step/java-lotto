package lotto.domain;

import lotto.dto.RankingPrizedCount;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
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
    //given
    List<RankingPrizedCount> expectation = Arrays.stream(LottoRanking.values())
        .filter(lottoRanking -> lottoRanking != LottoRanking.NONE)
        .map(lottoRanking -> new RankingPrizedCount(lottoRanking, lottoRanking == given ? 1 : 0))
        .collect(Collectors.toList());

    //when & then
    assertThat(new TotalRankings(Lists.newArrayList(given)).createPrizeInfos()).isEqualTo(expectation);
  }
}
