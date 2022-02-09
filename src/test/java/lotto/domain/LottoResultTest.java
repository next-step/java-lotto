package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private String numberInput = "1, 2, 3, 4, 5, 6";
    private final String bonusInput = "7";

    private final LottoResult lottoResult = new LottoResult(numberInput, bonusInput);


    @Test
    void 당첨번호_갯수_테스트() {
        assertThat(
            lottoResult.matchNumbersCount(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)))).isEqualTo(4);
    }

    @Test
    void 보너스_확인_테스트() {
        assertTrue(lottoResult.isBonusNumberMatch(new Lotto(Arrays.asList(7, 10, 11, 12, 13, 14))));
    }

    @Test
    void 당첨번호_중복_테스트() {
        numberInput = "1, 1, 1, 1, 1, 1";

        assertThatThrownBy(() -> new LottoResult(numberInput, bonusInput)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_범위_테스트() {
        numberInput = "100, 200, 300, 1, 2, 3";

        assertThatThrownBy(() -> new LottoResult(numberInput, bonusInput)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_보너스_중복테스트() {
        numberInput = "1, 2, 3, 4, 5, 7";

        assertThatThrownBy(() -> new LottoResult(numberInput, bonusInput)).isInstanceOf(
            IllegalArgumentException.class);
    }
}