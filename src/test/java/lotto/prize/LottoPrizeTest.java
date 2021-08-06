package lotto.prize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호 일치 개수와 보너스 번호 일치 여부를 입력받아 당첨금을 반환한다")
class LottoPrizeTest {
    @Test
    @DisplayName("2등 : 로또 번호 5개 일치, 보너스 번호 일치")
    void valueOfSecond() {
        MatchInformation matchInformation = MatchInformation.of(5, true);
        LottoPrize lottoPrize = LottoPrize.valueOf(matchInformation);
        Assertions.assertThat(lottoPrize).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    @DisplayName("3등 : 로또 번호 5개 일치")
    void valueOfThird() {
        MatchInformation matchInformation = MatchInformation.of(5, false);
        LottoPrize lottoPrize = LottoPrize.valueOf(matchInformation);
        Assertions.assertThat(lottoPrize).isEqualTo(LottoPrize.THIRD);
    }

    @Test
    @DisplayName("일치하는 번호가 없는 경우 NONE을 반환")
    void exception() {
        MatchInformation matchInformation = MatchInformation.of(2, false);
        LottoPrize lottoPrize = LottoPrize.valueOf(matchInformation);
        Assertions.assertThat(lottoPrize).isEqualTo(LottoPrize.NONE);
    }
}
