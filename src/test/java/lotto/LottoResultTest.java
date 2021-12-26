package lotto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void init() {
        // given
        Map<Rank, Integer> matchCount = new HashMap<Rank, Integer>() {{
            put(Rank.MISS, 2);
            put(Rank.SECOND, 1);
            put(Rank.FIRST, 1);
        }};

        LottoResult expectedLottoResult = new LottoResult(
                new HashMap<Rank, Integer>() {{
                    put(Rank.MISS, 2);
                    put(Rank.FIFTH, 0);
                    put(Rank.FOURTH, 0);
                    put(Rank.THIRD, 0);
                    put(Rank.SECOND, 1);
                    put(Rank.FIRST, 1);
                }}
        );

        // when
        LottoResult lottoResult = new LottoResult(matchCount);

        // then
        assertThat(lottoResult).isEqualTo(expectedLottoResult);
    }

    @Test
    void getWinnersLottoResult() {
        // given
        Map<Rank, Integer> matchCount = new HashMap<Rank, Integer>() {{
            put(Rank.MISS, 2);
            put(Rank.SECOND, 1);
            put(Rank.FIRST, 1);
        }};
        LottoResult lottoResult = new LottoResult(matchCount);

        Map<Rank, Integer> expectedWinnersLottoResult = new HashMap<Rank, Integer>(){{
            put(Rank.FIFTH, 0);
            put(Rank.FOURTH, 0);
            put(Rank.THIRD, 0);
            put(Rank.SECOND, 1);
            put(Rank.FIRST, 1);
        }};

        // when
        Map<Rank, Integer> winnersLottoResult = lottoResult.getWinnersLottoResult();

        // then
        assertThat(winnersLottoResult).isEqualTo(expectedWinnersLottoResult);
    }

    @Test
    void calculateProfit() {
        // given
        Money lottoUnitPrice = new Money(1000);
        Map<Rank, Integer> matchCount = new HashMap<Rank, Integer>() {{
            put(Rank.MISS, 2);
            put(Rank.SECOND, 1);
            put(Rank.FIRST, 1);
        }};
        LottoResult lottoResult = new LottoResult(matchCount);
        BigDecimal expectedProfit = new BigDecimal("507500.000");

        // when
        BigDecimal profit = lottoResult.calculateProfit(lottoUnitPrice);

        // then
        assertThat(profit).isEqualTo(expectedProfit);
    }

}
