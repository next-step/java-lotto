package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("1등 1개, 2등 당첨 1개 인경우")
    @Test
    void getLottoResult() {
        List<Prize> prizes =Arrays.asList(
                Prize.FIRST,
                Prize.SECOND);

        Map<Prize,Integer> result = LottoResult.of(prizes);

        assertThat(result.get(Prize.FIRST)).isEqualTo(1);
        assertThat(result.get(Prize.SECOND)).isEqualTo(1);
    }

    @DisplayName("1등 2개, 꽝이 1개인 경우")
    @Test
    void getLottoResult_() {
        List<Prize> prizes =Arrays.asList(
                Prize.FIRST,
                Prize.FIRST,
                Prize.NONE);

        Map<Prize,Integer> result = LottoResult.of(prizes);

        assertThat(result.get(Prize.FIRST)).isEqualTo(2);
        assertThat(result.get(Prize.NONE)).isEqualTo(1);
    }
}
