package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    @Test
    void 생성자_테스트() {
        Statistics statistics = new Statistics(List.of(1L,2L,3L,4L), 0.3);

        assertThat(statistics).isEqualTo(new Statistics(List.of(1L,2L,3L,4L), 0.3));
    }
}
