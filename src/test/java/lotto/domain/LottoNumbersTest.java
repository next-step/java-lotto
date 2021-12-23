package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Test
    @DisplayName("calculateMatchedNumberCount 테스트: 일치하는 number의 개수를 리턴한다.")
    void calculateMatchedNumberCount() {
        List<LottoNumber> lottoNumberList = IntStream.range(1, 11)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumbers lottoNumbers1 = new LottoNumbers(lottoNumberList.subList(0, 6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(lottoNumberList.subList(4, 10));

        assertEquals(2, lottoNumbers1.calculateMatchedNumberCount(lottoNumbers2));
        assertEquals(2, lottoNumbers2.calculateMatchedNumberCount(lottoNumbers1));
    }

    @Test
    @DisplayName("toString 테스트: 갖고있는 숫자들을 ', '로 조인하고 양쪽이 대괄호로 둘러쌓인 형태의 문자열을 리턴한다.")
    void toStringTest() {
        List<LottoNumber> lottoNumberList = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

        String expectedResult = "[1, 2, 3, 4, 5, 6]";

        assertEquals(expectedResult, lottoNumbers.toString());
    }

}
