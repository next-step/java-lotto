package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPrizeTest {

  @ParameterizedTest(name = "상금 조회 테스트 - 일치개수: {0}, 보너스일치여부: {1}, 상금: {2}")
  @CsvSource({
      "0, false, 0", "0, true, 0",
      "1, false, 0", "1, true, 0",
      "2, false, 0", "2, true, 0",
      "3,false,5000", "3,true,5000",
      "4,false,50000", "4,true,50000",
      "5,false,1500000", "5,true,30000000",
      "6,false,2000000000"
  })
  void ofTest(int matchCnt, boolean matchBonus, int prizeMoney) {
    //when
    LottoPrize prize = LottoPrize.of(matchCnt, matchBonus);

    //then
    assertThat(prize.prizeMoney()).isEqualTo(prizeMoney);
  }

  @ParameterizedTest(name = "잘못된 상금 조회 테스트 횟수 : {0}")
  @CsvSource({"-10", "-1", "7", "8"})
  void invalidOfTest(int matchedCnt) {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      LottoPrize.of(matchedCnt, false);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      LottoPrize.of(matchedCnt, true);
    });
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
