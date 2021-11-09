package lotto.service.model;

import lotto.service.domain.types.Rank;
import lotto.service.value.LottoPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {


    private Map<Rank, Integer> lottoResult;

    @BeforeEach
    void setup() {
        lottoResult = new HashMap<Rank, Integer>() {{
            put(Rank.FIRST, 1);
            put(Rank.THIRD, 2);
            put(Rank.FOURTH, 3);
            put(Rank.FIFTH, 4);
            put(Rank.MISS, 5);
        }};
    }

    @ParameterizedTest
    @CsvSource(value = {
            " FIRST|     1",
            " THIRD|     2",
            "FOURTH|     3",
            " FIFTH|     4",
            "  MISS|     5"
    }, delimiter = '|')
    @DisplayName("로또 등수에 따른 당첨 횟수 검증")
    void getCountOfMatch(Rank rank, Integer expected) {
        LottoResult result = LottoResult.from(lottoResult);
        assertThat(result.getCountOfMatch(rank)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            " 2003170000|   이익",
            " 2003160000|   이익",
            " 2003175000|   손해",
    }, delimiter = '|')
    @DisplayName("손해 또는 이익 검증")
    void getProfitOrLoss(Integer lottoPrice, String expected) {
        LottoResult result = LottoResult.from(lottoResult);
        assertThat(result.getProfitOrLoss(LottoPrice.from(lottoPrice))).isEqualTo(expected);
    }
}
