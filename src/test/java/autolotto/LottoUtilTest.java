package autolotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoUtilTest {

    @Test
    void getLottoBuyingCount() {
        assertThat(LottoUtil.getLottoBuyingCount(14000)).isEqualTo(14);
    }

    @Test
    void convertWinNumberStringToIntArray() {
        int[] winNum = new int[]{1, 2, 3, 4, 5, 6};
        assertThat(LottoUtil.convertWinNumberStringToIntArray("1,2,3,4,5,6")).isEqualTo(winNum);
    }
}