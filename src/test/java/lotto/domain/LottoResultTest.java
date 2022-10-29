package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoResultTest {

    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @Test
    @DisplayName("로또 결과 생성")
    void create() {
        assertAll(
                () -> assertThat(lottoResult.getResultByRank(Rank.FIRST))
                        .isEqualTo(0),
                () -> assertThat(lottoResult.getResultByRank(Rank.BONUS))
                        .isEqualTo(0),
                () -> assertThat(lottoResult.getResultByRank(Rank.SECOND))
                        .isEqualTo(0),
                () -> assertThat(lottoResult.getResultByRank(Rank.THIRD))
                        .isEqualTo(0),
                () -> assertThat(lottoResult.getResultByRank(Rank.FOURTH))
                        .isEqualTo(0)
        );
    }

    @Test
    @DisplayName("지정된 랭크 당첨 개수 증가")
    void addWinningResultTest() {
        lottoResult.addWinningResult(Rank.FIRST);
        assertThat(lottoResult.getResultByRank(Rank.FIRST))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("당첨금 확률값 반환")
    void calculatePrizeRateTest() {
        lottoResult.addWinningResult(Rank.FOURTH);
        PaidAmount paidAmount = new PaidAmount(6000);

        lottoResult.calculatePrizeRate(paidAmount);

        assertThat(lottoResult.getPrizeRate())
                .isEqualTo("0.83");
    }
}
