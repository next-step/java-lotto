package lotto.domain;

import lotto.constant.Constant;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {
    @Test
    void 매치() {
        Lottos lottos = new Lottos(
                List.of(
                    new Lotto(List.of(1,2,3,7,8,9)),
                    new Lotto(List.of(1,2,3,4,8,9)),
                    new Lotto(List.of(1,2,3,4,5,6))
                )
        );
        List<Number> winNumbers = new Winning().createWinNumbers("1,2,3,4,5,6");
        HashMap<Integer, Integer> matchResult = LottoMatch.match(lottos, winNumbers);

        assertThat(matchResult.get(Constant.FOURTH_PLACE)).isEqualTo(1);
        assertThat(matchResult.get(Constant.THIRD_PLACE)).isEqualTo(1);
        assertThat(matchResult.get(Constant.SECOND_PLACE)).isEqualTo(0);
        assertThat(matchResult.get(Constant.FIRST_PLACE)).isEqualTo(1);
    }
}
