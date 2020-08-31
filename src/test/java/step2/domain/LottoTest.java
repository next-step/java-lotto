package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.Lotto.ofLottoByDesignatedRange;

public class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1:7:23:1,2,3"}, delimiter = ':')
    public void 당첨_확인(int start, int end, int bonusNumber, String result) {
        Lotto lotto = ofLottoByDesignatedRange(start, end);
        WinnersNo winnersNo = new WinnersNo(bonusNumber, result);
        assertThat(lotto.addWinningInfos(winnersNo)).isEqualTo(ScoreType.THREE);
    }
}
