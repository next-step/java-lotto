package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @DisplayName("서로다른 로또번호 6개 주입시 size()가 6개로 리턴하는지")
    @Test
    void different_lotto_numbers() {
        //given
        int expected = 6;

        //when
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        //then
        assertThat(lottoNumbers.size()).isEqualTo(expected);
    }

    @DisplayName("중복된 로또번호 6개 주입시 Exception 발생하는지")
    @Test
    void equals_lotto_numbers_exception() {
        assertThatIllegalArgumentException().isThrownBy(()->{
            new LottoNumbers(Arrays.asList(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(2),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            ));
        });
    }

    @DisplayName("로또번호 6개 미만으로 주입시 Exception 발생하는지")
    @Test
    void lotto_number_less_than_6_exception() {
        assertThatIllegalArgumentException().isThrownBy(()->{
            new LottoNumbers(Arrays.asList(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5)
            ));
        });
    }
}
