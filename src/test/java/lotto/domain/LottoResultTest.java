package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        List<Rank> matchRanks = Arrays.asList(Rank.FOURTH);
        lottoResult = LottoResult.of(matchRanks);
    }

    @DisplayName("Rank에 따른 개수 가져오기 테스트")
    @Test
    void countOfMathRanks() {
        assertThat(lottoResult.countOfMathRanks(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.countOfMathRanks(Rank.THIRD)).isEqualTo(0);
        assertThat(lottoResult.countOfMathRanks(Rank.SECOND)).isEqualTo(0);
        assertThat(lottoResult.countOfMathRanks(Rank.FIRST)).isEqualTo(0);
    }

    @DisplayName("총 당첨 금액 테스트")
    @Test
    void totalPrizeOfMathRanks() {
        assertThat(lottoResult.totalPrizeOfMathRanks()).isEqualTo(50000);
    }

    @DisplayName("수익률 계산하기")
    @Test
    void getRateOfLottoGame() {
        assertThat(lottoResult.rateOfTotalPrize()).isEqualTo(50.0);
    }
}
