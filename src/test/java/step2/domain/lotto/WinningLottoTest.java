package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.statistics.Match;
import step2.domain.statistics.Statistics;
import step2.domain.statistics.WinningStatistics;
import step2.utils.WinningStatisticsTestUtil;
import step2.vo.Rank;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("Bouns Number로 중복 값 넣을 시 생성 실패")
    void createWinningLottoSuccessTest() {
        final int bonusNumberValue = 6;
        final LottoNumber bonusNumber = new LottoNumber(bonusNumberValue);
        final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, bonusNumberValue));
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

}
