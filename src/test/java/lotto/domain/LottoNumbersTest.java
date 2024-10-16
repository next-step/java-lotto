package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoNumbersTest {

    @Test
    void create_inputValidation_numberSize() {
        Assertions.assertThatThrownBy(() -> getLottoNumbers(new int[]{1, 2, 3, 4, 5})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_inputValidation_duplication() {
        Assertions.assertThatThrownBy(() -> getLottoNumbers(new int[]{1, 2, 3, 4, 4,6})).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void create_normal() {
        LottoNumbers lottoNumbers = getLottoNumbers(new int[]{1, 2, 3, 4, 5, 6});
        LottoNumbers lottoNumbers1 = new LottoNumbers(Arrays.asList(
                new LottoNumber(1)
                ,new LottoNumber(2)
                ,new LottoNumber(3)
                ,new LottoNumber(4)
                ,new LottoNumber(5)
                ,new LottoNumber(6)

        )) ;
        Assertions.assertThat(lottoNumbers).isEqualTo(lottoNumbers1);
    }

    @Test
    void contains() {
        LottoNumbers lottoNumbers = getLottoNumbers(new int[]{1, 2, 3, 4, 5, 6});
        Assertions.assertThat(lottoNumbers.contains(new LottoNumber(2))).isEqualTo(true);
    }

    private LottoNumbers getLottoNumbers(int [] ints) {
        return  new LottoNumbers(ints);
    }
}
