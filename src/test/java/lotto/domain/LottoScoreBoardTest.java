package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoScoreBoardTest {

  private static final List<LottoRank> lottoRanks = new ArrayList<>();

  @BeforeEach
  public void setUp() {
    lottoRanks.add(LottoRank.FIFTH);
    lottoRanks.add(LottoRank.FOURTH);
    lottoRanks.add(LottoRank.THIRD);
    lottoRanks.add(LottoRank.SECOND);
    lottoRanks.add(LottoRank.FIRST);
  }

  @ParameterizedTest
  @CsvSource({"3, FIFTH", "4, FOURTH", "5, THIRD", "6, FIRST"})
  @DisplayName("구매한 로또 쿠폰에 대한 올바른 당첨 결과에 대한 검증을 제대로 하는가")
  public void validateWinLotto(int winner, String key) throws Exception {
    //given
    LottoScoreBoard lottoResult = LottoScoreBoard.createLottoResult(lottoRanks, new Money(1000));

    //when
    Map<String, Integer> winningBoard = lottoResult.getMatchResultMap();

    //then
    assertEquals((int) winningBoard.get(key), 1);
  }
}