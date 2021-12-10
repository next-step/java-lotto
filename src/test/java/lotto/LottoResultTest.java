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
        assertThat(lottoResult.winnerCount(1)).isEqualTo(1);
        assertThat(lottoResult.winnerCount(2)).isEqualTo(1);
        assertThat(lottoResult.winnerCount(3)).isEqualTo(5);
        assertThat(lottoResult.winnerCount(4)).isEqualTo(5);
    }

    @Test
    void update_lottoResult() {
        // given
        Map<Integer, Integer> winResult = new HashMap<Integer, Integer>() {{
            put(3, 1);
        }};
        Lotto lotto1 = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = new Lotto("4, 5, 6, 7, 8, 9");

        LottoResult lottoResult = new LottoResult(winResult);

        // when
        lottoResult.update(lotto1, lotto2);

        // then
        assertThat(lottoResult.winnerCount(3)).isEqualTo(2);
    }
}