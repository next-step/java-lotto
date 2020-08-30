package lotto.domain;

import lotto.context.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WinningResultTest {
    WinningResult winningResult;
    @BeforeEach
    void create() {
        winningResult = new WinningResult("1, 2, 3, 4, 5, 6");
    }

    @ParameterizedTest
    @EnumSource(Rank.class)
    void getMatchCountResult(Rank rank) {
        Assertions.assertThat(winningResult.getMatchCountResult()).containsKeys(rank);
    }

    @Test
    @DisplayName("객체생성시 초기화되는 객체인 WinningPaper의 값 테스트")
    void getWinningPaper() {
        Assertions.assertThat(winningResult.getWinningPaper().getWinningNumbersToIntegerList())
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}