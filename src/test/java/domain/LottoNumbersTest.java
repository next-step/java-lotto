package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumbersTest {
    private LottoNumbers lottoNumbers;

    @Before
    public void setUp() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        lottoNumbers = LottoNumbers.createInstance(numbers);
    }

    @Test
    public void 로또번호에_winning번호_포함되어있음() {
        assertThat(lottoNumbers.contains(Number.createInstance(1))).isEqualTo(true);
    }

    @Test
    public void 로또번호에_winning번호_미포함되어있음() {
        assertThat(lottoNumbers.contains(Number.createInstance(10))).isEqualTo(false);
    }
}
