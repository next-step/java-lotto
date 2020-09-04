package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WinningResultTest {
    WinningResult winningResult;
    @BeforeEach
    void create() {
        winningResult = new WinningResult("1, 2, 3, 4, 5, 6");
    }

    @Test
    void getWinninLottoNumberToIntegerList() {
        Assertions.assertThat(winningResult.getWinningLottoNumberToIntegerList())
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("WinningTable 생성확인")
    void makeWinningTable() {
        winningResult.setBonusNum(LottoNum.of(1));
        Assertions.assertThat(winningResult.makeWinningTable(new LottoPapers(3).getPapers()).getMatchCountTable())
                .isEqualTo(new WinningTable().getMatchCountTable());
    }
}