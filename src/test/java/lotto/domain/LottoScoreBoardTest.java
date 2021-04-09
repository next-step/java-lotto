package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoScoreBoardTest {

  private static final List<LottoRank> lottoRankList = new ArrayList<>();

  @BeforeEach
  public void setUp() {
    lottoRankList.clear();
    lottoRankList.add(LottoRank.FIFTH);
    lottoRankList.add(LottoRank.FOURTH);
  }

  @Test
  @DisplayName("제대로 생성이 되는가")
  public void create() {
    //given
    Money money = new Money(14000);
    LottoRanks lottoRanks = new LottoRanks(lottoRankList);
    //when
    LottoScoreBoard lottoResult = LottoScoreBoard.createLottoResult(money, lottoRanks);

    //then
    assertAll(
        () -> assertTrue(lottoResult.toResultString().contains("3개 일치 (5000원) - 1개")),
        () -> assertTrue(lottoResult.toResultString().contains("4개 일치 (50000원) - 1개"))
    );
  }

  @Test
  @DisplayName("매치된 로또의 총 수익률을 구할 수 있는가")
  public void validateTotalEarningRate() throws Exception {
    //given
    Money money = new Money(14000);
    LottoRanks lottoRanks = new LottoRanks(lottoRankList);
    LottoScoreBoard lottoResult = LottoScoreBoard.createLottoResult(money, lottoRanks);

    //when
    double earningRate = lottoResult.totalEarningRate();
    DecimalFormat df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.DOWN);

    //then
    assertEquals(Double.valueOf(df.format(earningRate)), 3.92);
  }
}