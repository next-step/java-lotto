package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatusTest {

    private WinningStatus winningStatus;

    @BeforeEach
    void setUp() {
        this.winningStatus = new WinningStatus();
    }

    @Test
    void 생성() {
        assertThat(winningStatus).isEqualTo(new WinningStatus());
    }

    @ParameterizedTest
    @ValueSource(ints = 3)
    void 당첨횟수_추가(final int loopCount) {
        for (int i = 0; i < loopCount; i++) {
            winningStatus.addCountOfRankFor(Rank.FIRST);
        }
        int count = winningStatus.getCountOfRankFor(Rank.FIRST);
        assertThat(count).isEqualTo(loopCount);
    }
}
