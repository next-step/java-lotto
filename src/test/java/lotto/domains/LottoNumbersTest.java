package lotto.domains;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumbersTest {
    @ParameterizedTest
    @CsvSource(value = {"1,true","6,true","0,false","7,false"}, delimiter = ',')
    void 특정숫자가_포함되어있는지_테스트(int targetNumber, boolean expected) {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoNumbers.contains(targetNumber)).isEqualTo(expected);
    }

    @Test
    void 로또번호_0이하_45이상숫자_에러_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(1,2,3,4,5,46)));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(0,2,3,4,5,45)));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(-1,2,3,4,5,45)));
    }

    @Test
    void 로또번호_중복숫자_에러_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(1,1,3,4,5,46)));
    }

    @Test
    void 로또번호_숫자갯수_에러_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(1,1,3,4,5)));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(1,1,3,4,5,6,7)));
    }


}
