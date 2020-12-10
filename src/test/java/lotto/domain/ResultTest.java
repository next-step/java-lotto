package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    //수익률 계산 test
    // 결과 비교 test
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
        assertThat(result.getResult().get(Rank.FIRST)).isEqualTo(3);
        assertThat(result.getResult().get(Rank.FORTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 test")
    void winningRatioTest() {
        result.add(Rank.FORTH);
        assertThat(result.getWinningRatio(14000)).isEqualTo("0.36");
    }
}
