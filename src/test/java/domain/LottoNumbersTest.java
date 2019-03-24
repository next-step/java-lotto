package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumbersTest {
    private LottoNumbers lottoNumbers;

    @Before
    public void lottoNumbers() {
        lottoNumbers = new LottoNumbers(Arrays.asList(1, 4, 5, 18, 20, 25));
    }

    @Test
    public void isContains_true_test() {
        assertThat(lottoNumbers.isContains(4)).isTrue();
    }

    @Test
    public void isContains_false_test() {
        assertThat(lottoNumbers.isContains(6)).isFalse();
    }

}