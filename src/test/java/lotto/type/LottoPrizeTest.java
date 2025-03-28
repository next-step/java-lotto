package lotto.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.type.LottoPrize.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoPrizeTest {

  @DisplayName("0개 일치 가져오기")
  @Test
  public void testGetZeroMatches() {
    assertAll(
        () -> assertThat(LottoPrize.findByMatchCount(0, false)).isEqualTo(ZERO_MATCHES),
        () -> assertThat(LottoPrize.findByMatchCount(0, true)).isEqualTo(ZERO_MATCHES)
    );
  }

  @DisplayName("1개 일치 가져오기")
  @Test
  public void testGetOneMatches() {
    assertAll(
        () -> assertThat(LottoPrize.findByMatchCount(1, false)).isEqualTo(ONE_MATCHES),
        () -> assertThat(LottoPrize.findByMatchCount(1, true)).isEqualTo(ONE_MATCHES)
    );
  }

  @DisplayName("2개 일치 가져오기")
  @Test
  public void testGetTwoMatches() {
    assertAll(
        () -> assertThat(LottoPrize.findByMatchCount(2, false)).isEqualTo(TWO_MATCHES),
        () -> assertThat(LottoPrize.findByMatchCount(2, true)).isEqualTo(TWO_MATCHES)
    );
  }

  @DisplayName("3개 일치 가져오기")
  @Test
  public void testGetThreeMatches() {
    assertAll(
        () -> assertThat(LottoPrize.findByMatchCount(3, false)).isEqualTo(THREE_MATCHES),
        () -> assertThat(LottoPrize.findByMatchCount(3, true)).isEqualTo(THREE_MATCHES)
    );
  }

  @DisplayName("4개 일치 가져오기")
  @Test
  public void testGetFourMatches() {
    assertAll(
        () -> assertThat(LottoPrize.findByMatchCount(4, false)).isEqualTo(FOUR_MATCHES),
        () -> assertThat(LottoPrize.findByMatchCount(4, true)).isEqualTo(FOUR_MATCHES)
    );
  }

  @DisplayName("5개 일치 가져오기")
  @Test
  public void testGetFiveMatches() {
    assertAll(
        () -> assertThat(LottoPrize.findByMatchCount(5, false)).isEqualTo(FIVE_MATCHES),
        () -> assertThat(LottoPrize.findByMatchCount(5, true)).isEqualTo(FIVE_WITH_BONUS_MATCHES)
    );
  }

  @DisplayName("6개 일치 가져오기")
  @Test
  public void testGetSixMatches() {
    assertAll(
        () -> assertThat(LottoPrize.findByMatchCount(6, false)).isEqualTo(SIX_MATCHES),
        () -> assertThat(LottoPrize.findByMatchCount(6, true)).isEqualTo(SIX_MATCHES)
    );
  }

  @DisplayName("유효하지 않은 match count로 가져올 시 예외 발생")
  @Test
  public void testGetLottoPrizeThrowException() {
    assertAll(
        () -> assertThrows(RuntimeException.class, () -> LottoPrize.findByMatchCount(7, true)),
        () -> assertThrows(RuntimeException.class, () -> LottoPrize.findByMatchCount(7, false)),
        () -> assertThrows(RuntimeException.class, () -> LottoPrize.findByMatchCount(-1, true)),
        () -> assertThrows(RuntimeException.class, () -> LottoPrize.findByMatchCount(-1, false))
    );
  }

  @DisplayName("상금의 총 합을 가져오기")
  @Test
  public void testGetTotalPrize() {
    assertAll(
        () -> assertThat(LottoPrize.getTotalPrize(List.of(SIX_MATCHES, FIVE_MATCHES)))
            .isEqualTo(2_001_500_000),
        () -> assertThat(LottoPrize.getTotalPrize(List.of(SIX_MATCHES, TWO_MATCHES)))
            .isEqualTo(2_000_000_000),
        () -> assertThat(LottoPrize.getTotalPrize(List.of(ZERO_MATCHES, TWO_MATCHES)))
            .isEqualTo(0)
    );
  }
}
