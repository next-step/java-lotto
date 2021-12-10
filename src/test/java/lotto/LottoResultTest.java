package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void get_winnerCount() {
        // given
        Map<Integer, Integer> winResult = new HashMap<Integer, Integer>() {{
            put(1, 1);
            put(2, 1);
            put(3, 5);
            put(4, 5);
        }};
        LottoResult lottoResult = new LottoResult(winResult);

        // expect
        assertThat(lottoResult.askWinnerCount(1)).isEqualTo(1);
        assertThat(lottoResult.askWinnerCount(2)).isEqualTo(1);
        assertThat(lottoResult.askWinnerCount(3)).isEqualTo(5);
        assertThat(lottoResult.askWinnerCount(4)).isEqualTo(5);
    }

    @Test
    void updateMatchCount() {
        // given
        Map<Integer, Integer> winResult = new HashMap<Integer, Integer>() {{
            put(3, 1);
        }};
        Lotto lotto1 = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = new Lotto("4, 5, 6, 7, 8, 9");

        LottoResult lottoResult = new LottoResult(winResult);

        // when
        lottoResult.updateMatchCount(lotto1, lotto2);

        // then
        assertThat(lottoResult.askWinnerCount(3)).isEqualTo(2);
    }

    @Test
    void calculateProfit() {
        // given
        int lottoSize = 1;
        Money lottoPrice = new Money(1000);

        Map<Integer, Integer> matchCount = new HashMap<Integer, Integer>() {{
            put(3, 1);
        }};
        LottoResult lottoResult = new LottoResult(matchCount);

        // when
        lottoResult.updateProfit(lottoSize, lottoPrice);

        // then
        assertThat(lottoResult.getProfit()).isEqualTo(5);
    }
}