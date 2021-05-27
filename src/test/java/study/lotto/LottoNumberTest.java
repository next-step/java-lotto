package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.StringAddCalculator;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 번호는 1~45 사이이다.")
    @Test
    public void lottoNumberTest(){
        LottoNumber firstNumber = new LottoNumber(1);
        assertThat(firstNumber.value()).isEqualTo(1);

        LottoNumber lastNumber = new LottoNumber(45);
        assertThat(lastNumber.value()).isEqualTo(45);

        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("오름차순 정렬")
    @Test
    public void sortTest(){
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));

        Collections.sort(lottoNumbers);

        assertThat(lottoNumbers).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }


}
