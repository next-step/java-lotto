package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StatisticsTest {

    @Test
    @DisplayName("matchCount와 맞는 Statistics 객체 반환")
    void getStatisticsByMatchCountTest() {
        assertThat(Statistics.getStatisticsByMatchCount(3,false)).isEqualTo(Statistics.THREE);
        assertThat(Statistics.getStatisticsByMatchCount(4, false)).isEqualTo(Statistics.FOUR);
        assertThat(Statistics.getStatisticsByMatchCount(5, false)).isEqualTo(Statistics.FIVE);
        assertThat(Statistics.getStatisticsByMatchCount(5, true)).isEqualTo(Statistics.BONUS);
        assertThat(Statistics.getStatisticsByMatchCount(6, false)).isEqualTo(Statistics.SIX);
    }

    @Test
    @DisplayName("matchCount와 맞는 객체가 없을경우 Exception 발생")
    void notExistValueTest() {
        assertThatThrownBy(() -> Statistics.getStatisticsByMatchCount(7, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지 않는 값입니다.");
    }
}
