package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LottoNumbersTest {

    @Test
    @DisplayName("생성자 테스트: startInclusive ~ endInclusive를 범위의 LottoNumber를 포함하는 LottoNumbers를 생성한다.")
    void create() {
        int startInclusive = 1;
        int endInclusive = 45;

        LottoNumbers lottoNumbers = new LottoNumbers(startInclusive, endInclusive);

        for (int i=startInclusive ; i<=endInclusive ; i++) {
            assertTrue(lottoNumbers.contains(new LottoNumber(i)));
        }

        int expectedSize = endInclusive - startInclusive + 1;
        assertEquals(expectedSize, lottoNumbers.size());
    }

    @Test
    @DisplayName("take 테스트: 앞의 n개의 LottoNumber들을 포함한 LottoNumbers를 리턴한다.")
    void take() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(3);
        LottoNumber lottoNumber3 = new LottoNumber(2);

        LottoNumbers numbers = new LottoNumbers(Arrays.asList(lottoNumber1, lottoNumber2, lottoNumber3));

        LottoNumbers expectedResult = new LottoNumbers(Arrays.asList(lottoNumber1, lottoNumber2));

        LottoNumbers result = numbers.take(2);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("sort 테스트: 오름차순으로 정렬된 LottoNumber들을 포함한 LottoNumbers를 리턴한다.")
    void sort() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(3);
        LottoNumber lottoNumber3 = new LottoNumber(2);

        LottoNumbers numbers = new LottoNumbers(Arrays.asList(lottoNumber1, lottoNumber2, lottoNumber3));

        LottoNumbers expectedResult = new LottoNumbers(Arrays.asList(lottoNumber1, lottoNumber3, lottoNumber2));

        LottoNumbers result = numbers.sort();

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("contains 테스트: 해당 lottoNumber를 갖고있으면 true, 그렇지 않으면 false를 리턴한다.")
    void contains() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(3);
        LottoNumber lottoNumber3 = new LottoNumber(2);

        LottoNumbers numbers = new LottoNumbers(Arrays.asList(lottoNumber1, lottoNumber2));

        assertTrue(numbers.contains(lottoNumber1));
        assertTrue(numbers.contains(lottoNumber2));
        assertFalse(numbers.contains(lottoNumber3));
    }

    @Test
    @DisplayName("size 테스트: 포함하고 있는 LottoNumber의 갯수를 리턴한다.")
    void size() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(3);
        LottoNumber lottoNumber3 = new LottoNumber(2);

        LottoNumbers numbers = new LottoNumbers(Arrays.asList(lottoNumber1, lottoNumber2, lottoNumber3));

        assertEquals(3, numbers.size());
    }

}
