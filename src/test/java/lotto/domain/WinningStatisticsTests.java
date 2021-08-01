package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTests {

    @DisplayName("지난주 당첨 번호를 입력했을때 통계 가져오기 테스트")
    @Test
    void winningStatisticsTest() {
        LottoNumber winningLottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));

        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));

        LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 45));

        LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(lottoNumber, lottoNumber2));

        WinningStatistics winningStatistics = new WinningStatistics(winningLottoNumber, lottoNumbers);

        assertThat(Arrays.toString(winningStatistics.getMatchesRecord())).isEqualTo("[0, 0, 1, 1]");
    }


}