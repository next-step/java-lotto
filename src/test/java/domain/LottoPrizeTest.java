package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoPrizeTest {
    @Test
    @DisplayName("보너스번호 미포함 매치카운트 정상 출력 확인 테스트")
    void getMatchCountTest() {
        LottoPrize lottoPrize = LottoPrize.fromMatchCount(5, false);
        assertThat(lottoPrize).isEqualTo(LottoPrize.THIRD);
    }

    @Test
    @DisplayName("보너스번호 포함 매치카운트 정상 출력 확인 테스트")
    void geMatchCountWithBonusTest() {
        LottoPrize lottoPrize = LottoPrize.fromMatchCount(5, true);
        assertThat(lottoPrize).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    @DisplayName("6개 이상 매칭카운트가 들어오는 경우 exception throw")
    void overCountTest() {
        assertThrows(IllegalArgumentException.class, () -> LottoPrize.fromMatchCount(7, false));
    }
}
