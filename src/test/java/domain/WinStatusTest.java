package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinStatusTest {

    @Test
    void getWincount() {

    }

    @Test
    @DisplayName("출력 로또 번호")
    public void myLottoNumbers() {
        WinStatus winStatus = new WinStatus();
        winStatus.correct(0);
        winStatus.correct(1);
        winStatus.correct(2);
        winStatus.correct(3);
        assertThat(winStatus.getWincount().size()).isEqualTo(4);
    }
}