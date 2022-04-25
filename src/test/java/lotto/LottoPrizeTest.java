package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LottoPrizeTest {

  private static final int MATCHED_LOTTO_COUNT = 1;
  private static Lotto winningLotto;
  private static LottoList lottoList;

  @BeforeAll
  static void setup() {
    winningLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    Lotto lottoMatched6 = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    Lotto lottoMatched5 = new Lotto(Set.of(1, 2, 3, 4, 5, 16));
    Lotto lottoMatched4 = new Lotto(Set.of(1, 2, 3, 4, 15, 16));
    Lotto lottoMatched3 = new Lotto(Set.of(1, 2, 3, 14, 15, 16));
    Lotto lottoMatched2 = new Lotto(Set.of(1, 2, 13, 14, 15, 16));
    Lotto lottoMatched1 = new Lotto(Set.of(1, 12, 13, 14, 15, 16));

    lottoList = new LottoList(List.of(
        lottoMatched1, lottoMatched2, lottoMatched3, lottoMatched4, lottoMatched5, lottoMatched6));
  }

  @Test
  void getMatchedLottoCount_성공() {

    Arrays.stream(LottoPrize.values())
        .map(lottoPrize -> lottoPrize.getMatchedLottoCount(winningLotto, lottoList))
        .forEach(matchedLottoCount -> assertThat(matchedLottoCount).isEqualTo(MATCHED_LOTTO_COUNT));
  }

  @Test
  void getRevenue_성공() {
    Arrays.stream(LottoPrize.values())
        .forEach(lottoPrize -> {
          int matchedLottoCount = lottoPrize.getMatchedLottoCount(winningLotto, lottoList);
          int revenue = lottoPrize.getRevenue(matchedLottoCount);
          assertThat(revenue).isEqualTo(lottoPrize.getRevenue(MATCHED_LOTTO_COUNT));
        });
  }
}
