package lotto.domain;

import lotto.domain.LottoResult;
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
        Matches matches = Matches.of(List.of(Match.THREE, Match.FOUR, Match.FIVE, Match.SIX, Match.SIX));
        LottoResult result = LottoResult.from(5000, matches);

        assertThat(result.getMatchCount(Match.THREE))
                .isEqualTo(1);
        assertThat(result.getMatchCount(Match.FOUR))
                .isEqualTo(1);
        assertThat(result.getMatchCount(Match.FIVE))
                .isEqualTo(1);
        assertThat(result.getMatchCount(Match.SIX))
                .isEqualTo(2);
        assertThat(result.getReturnRate())
                .isEqualTo(800311.0);
    }
}
