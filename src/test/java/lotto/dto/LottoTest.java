package lotto.dto;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 당첨숫자_카운트증가() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto.incrementMatchCount(3);
        assertThat(lotto.getMatchCount()).isEqualTo(1);
    }
}