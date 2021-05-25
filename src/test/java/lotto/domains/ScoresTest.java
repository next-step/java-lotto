package lotto.domains;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.enums.Prize;

public class ScoresTest {

    private Scores scoresA = new Scores();
    private Scores scoresB = new Scores();
    private Scores scoresC = new Scores();
    private long expectedTotalMoney = 0L;

    @BeforeEach
    void setUp() {
        for (Prize prize : Prize.values()) {
            scoresA.increase(prize);
            scoresB.increase(prize);
            expectedTotalMoney += prize.getPrize();
        }
    }

    @DisplayName("A와 B는 같다.")
    @Test
    void equals_True() {
        assertThat(scoresA.equals(scoresB)).isTrue();
    }

    @DisplayName("A와 C는 다르다.")
    @Test
    void equals_False() {
        assertThat(scoresA.equals(scoresC)).isFalse();
    }

    @DisplayName("총 당첨금 계산")
    @Test
    void totalMoney() {
        assertThat(scoresA.totalMoney()).isEqualTo(expectedTotalMoney);
    }

    @DisplayName("순위별 당첨 수")
    @Test
    void of() {
        for (Prize prize : Prize.values()) {
            assertThat(scoresA.of(prize)).isEqualTo(1);
        }
    }
}
