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

    @Test
    void getWinninLottoNumberToIntegerList() {
        Assertions.assertThat(winningResult.getWinninLottoNumberToIntegerList())
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}