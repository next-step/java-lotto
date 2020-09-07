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
        Assertions.assertThat(winningResult.makeWinningTable(new LottoStore(null, 3)
                .makeLottoPapers().getLottoPapers()).getMatchCountTable())
                .isEqualTo(new WinningTable().getMatchCountTable());
    }

    @Test
    void hasBonus() {
        Assertions.assertThat(winningResult.hasBonusBall(new LottoPaper(Arrays.asList(LottoNum.of(1), LottoNum.of(2),
                LottoNum.of(3) ,LottoNum.of(4) ,LottoNum.of(5) ,LottoNum.of(6)))))
                .isTrue();
        Assertions.assertThat(winningResult.hasBonusBall(new LottoPaper(Arrays.asList(LottoNum.of(10), LottoNum.of(2),
                LottoNum.of(3) ,LottoNum.of(4) ,LottoNum.of(5) ,LottoNum.of(6)))))
                .isFalse();
    }

    @Test
    void getMatchCount() {
        Assertions.assertThat(winningResult.getMatchCount(new LottoPaper(Arrays.asList(LottoNum.of(1), LottoNum.of(2),
                LottoNum.of(3) ,LottoNum.of(4) ,LottoNum.of(5) ,LottoNum.of(6)))))
                .isEqualTo(6);
        Assertions.assertThat(winningResult.getMatchCount(new LottoPaper(Arrays.asList(LottoNum.of(1), LottoNum.of(2),
                LottoNum.of(3) ,LottoNum.of(20) ,LottoNum.of(30) ,LottoNum.of(40)))))
                .isEqualTo(3);
    }
}