package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @Test
    void getWinnerNumberList() {
        int[] list = {1,2,3};
        assertThat(WinningNumber.getWinnerNumberList("1,2,3")).isEqualTo(list);
    }
}