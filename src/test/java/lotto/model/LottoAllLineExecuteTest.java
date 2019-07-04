package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAllLineExecuteTest {

    @Test
    @DisplayName("입력한 금액에 따른 게임 생성 테스트")
    void extractLottoNumbers() {
        int lottoCount = 14;
        List<LottoOneLine> lottos = LottoMachine.extractLottoNumbers(lottoCount);
        LottoOneLine lottoOneLine = lottos.get(0);
        assertThat(lottos.size()).isEqualTo(14);
        assertThat(lottoOneLine.lottoNumber().split(LottoOneLine.LAST_WEEK_WINNUM_DELIMITER).length).isEqualTo(6);
    }
}
