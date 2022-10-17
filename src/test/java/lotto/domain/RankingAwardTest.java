package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankingAwardTest {

    @Test
    @DisplayName("로또 당첨금을 탈 수 있는 순위를 입력함")
    void getAwardSuccess() {
        assertThat(RankingAward.getAward(3)).isEqualTo(5000);
        assertThat(RankingAward.getAward(4)).isEqualTo(50000);
        assertThat(RankingAward.getAward(5)).isEqualTo(1500000);
        assertThat(RankingAward.getAward(6)).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("로또 당첨금을 탈 수 있는 순위가 아닌 다른 값을 입력함")
    void getAwardFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RankingAward.getAward(7));
    }
}
