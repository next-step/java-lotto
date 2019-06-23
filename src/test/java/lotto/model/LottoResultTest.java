package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("1등 2개, 2등 당첨 1개 인경우")
    @Test
    void getLottoResult() {
        List<Prize> prizes =Arrays.asList(
                Prize.FIRST,
                Prize.FIRST,
                Prize.SECOND);

        LottoResult result = LottoResult.of(prizes);

        assertThat(result.getCount(Prize.FIRST)).isEqualTo(2);
        assertThat(result.getCount(Prize.SECOND)).isEqualTo(1);
    }

}
