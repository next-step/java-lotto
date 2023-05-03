package lotto.dto;

import lotto.domain.Match;
import lotto.domain.Matches;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("로또 결과 생성 테스트")
    @Test
    void generateLottoResult() {
        Matches matches = Matches.of(List.of(Match.THREE, Match.FOUR, Match.FIVE, Match.SIX));
        LottoResult result = LottoResult.from(5000, matches);

        assertThat(result.getLottoPrizeCount(LottoPrize.FIRST))
                .isEqualTo(1);
        assertThat(result.getLottoPrizeCount(LottoPrize.SECOND))
                .isEqualTo(1);
        assertThat(result.getLottoPrizeCount(LottoPrize.THIRD))
                .isEqualTo(1);
        assertThat(result.getLottoPrizeCount(LottoPrize.FOURTH))
                .isEqualTo(1);
        assertThat(result.getReturnRate())
                .isEqualTo(400311.0);
    }
}
