package lotto.dto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintLottoResultValueTest {

    @DisplayName("LottoStatisticsValue 생성 테스트")
    @Test
    void of() {
        assertThat(PrintLottoResultValue.of(LottoRank.SECOND, 1L))
                .isEqualToComparingFieldByField(PrintLottoResultValue.of(LottoRank.SECOND, 1L));
    }
}
