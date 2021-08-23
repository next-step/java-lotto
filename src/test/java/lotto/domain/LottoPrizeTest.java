package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPrizeTest {

  @ParameterizedTest(name = "상금 조회 테스트 횟수 : {0}, 상금 : {1}")
  @CsvSource({"3,5000", "4,50000", "5,1500000", "6,2000000000"})
  void ofTest(int matchedCnt, int prizeMoney) {
    //when
    LottoPrize prize = LottoPrize.of(matchedCnt);

    //then
    assertThat(prize.getPrizeMoney()).isEqualTo(prizeMoney);
  }

  @ParameterizedTest(name = "잘못된 상금 조회 테스트 횟수 : {0}")
  @CsvSource({"0", "1", "2", "7"})
  void invalidOfTest(int matchedCnt) {
    //when
    LottoPrize prize = LottoPrize.of(matchedCnt);

    //then
    assertThat(prize).isEqualTo(LottoPrize.NOTHING);
  }

  @Test
  @DisplayName("NOTHING을 제외한 LottoPrize 조회 테스트")
  void valuesExceptNothing() {
    //when
    LottoPrize[] valuesExceptNothing = LottoPrize.valuesExceptNothing();

    //then
    assertThat(valuesExceptNothing.length).isEqualTo(LottoPrize.values().length - 1);
    assertThat(valuesExceptNothing).doesNotContain(LottoPrize.NOTHING);

  }
}
