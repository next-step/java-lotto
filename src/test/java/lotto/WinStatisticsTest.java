package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinStatisticsTest {
    @Test
    void shouldSave3toThree() {
        WinStatistics winStatistics = new WinStatistics();
        winStatistics.save(3);
        assertThat(winStatistics).isEqualTo(new WinStatistics(1, 0, 0, 0));
    }

    @Test
    void toPayloadShouldFormatWins() {
        WinStatistics winStatistics = new WinStatistics(1, 0, 0, 0);
        assertThat(winStatistics.toPayload()).isEqualTo("3 matches (₩5000): 1\n" + "4 matches (₩50000): 0\n" + "5 matches (₩1500000): 0\n" + "6 matches (₩2000000000): 0\n");
    }


}
