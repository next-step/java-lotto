package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 Statistic 테스트")
class StatisticTest {

    @DisplayName("Statistic 담첨 번호 개수 매칭 테스트")
    @Test
    void valueOfMatchNumber() {
        Statistic result = Statistic.valueOfMatchNumber(3, false);
        assertThat(result).isEqualTo(Statistic.FIFTH);
    }

    @DisplayName("Statistic 보너스 미포함 등수 테스트")
    @Test
    void valueOfMatchNumber_withoutBonus() {
        Statistic resultWithBonus = Statistic.valueOfMatchNumber(5, false);
        assertThat(resultWithBonus).isEqualTo(Statistic.THIRD);
    }

    @DisplayName("Statistic 보너스 포함 등수 테스트")
    @Test
    void valueOfMatchNumber_withBonus() {
        Statistic resultWithBonus = Statistic.valueOfMatchNumber(5, true);
        assertThat(resultWithBonus).isEqualTo(Statistic.SECOND);
    }
}
