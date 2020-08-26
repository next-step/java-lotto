package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.Lotto.ofLottoByDesignatedRange;
import static step2.domain.MatchesResult.ofMatchesResults;

class MatchesResultTest {

    @ParameterizedTest
    @CsvSource(value = {"1:7:23:1,2,3:3:3"}, delimiter = ':')
    public void 당첨_결과(int start, int end, int bonusNumber, String result, int key, int value) {
        WinnersNo winnersNo = new WinnersNo(bonusNumber, result);
        Lottos lottos = new Lottos(Arrays.asList(
                ofLottoByDesignatedRange(start, end),
                ofLottoByDesignatedRange(start, end),
                ofLottoByDesignatedRange(start, end)));
        MatchesResult winningInformation = ofMatchesResults(winnersNo, lottos);
        assertThat(winningInformation.getResults().get(ScoreType.getScore(key))).isEqualTo(value);
    }
}
