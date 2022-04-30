package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinStatisticsTest {
    WinStatistics winStatistics = new WinStatistics();
    @Test
    void shouldSave3toThree() {
        winStatistics.save(3);
        assertThat(winStatistics).isEqualTo(new WinStatistics(1,0,0,0));
    }
}
