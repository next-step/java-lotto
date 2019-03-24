package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumbersTest {
    private LottoNumbers lottoNumbers;

    @Before
    public void SET_UP() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        lottoNumbers = new LottoNumbers(numbers);
    }

    @Test
    public void 로또번호에_winning번호_포함되어있음() {
        assertThat(lottoNumbers.contains(1)).isEqualTo(true);
    }

    @Test
    public void 로또번호에_winning번호_미포함되어있음() {
        assertThat(lottoNumbers.contains(10)).isEqualTo(false);
    }
}
