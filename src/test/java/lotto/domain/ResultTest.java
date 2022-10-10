package lotto.domain;

import lotto.enumerate.Rank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private static final int NO_MATCH_NUMBER = -1;
    private static final int BONUS_NUMBER = 0;
    private static final int RATE_OF_INCOME_TO_ALL_WIN = 406311;
    private static LottoNumbersWrapper collectNumbers = new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static LottoWrapper lottoWrapper;

    @BeforeAll
    static void setLottoWrapper() {
        Lotto lotto1 = new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, BONUS_NUMBER)));
        Lotto lotto3 = new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, NO_MATCH_NUMBER)));
        Lotto lotto4 = new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, NO_MATCH_NUMBER, NO_MATCH_NUMBER)));
        Lotto lotto5 = new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, NO_MATCH_NUMBER, NO_MATCH_NUMBER, NO_MATCH_NUMBER)));
        lottoWrapper = new LottoWrapper(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5));
    }

    @Test
    @DisplayName("로또 당첨 결과가 제대로 저장되는지 테스트")
    void saveResultTest() {
        Result result = new Result(lottoWrapper, collectNumbers, BONUS_NUMBER);

        for (Rank rank : Rank.values()) {
            assertThat(result.getWinCount(rank)).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("수익률 테스트")
    void getTotalIncomeTest() {
        Result allWinResult = new Result(lottoWrapper, collectNumbers, BONUS_NUMBER);
        Result anyWinResult = new Result(lottoWrapper, new LottoNumbersWrapper(Collections.EMPTY_LIST), BONUS_NUMBER);

        assertThat(allWinResult.getRateOfIncome()).isEqualTo(RATE_OF_INCOME_TO_ALL_WIN);
        assertThat(anyWinResult.getRateOfIncome()).isEqualTo(0);
    }


}