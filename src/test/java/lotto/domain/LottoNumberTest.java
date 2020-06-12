package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    void equalsTest(){
        // given
        LottoNumber lottoNumber1 = new LottoNumber(9);
        LottoNumber lottoNumber2 = new LottoNumber(9);

        // when
        boolean isEqual = lottoNumber1.equals(lottoNumber2);

        // then
        assertThat(isEqual).isTrue();
    }

    @Test
    void sortingTest(){
        // given
        LottoNumber lottoNumber1 = new LottoNumber(2);
        LottoNumber lottoNumber2 = new LottoNumber(3);
        LottoNumber lottoNumber3 = new LottoNumber(1);
        List<LottoNumber> list = Arrays.asList(lottoNumber1, lottoNumber2, lottoNumber3);

        // when
        list.sort(LottoNumber::compareTo);

        // then
        assertThat(list).isSorted();
    }

    @Test
    void containsTest(){
        // given
        LottoNumber lottoNumber1 = new LottoNumber(2);
        LottoNumber lottoNumber2 = new LottoNumber(3);
        LottoNumber lottoNumber3 = new LottoNumber(1);
        Set<LottoNumber> list = new HashSet<>(Arrays.asList(lottoNumber1, lottoNumber2, lottoNumber3));

        // when
        boolean hasNumber = list.contains(new LottoNumber(3));

        assertThat(hasNumber).isTrue();
    }
}
