package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void lottoTest() throws Exception {
        lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 3, 5, 15, 30, 31)));
    }

    @Test
    public void isContains_false_Test() {
        assertThat(lotto.isContains(2)).isFalse();
    }

    @Test
    public void isContains_true_Test() {
        assertThat(lotto.isContains(1)).isTrue();
    }

}