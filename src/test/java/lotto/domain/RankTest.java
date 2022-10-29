package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RankTest {

    @Test
    @DisplayName("순위에 따른 당첨금 생성")
    void getAwardAmountByRanking() {
        assertAll(
                () -> assertThat(Rank.FIRST.getPrize())
                        .isEqualTo(2_000_000_000),
                () -> assertThat(Rank.BONUS.getPrize())
                        .isEqualTo(30_000_000),
                () -> assertThat(Rank.SECOND.getPrize())
                        .isEqualTo(1_500_000),
                () -> assertThat(Rank.THIRD.getPrize())
                        .isEqualTo(50000),
                () -> assertThat(Rank.FOURTH.getPrize())
                        .isEqualTo(5000)
        );
    }
}
