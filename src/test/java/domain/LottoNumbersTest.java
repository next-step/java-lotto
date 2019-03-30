package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumbersTest {
    private LottoNumbers lottoNumbers;

    @Before
    public void lottoNumbers() {
        lottoNumbers = new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(4), new LottoNo(5), new LottoNo(18), new LottoNo(20), new LottoNo(25)));
    }

    @Test
    public void isContains_true_test() {
        assertThat(lottoNumbers.isContains(new LottoNo(4))).isTrue();
    }

    @Test
    public void isContains_false_test() {
        assertThat(lottoNumbers.isContains(new LottoNo(6))).isFalse();
    }

}