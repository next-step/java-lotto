package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-08 01:19
 */
public class LottoWinningAmountTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5,6})
    void 매치카운터에_맞는_등수_찾기(int matchCount) {
        LottoWinningAmount lottoWinningAmount = Arrays.stream(LottoWinningAmount.values())
                .filter(winningAmount -> winningAmount.isEqualMatchCount(matchCount))
                .findFirst().orElse(LottoWinningAmount.LOSING_TICKET);

        assertThat(lottoWinningAmount).isEqualTo(LottoWinningAmount.FIRST);
    }

    @Test
    void is_equal_match_count() {
        LottoWinningAmount lottoWinningAmount = LottoWinningAmount.FIRST;
        assertThat(lottoWinningAmount.isEqualMatchCount(6)).isTrue();
    }
}
