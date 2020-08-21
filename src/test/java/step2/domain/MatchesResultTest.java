package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.Lotto.ofLottoByDesignatedRange;
import static step2.domain.WinnerVerification.getWinnerVerified;

class MatchesResultTest {

    @ParameterizedTest
    @CsvSource(value = {"1:7:1,2,3:3:3"}, delimiter = ':')
    public void 당첨_결과(int start, int end, String result, int key, int value) {
        WinnersNo winnersNo = new WinnersNo(result);
        List<Lotto> lottos = Arrays.asList(
                ofLottoByDesignatedRange(start, end),
                ofLottoByDesignatedRange(start, end),
                ofLottoByDesignatedRange(start, end));
        List<WinningInformation> winningInformation = getWinnerVerified(winnersNo, lottos);
        assertThat(MatchesResult.ofMatchesResults(winningInformation).getResults().get(3)).isEqualTo(3);
    }
}
