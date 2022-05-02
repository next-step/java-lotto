package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningNumbersTest {
    @Test
    void 로또_범위에_해당하지_않는_보너스_숫자_입력() {
        assertThatThrownBy(() -> {
            new LottoWinningNumbers("1,2,3,4,5,6", 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_번호_오류() {
        assertThatThrownBy(() -> {
            new LottoWinningNumbers("1,2,3,4,5,0", 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
}