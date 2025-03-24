package lotto.type;

import lotto.property.LottoProperty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.type.LottoPrize.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoPrizeTest {

  @DisplayName("0개 일치 가져오기")
  @Test
  public void testGetZeroMatches() {
    assertThat(LottoPrize.findByMatchCount(0)).isEqualTo(LottoPrize.ZERO_MATCHES);
  }

  @DisplayName("1개 일치 가져오기")
  @Test
  public void testGetOneMatches() {
    assertThat(LottoPrize.findByMatchCount(1)).isEqualTo(LottoPrize.ONE_MATCHES);
  }

  @DisplayName("2개 일치 가져오기")
  @Test
  public void testGetTwoMatches() {
    assertThat(LottoPrize.findByMatchCount(2)).isEqualTo(LottoPrize.TWO_MATCHES);
  }

  @DisplayName("3개 일치 가져오기")
  @Test
  public void testGetThreeMatches() {
    assertThat(LottoPrize.findByMatchCount(3)).isEqualTo(LottoPrize.THREE_MATCHES);
  }

  @DisplayName("4개 일치 가져오기")
  @Test
  public void testGetFourMatches() {
    assertThat(LottoPrize.findByMatchCount(4)).isEqualTo(LottoPrize.FOUR_MATCHES);
  }

  @DisplayName("5개 일치 가져오기")
  @Test
  public void testGetFiveMatches() {
    assertThat(LottoPrize.findByMatchCount(5)).isEqualTo(LottoPrize.FIVE_MATCHES);
  }

  @DisplayName("6개 일치 가져오기")
  @Test
  public void testGetSixMatches() {
    assertThat(LottoPrize.findByMatchCount(6)).isEqualTo(SIX_MATCHES);
  }

  @DisplayName("상금의 총 합을 가져오기")
  @Test
  public void testGetTotalPrize() {
    assertAll(
        () -> assertThat(LottoPrize.getTotalPrize(List.of(SIX_MATCHES, FIVE_MATCHES)))
            .isEqualTo(LottoProperty.FIRST_PRIZE_AMOUNT + LottoProperty.SECOND_PRIZE_AMOUNT),
        () -> assertThat(LottoPrize.getTotalPrize(List.of(SIX_MATCHES, TWO_MATCHES)))
            .isEqualTo(LottoProperty.FIRST_PRIZE_AMOUNT + LottoProperty.NO_PRIZE_AMOUNT),
        () -> assertThat(LottoPrize.getTotalPrize(List.of(ZERO_MATCHES, TWO_MATCHES)))
            .isEqualTo(LottoProperty.NO_PRIZE_AMOUNT + LottoProperty.NO_PRIZE_AMOUNT)
    );
  }
}
