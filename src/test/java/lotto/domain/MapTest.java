package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MapTest {

    @Test
    void 맵_키_null() {
        Map<Rank, Integer> map = new EnumMap<>(WinningResult.DEFAULT_RANKING_COUNTS);

        assertThatExceptionOfType(NullPointerException.class)
            .isThrownBy(() -> map.put(null, 1));
    }

}
