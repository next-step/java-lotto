package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoScoreBoardTest {

  private static final List<LottoRank> lottoRanks = new ArrayList<>();

  @BeforeEach
  public void setUp() {
    lottoRanks.clear();
    lottoRanks.add(LottoRank.FIFTH);
    lottoRanks.add(LottoRank.FOURTH);
  }

  @Test
  @DisplayName("제대로 생성이 되는가")
  public void create() {
    //given
    //when
    LottoScoreBoard lottoResult = LottoScoreBoard.createLottoResult(lottoRanks, new Money(1000));

    //then
    assertAll(
        () -> assertNotNull(lottoResult.getMatchResultMap().get("FIFTH")),
        () -> assertNotNull(lottoResult.getMatchResultMap().get("FOURTH"))
    );
  }

  @Test
  @DisplayName("매치된 로또의 총 수익률을 검증 할 수 있는가")
  public void validateTotalEarningRate() throws Exception {
    //given
    LottoScoreBoard lottoResult = LottoScoreBoard.createLottoResult(lottoRanks, new Money(1000));

    //when
    double earningRate = lottoResult.getEarningRate();
    DecimalFormat df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.DOWN);

    //then
    assertEquals(earningRate, 55);
  }
}