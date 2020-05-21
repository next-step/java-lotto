package lotto.ui;

import lotto.domain.rank.Ranks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.domain.rank.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class PrizeOutputViewTests {
    @DisplayName("Ranks를 전달 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Ranks ranks = Ranks.create(Arrays.asList(FIRST, SECOND));
        assertThat(new PrizeOutputView(ranks)).isNotNull();
    }
}
