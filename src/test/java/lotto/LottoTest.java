package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void 로또번호생성() {
        Lotto lotto = new Lotto(3);
        assertThat(lotto.toString().split("],").length).isEqualTo(3);
    }

    /*
    for(char c: t.toCharArray()){
            tm.put(c,tm.getOrDefault(c,0)+1);
        }
    */
    @Test
    void 당첨자찾기() {
        Integer[][] answer = {{1, 2, 3, 4, 5, 6}};
        Lotto lotto = new Lotto(answer);

        HashMap<String, Integer> winners = new HashMap<>();
        winners.put("6개", 1);
        lotto.findWinners(answer[0]);
        assertThat(lotto.getWinners()).isEqualTo(winners);
    }

    @Test
    void 총수익률계산() {

    }
}