package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoNumbersTest {

    @Test
    @DisplayName("contains 테스트: 해당 lottoNumber를 갖고있으면 true, 그렇지 않으면 false를 리턴한다.")
    void contains() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(2);
        LottoNumber lottoNumber3 = new LottoNumber(3);
        LottoNumber lottoNumber4 = new LottoNumber(4);
        LottoNumber lottoNumber5 = new LottoNumber(5);
        LottoNumber lottoNumber6 = new LottoNumber(6);
        LottoNumber lottoNumber7 = new LottoNumber(7);

        List<LottoNumber> lottoNumberList = Arrays.asList(
                lottoNumber1,
                lottoNumber2,
                lottoNumber3,
                lottoNumber4,
                lottoNumber5,
                lottoNumber6
        );

        LottoNumbers numbers = new LottoNumbers(lottoNumberList);

        assertTrue(numbers.contains(lottoNumber1));
        assertTrue(numbers.contains(lottoNumber2));
        assertTrue(numbers.contains(lottoNumber3));
        assertTrue(numbers.contains(lottoNumber4));
        assertTrue(numbers.contains(lottoNumber5));
        assertTrue(numbers.contains(lottoNumber6));
        assertFalse(numbers.contains(lottoNumber7));
    }

}
