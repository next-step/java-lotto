package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    @Test
    void create() {
        List<Integer> staticsList = Arrays.asList(0, 0, 1, 0, 0, 0, 0);
        WinningResult result = new WinningResult(staticsList);
        assertThat(new WinningResult(0, 0, 1, 0, 0, 0, 0)).isEqualTo(result);
    }

    @Test
    void 통계정보반영_3개맞춤() {
        WinningResult result = new WinningResult();
        result.incrementMatchCount(3);
        assertThat(result).isEqualTo(new WinningResult(0, 0, 0, 1, 0, 0, 0));
    }
}
