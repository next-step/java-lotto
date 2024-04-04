package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinStatusTest {

    @Test
    @DisplayName("당첨 횟수")
    void getWincount() {
        WinStatus winStatus = new WinStatus();
        winStatus.correct(5);
        winStatus.correct(5);

        List<Integer> winner = new ArrayList<>(List.of(0, 0, 2, 0, 0));
        
        assertThat(winStatus.getWincount()).isEqualTo(winner);
    }

    @Test
    @DisplayName("출력 로또 길이")
    public void myLottoNumbers() {
        WinStatus winStatus = new WinStatus();
        assertThat(winStatus.getWincount().size()).isEqualTo(5);
    }
}