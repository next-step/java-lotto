package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 12, 17, 30))
        ));
    }

    @DisplayName("당첨 번호와 3~6개 일치하는 로또의 개수 구하기")
    @Test
    void collectAccordanceCountTest() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);

        AccordanceCount result = lottoStatistics.collectAccordanceCount(lottos, winningNumbers, bonusNumber);

        assertSoftly(softAssertions -> {
            softAssertions.assertThat(result.getCountsByWinningAccordanceInSequence().get(0)).extracting(Map.Entry::getValue).isEqualTo(1L);
            softAssertions.assertThat(result.getCountsByWinningAccordanceInSequence().get(1)).extracting(Map.Entry::getValue).isEqualTo(0L);
            softAssertions.assertThat(result.getCountsByWinningAccordanceInSequence().get(2)).extracting(Map.Entry::getValue).isEqualTo(0L);
            softAssertions.assertThat(result.getCountsByWinningAccordanceInSequence().get(3)).extracting(Map.Entry::getValue).isEqualTo(1L);
            softAssertions.assertThat(result.getCountsByWinningAccordanceInSequence().get(4)).extracting(Map.Entry::getValue).isEqualTo(1L);
        });
    }

    @DisplayName("수익률 구하기")
    @Test
    void calculateProfitRatioTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(50000);
        LottoStatistics lottoStatistics = new LottoStatistics();
        AccordanceCount accordanceCount = new AccordanceCount(Map.of(
            WinningAccordance.FIFTH,
            3L,
            WinningAccordance.FOURTH,
            1L,
            WinningAccordance.THIRD,
            0L,
            WinningAccordance.SECOND,
            0L,
            WinningAccordance.FIRST,
            0L
        ));

        double result = lottoStatistics.calculateProfitRatio(accordanceCount, purchaseMoney);

        assertThat(result).isEqualTo(1.3);
    }
}
