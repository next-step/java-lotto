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
        winningResult = new WinningResult("1, 2, 3, 4, 5, 6", "1");
    }

    @Test
    @DisplayName("WinningTable 생성확인")
    void makeWinningTable() {
        Assertions.assertThat(winningResult.makeWinningTable(new LottoPapers(3).getPapers()).getMatchCountTable())
                .isEqualTo(new WinningTable().getMatchCountTable());
    }

    @Test
    void hasBonus() {
        Assertions.assertThat(winningResult.hasBonus(new LottoPaper(Arrays.asList(LottoNum.of(1)))))
                .isTrue();
        Assertions.assertThat(winningResult.hasBonus(new LottoPaper(Arrays.asList(LottoNum.of(12)))))
                .isFalse();
    }

    @Test
    void getMatchCount() {
        Assertions.assertThat(winningResult.getMatchCount(new LottoPaper(Arrays.asList(LottoNum.of(1)))))
                .isEqualTo(1);
        Assertions.assertThat(winningResult.getMatchCount(new LottoPaper(Arrays.asList(LottoNum.of(1), LottoNum.of(2)))))
                .isEqualTo(2);
    }
}