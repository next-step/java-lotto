package lottogame;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {

    @DisplayName("로또 결과 통계 객체 생성 성공")
    @Test
    void create() {
        LottoService lottoService = new LottoService(new Payment("2000"));
        String lottoValue = "1,2,3,4,5,6";
        String bonusValue = "7";
        WinningNumber winningNumber = new WinningNumber(lottoValue, bonusValue);

        assertThatNoException().isThrownBy(() -> new LottoStatistics(lottoService.getLottos(), winningNumber));
    }

}
