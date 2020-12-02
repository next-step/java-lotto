package lotto;

import lotto.model.Rank;
import lotto.model.WinningCheckor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCheckorTest {

    List<Integer> preNumbers;

    @BeforeEach
    public void setUp(){
        preNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("1등 테스트")
    public void firstTest(){
        WinningCheckor winningCheckor = new WinningCheckor(new HashSet<>(preNumbers),7);
        int winningCount = winningCheckor.checkWinning(Arrays.asList(1,2,3,4,5,6));

        assertThat(winningCount).isEqualTo(Rank.FIRST.getWinningCount());
    }

    @Test
    @DisplayName("2등 테스트")
    public void secondTest(){
        WinningCheckor winningCheckor = new WinningCheckor(new HashSet<>(preNumbers),7);
        int winningCount = winningCheckor.checkWinning(Arrays.asList(1,2,3,4,5,7));

        assertThat(winningCount).isEqualTo(Rank.SECOND.getWinningCount());
    }

    @Test
    @DisplayName("3등 테스트")
    public void thirdTest(){
        WinningCheckor winningCheckor = new WinningCheckor(new HashSet<>(preNumbers),7);
        int winningCount = winningCheckor.checkWinning(Arrays.asList(1,2,3,4,5,10));

        assertThat(winningCount).isEqualTo(Rank.THIRD.getWinningCount());
    }


    @Test
    @DisplayName("4등 테스트")
    public void fourthTest() {

        WinningCheckor winningCheckor = new WinningCheckor(new HashSet<>(preNumbers),7);
        int winningCount = winningCheckor.checkWinning(Arrays.asList(1,2,3,4,10,11));

        assertThat(winningCount).isEqualTo(Rank.FOURTH.getWinningCount());
    }

    @Test
    @DisplayName("5등 테스트")
    public void fifthTest(){
        WinningCheckor winningCheckor = new WinningCheckor(new HashSet<>(preNumbers),7);
        int winningCount = winningCheckor.checkWinning(Arrays.asList(1,2,3,10,20,30));

        assertThat(winningCount).isEqualTo(Rank.FIFTH.getWinningCount());
    }

    @Test
    @DisplayName("꽝 테스트")
    public void noMatchTest(){
        WinningCheckor winningCheckor = new WinningCheckor(new HashSet<>(preNumbers),7);
        int winningCount = winningCheckor.checkWinning(Arrays.asList(8,9,10,11,22,45));

        assertThat(winningCount).isEqualTo(Rank.NO_MATCH.getWinningCount());
    }

}
