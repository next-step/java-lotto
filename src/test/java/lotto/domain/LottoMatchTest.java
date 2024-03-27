package lotto.domain;

import lotto.constant.Constant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {
    @ParameterizedTest
    @CsvSource(value = {"5000:1", "50000:1", "1500000:0", "2000000000:1"}, delimiter = ':')
    void 매치(int place, int matchCount) {
        Lottos lottos = new Lottos(
                List.of(
                    new Lotto(List.of(1,2,3,7,8,9)),
                    new Lotto(List.of(1,2,3,4,8,9)),
                    new Lotto(List.of(1,2,3,4,5,6))
                )
        );
        List<Integer> winNumbers = new Winning().createWinNumbers("1,2,3,4,5,6");
        HashMap<Integer, Integer> matchResult = LottoMatch.match(lottos, winNumbers);

        assertThat(matchResult.get(place)).isEqualTo(matchCount);
    }
}
