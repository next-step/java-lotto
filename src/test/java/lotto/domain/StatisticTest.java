package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 Statistic 테스트")
class StatisticTest {

    @DisplayName("Statistic 담첨 번호 개수 매칭 테스트")
    @Test
    void valueOfMatchNumber() {
        Statistic result = Statistic.valueOfMatchNumber(3);
        assertThat(result).isEqualTo(Statistic.THREE);
    }
}
