package lotto;

import lotto.model.WinningCheckor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCheckorTest {

    @Test
    @DisplayName("당첨 번호 테스트")
    public void winningTest() {

        WinningCheckor winningCheckor = new WinningCheckor(new HashSet<>(Arrays.asList(1,2,3,4,5,6)),7);
        int winningCount = winningCheckor.checkWinning(Arrays.asList(1,2,3,4,10,11));

        assertThat(winningCount).isEqualTo(4);
    }

}
