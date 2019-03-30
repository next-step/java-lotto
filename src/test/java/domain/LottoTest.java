package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void lottoTest() {
        lotto = new Lotto(new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(3), new LottoNo(5), new LottoNo(15), new LottoNo(30), new LottoNo(31))));
    }

    @Test
    public void isContains_false_Test() {
        assertThat(lotto.isContains(new LottoNo(2))).isFalse();
    }

    @Test
    public void isContains_true_Test() {
        assertThat(lotto.isContains(new LottoNo(1))).isTrue();
    }

}