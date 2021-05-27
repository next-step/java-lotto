package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @Test
    public void 로또번호_생성() {
        LottoNumber number = new LottoNumber(new RandomNumber());
    }

    @Test
    public void equals중복체크() {
        LottoNumber number1 = new LottoNumber(new CustomNumber(1));
        LottoNumber number2 = new LottoNumber(new CustomNumber(1));
        LottoNumber number3 = new LottoNumber(new CustomNumber(2));

        assertThat(number1.equals(number2)).isTrue();
        assertThat(number1.equals(number3)).isFalse();
    }

    @Test
    public void set중복체크() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int i = 1 ; i < 5; i++) {
            LottoNumber number = new LottoNumber(new CustomNumber(i));
            lottoNumbers.add(number);
        }

        for (int i = 1 ; i < 5; i++) {
            LottoNumber number = new LottoNumber(new CustomNumber(i));
            lottoNumbers.add(number);
        }

        assertThat(lottoNumbers.size()).isEqualTo(4);
    }

    @Test
    public void 출력() {
        assertThat(new LottoNumber(new CustomNumber(31)).toString()).isEqualTo("31");
    }

}
