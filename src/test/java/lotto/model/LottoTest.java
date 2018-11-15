package lotto.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void setup() {
        lotto = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void 일치하는_숫자_개수() {
        assertThat(3).isEqualTo(lotto.getMatchCount(new HashSet<>(Arrays.asList(1, 2, 3, 10, 20, 30))));
    }
}
