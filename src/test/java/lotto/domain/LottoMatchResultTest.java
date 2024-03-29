package lotto.domain;

import lotto.domain.LottoMatchResult;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchResultTest {
    @Test
    void put() {
        LottoMatchResult.putMatchResult(Rank.FIRST);
        assertThat(LottoMatchResult.getMatchResult().get(Rank.FIRST)).isEqualTo(1);
    }

}
