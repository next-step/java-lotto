package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    @ParameterizedTest
    @ValueSource(ints = {5000, 50000, 1500000, 2000000000})
    void hashMap_생성(int key) {
        assertThat(new Statistics().setUp()).hasSize(4);
        assertThat(new Statistics().setUp().containsKey(key)).isTrue();
    }

    @Test
    void 일치() {
        List<Integer> value = List.of(1, 2, 3, 4, 5, 7);
        int[] winNumbers = new WinNumber().createWinNumbers("1, 2, 3, 4, 5, 6");
        assertThat(new Statistics().match(value, winNumbers)).isEqualTo(5);
    }

    @Test
    void 수익률_계산() {
        Statistics statistics = new Statistics();
        HashMap<Integer, Integer> map = statistics.setUp();
        map.put(5000, 1);
        map.put(50000, 1);
        assertThat(statistics.revenue(5000)).isEqualTo(11.0);
    }
}
