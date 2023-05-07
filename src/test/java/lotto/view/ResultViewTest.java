package lotto.view;

import lotto.model.enums.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    @Test
    @DisplayName("당첨 통계 출력 테스트")
    void showStatistics() {
        assertThat(ResultView.showStatistics(Ranking.FIRST,6)).isEqualTo(
                "6개 일치 (2000000000원)- 6개");
    }
}