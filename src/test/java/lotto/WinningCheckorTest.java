package lotto;

import lotto.model.WinningCheckor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCheckorTest {
    List<Integer> preNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        preNumbers.add(1);
        preNumbers.add(2);
        preNumbers.add(3);
        preNumbers.add(4);
        preNumbers.add(5);
        preNumbers.add(6);
    }

    @Test
    @DisplayName("당첨 번호 테스트")
    public void winningTest() {
        List<Integer> lottoTicket = new ArrayList<>();
        lottoTicket.add(1);
        lottoTicket.add(2);
        lottoTicket.add(3);
        lottoTicket.add(4);
        lottoTicket.add(10);
        lottoTicket.add(11);

        WinningCheckor winningCheckor = new WinningCheckor(preNumbers);
        int winningCount = winningCheckor.checkWinning(lottoTicket);

        assertThat(winningCount).isEqualTo(4);
    }

}
