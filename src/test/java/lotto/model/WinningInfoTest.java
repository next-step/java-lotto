package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningInfoTest {

    private WinningInfo winningInfo;

    @BeforeEach
    void setup() {
        winningInfo = new WinningInfo("1, 2, 3", 4);
    }

    @Test
    void parseNumbers() {
        List<Integer> list = WinningInfo.parseNumbers("3,4,5, 6,7");
        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    void winningInfo() {
        assertThat(winningInfo.winningLottos.size()).isEqualTo(3);
    }
}