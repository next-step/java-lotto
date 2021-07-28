package lotto.auto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameAnalyzerTest {
    private GameAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        List<LottoGame> lottoGames = new ArrayList<>();
        lottoGames.add(LottoGame.from(List.of(1, 2, 3, 4, 5, 6)));
        analyzer = GameAnalyzer.from(lottoGames);
    }

    @Test
    @DisplayName("null을 입력하면 NPE가 발생한다")
    void getMatchTableNpe() {
        Assertions.assertThatThrownBy(() -> analyzer.getMatchTable(null))
                  .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("정상 입력 시 7칸의 매치테이블을 반환한다")
    void getMatchTable() {
        int[] matchTable = analyzer.getMatchTable(new int[]{1, 2, 3, 4, 5, 6});
        Assertions.assertThat(matchTable).isNotNull().isNotEmpty();
        Assertions.assertThat(matchTable.length).isEqualTo(7);
        Assertions.assertThat(matchTable).isInstanceOf(int[].class);
    }

    @Test
    @DisplayName("매치테이블이 전부 0이면 0을 즉시 반환한다")
    void calculateEarningsRateZero() {
        int[] matchTable = {0, 0, 0, 0, 0, 0, 0};
        double earningsRate = analyzer.calculateEarningsRate(matchTable);
        Assertions.assertThat(earningsRate).isZero();
    }

    @Test
    @DisplayName("매치테이블을 입력하면 수익률을 반환한다. 1등이므로 수익률은 200만이다")
    void calculateEarningsRate() {
        int[] matchTable = analyzer.getMatchTable(new int[]{1, 2, 3, 4, 5, 6});
        double earningsRate = analyzer.calculateEarningsRate(matchTable);
        Assertions.assertThat(earningsRate).isEqualTo(2_000_000.0);
    }
}
