package lotto;

import lotto.domain.LottoResult;
import lotto.domain.MatchStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("입력받은 Status의 count값이 잘 업데이트 되는지 확인")
    @Test
    void check_result_count_updated() {
        //Given
        LottoResult lottoResult = new LottoResult(5000);

        //When
        lottoResult.updateValue(MatchStatus.THREE);

        //Then
        assertThat(lottoResult.getResultCount(MatchStatus.THREE)).isEqualTo(1);
    }

    @DisplayName("수익률이 계산되는지 확인")
    @Test
    void check_profit_ratio() {
        //Given
        LottoResult lottoResult = new LottoResult(5000);

        //When
        lottoResult.updateValue(MatchStatus.THREE);

        //Then
        assertThat(lottoResult.calculateProfitRatio()).isEqualTo(1);
    }
}
