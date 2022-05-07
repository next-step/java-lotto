package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import org.junit.jupiter.api.Test;

public class LottoListTest {

  private static final int REVENUE_RATE_SCALE = 2;

  private final Lotto lottoMatched6 = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
  private final Lotto lottoMatched5AndBonus = new Lotto(Set.of(1, 2, 3, 4, 5, 17));
  private final Lotto lottoMatched5 = new Lotto(Set.of(1, 2, 3, 4, 5, 16));
  private final Lotto lottoMatched4 = new Lotto(Set.of(1, 2, 3, 4, 15, 16));
  private final Lotto lottoMatched3 = new Lotto(Set.of(1, 2, 3, 14, 15, 16));
  private final Lotto lottoMatched2 = new Lotto(Set.of(1, 2, 13, 14, 15, 16));
  private final Lotto lottoMatched1 = new Lotto(Set.of(1, 12, 13, 14, 15, 16));
  private final LottoList lottoList = new LottoList(List.of(
      lottoMatched1,
      lottoMatched2,
      lottoMatched3,
      lottoMatched4,
      lottoMatched5,
      lottoMatched5AndBonus,
      lottoMatched6
  ));


  @Test
  void LottoList_생성_성공() {
    assertDoesNotThrow(() -> new LottoList(5));
  }

  @Test
  void LottoList_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new LottoList(0));
  }

  @Test
  void drawing_성공() {
    LottoNumber bonusNumber = new LottoNumber(17);
    WinningLotto winningLotto = new WinningLotto(lottoMatched6, bonusNumber);

    Map<LottoPrize, Integer> resultMap = new HashMap<>();
    resultMap.put(LottoPrize.SIX, 1);
    resultMap.put(LottoPrize.FIVE_AND_BONUS, 1);
    resultMap.put(LottoPrize.FIVE, 1);
    resultMap.put(LottoPrize.FOUR, 1);
    resultMap.put(LottoPrize.THREE, 1);
    resultMap.put(LottoPrize.NONE, 2);

    Result expected = new Result(resultMap);

    assertThat(lottoList.drawing(winningLotto)).isEqualTo(expected);
  }

  @Test
  void getTotalLottoCount_성공() {
    assertThat(lottoList.getTotalLottoCount()).isEqualTo(7);
  }

  @Test
  void getTotalPurchaseAmount_성공() {
    int lottoPrice = 1000;
    assertThat(lottoList.getTotalPurchaseAmount())
        .isEqualTo(lottoPrice * lottoList.getTotalLottoCount());
  }

  @Test
  void toStringForPrinting_성공() {
    String expected = new StringJoiner("\n")
        .add(lottoMatched1.toStringForPrinting())
        .add(lottoMatched2.toStringForPrinting())
        .add(lottoMatched3.toStringForPrinting())
        .add(lottoMatched4.toStringForPrinting())
        .add(lottoMatched5.toStringForPrinting())
        .add(lottoMatched5AndBonus.toStringForPrinting())
        .add(lottoMatched6.toStringForPrinting())
        .toString();

    assertThat(lottoList.toStringForPrinting()).isEqualTo(expected);
  }

  @Test
  void getRevenueRate_성공() {
    int totalRevenue = 2000;

    assertThat(lottoList.getRevenueRate(totalRevenue)).isEqualTo(BigDecimal.valueOf(totalRevenue)
        .divide(BigDecimal.valueOf(lottoList.getTotalLottoCount()), REVENUE_RATE_SCALE,
            RoundingMode.HALF_UP));
  }
}
