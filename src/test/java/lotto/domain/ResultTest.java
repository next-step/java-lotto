package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    private Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @Test
    @DisplayName("저장된 결과 갯수 test")
    void checkResultCountTest() {
        result.add(Rank.FORTH);
        result.add(Rank.FIRST);
        result.add(Rank.FIRST);
        result.add(Rank.FIRST);
        assertThat(result.getResult().stream()
                    .filter(rank -> rank == Rank.FIRST).count()).isEqualTo(3);
        assertThat(result.getResult().stream()
                    .filter(rank -> rank == Rank.FORTH).count()).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 test")
    void winningRatioTest() {
        result.add(Rank.FORTH);
        assertThat(result.getWinningRatio(14000)).isEqualTo("0.36");
    }

    @Test
    @DisplayName("동일한 순위 여러번 당첨 test")
    void duplicateWinningTest() {
        result.add(Rank.FIRST);
        result.add(Rank.FIRST);
        result.add(Rank.FIRST);
        result.add(Rank.FIRST);
        result.add(Rank.FIRST);
        result.add(Rank.FIRST);
        assertThat(result.getTotalWinningPrice()).isEqualTo(12_000_000_000D);
    }
}
