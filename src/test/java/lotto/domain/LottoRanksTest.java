package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRanksTest {

  private static final List<LottoRank> lottoRankList = new ArrayList<>();

  @BeforeAll
  static void setUp() {
    lottoRankList.add(LottoRank.FIFTH);
    lottoRankList.add(LottoRank.FOURTH);
    lottoRankList.add(LottoRank.THIRD);
    lottoRankList.add(LottoRank.SECOND);
    lottoRankList.add(LottoRank.FIRST);
  }

  @ParameterizedTest
  @CsvSource({"FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH"})
  @DisplayName("매칭 결과를 얻을 수 있는가")
  public void getMatchResult(LottoRank value) throws Exception {
    //given
    LottoRanks lottoRanks = new LottoRanks(lottoRankList);
    //when
    Map<LottoRank, Long> matchResult = lottoRanks.getMatchResult();

    //then
    assertTrue(matchResult.containsKey(value));
  }

  @ParameterizedTest
  @CsvSource({"FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH"})
  public void getMatchCountTest(LottoRank value) throws Exception {
    //given
    LottoRanks lottoRanks = new LottoRanks(lottoRankList);
    //when
    Long count = lottoRanks.toStringMatchCount(value);

    //then
    assertEquals(count, 1L);
  }
}