package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

  @Test
  @DisplayName("로또 1등")
  void lottoTop_ShouldTopRank() {
    assertThat(LottoRank.of(6, false).isTop()).isTrue();
  }

  @Test
  @DisplayName("로또 2등")
  void lottoSecond_ShouldSecondRank() {
    assertThat(LottoRank.of(5, true).isSecond()).isTrue();
  }

  @Test
  @DisplayName("로또 3등")
  void lottoThird_ShouldThirdRank() {
    assertThat(LottoRank.of(5, false).isThird()).isTrue();
  }

  @Test
  @DisplayName("로또 4등")
  void lottoFourth_ShouldFourthRank() {
    assertThat(LottoRank.of(4, false).isFourth()).isTrue();
  }

  @Test
  @DisplayName("로또 5등")
  void lottoFifth_ShouldFifthRank() {
    assertThat(LottoRank.of(3, false).isFifth()).isTrue();
  }

  @Test
  @DisplayName("로또 꽝")
  void lottoNone_ShouldNoneRank() {
    assertThat(LottoRank.of(2, false).isNone()).isTrue();
    assertThat(LottoRank.of(1, false).isNone()).isTrue();
    assertThat(LottoRank.of(0, false).isNone()).isTrue();
  }

}
