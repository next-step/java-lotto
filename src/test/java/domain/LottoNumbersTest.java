package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumbersTest {
    private LottoNumbers lottoNumbers;

    @Before
    public void lottoNumbers() {
        lottoNumbers = LottoNumbers.convertToLottoNo(Arrays.asList(1, 4, 5, 18, 20, 25));
    }

    @Test
    public void isContains_true_test() {
        assertThat(lottoNumbers.isContains(LottoNo.of(4))).isTrue();
    }

    @Test
    public void isContains_false_test() {
        assertThat(lottoNumbers.isContains(LottoNo.of(6))).isFalse();
    }

    @Test
    public void 로또_6개일치() {
        assertThat(lottoNumbers.calcMatchCount(new Lotto(LottoNumbers.convertToLottoNo(Arrays.asList(1, 4, 5, 18, 20, 25))))).isEqualTo(6);
    }
}