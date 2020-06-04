package lotto.domain;

import lotto.domain.vo.LottoMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoResultTest {

    @DisplayName("당첨 결과를 받아서 총 당첨액을 반환한다.")
    @Test
    void sumAllPrize() {
        List<WinningSheet> winningSheets = Arrays.asList(WinningSheet.FIFTH, WinningSheet.SECOND);
        LottoResult lottoResult = new LottoResult(winningSheets);

        int totalPrize = lottoResult.sumAllPrize();

        assertThat(totalPrize).isEqualTo(30_005_000);
    }
}
