package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(
            List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 4, 9, 10, 40)),
                new Lotto(List.of(1, 2, 3, 12, 17, 30))
        ));
    }

    @DisplayName("당첨 번호와 3~6개 일치하는 로또의 개수 구하기")
    @Test
    void collectAccordanceCountTest() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        AccordanceCount result = lottoStatistics.collectAccordanceCount(lottos, winningNumbers);

        assertThat(result.getCountsByWinningAccordanceInSequence()).hasSize(4);
    }

    @DisplayName("수익률 구하기")
    @Test
    void calculateProfitRatioTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(50000);
        LottoStatistics lottoStatistics = new LottoStatistics();
        AccordanceCount accordanceCount = new AccordanceCount(
                Map.of(
                    WinningAccordance.THREE,
                    3L,
                    WinningAccordance.FOUR,
                    1L,
                    WinningAccordance.FIVE,
                    0L,
                    WinningAccordance.SIX,
                    0L
        ));

        double result = lottoStatistics.calculateProfitRatio(accordanceCount, purchaseMoney);

        assertThat(result).isEqualTo(1.3);
    }

}