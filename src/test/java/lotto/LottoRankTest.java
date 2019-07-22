package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @DisplayName("valueOf 테스트 입니다.")
    @Test
    public void testLottoRankValueOf() {
        int validCountOfMatched = LottoRank.FOURTH.getCountOfMatch();
        LottoRank lottoRank = LottoRank.valueOf(validCountOfMatched, false);
        LottoRank expectedLottoRank = LottoRank.FOURTH;

        assertThat(lottoRank).isEqualTo(expectedLottoRank);

        int invalidCountOfMatched = 10;
        lottoRank = LottoRank.valueOf(invalidCountOfMatched, true);
        expectedLottoRank = LottoRank.MISS;

        assertThat(lottoRank).isEqualTo(expectedLottoRank);
    }

    @DisplayName("2등 과 3등의 당첨된 숫자 갯수는 같습니다.")
    @Test
    public void testIsEqaulsCountOfMatchedBothSecondAndThird() {
        int thirdCountOfMatch = LottoRank.THIRD.getCountOfMatch();
        int secondCountOfMatch = LottoRank.SECOND.getCountOfMatch();

        assertThat(thirdCountOfMatch).isEqualTo(secondCountOfMatch);
    }
}
