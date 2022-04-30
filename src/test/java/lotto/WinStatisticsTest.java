package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinStatisticsTest {
    WinStatistics winStatistics = new WinStatistics();

    @Test
    void shouldSave3toThree() {
        winStatistics.save(3);
        assertThat(winStatistics).isEqualTo(new WinStatistics(1, 0, 0, 0));
    }

    @Test
    void toPayloadShouldFormatWins() {
        assertThat(new WinStatistics(1, 0, 0, 0).toPayload()).isEqualTo("3 matches (₩5000): 1\n" + "4 matches (₩50000): 0\n" + "5 matches (₩1500000): 0\n" + "6 matches (₩2000000000): 0");
    }
}
