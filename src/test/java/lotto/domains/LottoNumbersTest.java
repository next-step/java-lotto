package lotto.domains;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumbersTest {
    @Test
    void 생성자_테스트() {
        assertThat(new LottoNumbers("1,2,3,4,5,6"));
        assertThat(new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "6,true", "7,false"}, delimiter = ',')
    void 특정숫자가_포함되어있는지_테스트(int targetNumber, boolean expected) {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
        assertThat(lottoNumbers.contains(LottoNumber.of(targetNumber))).isEqualTo(expected);
    }

    @Test
    void 로또번호_중복숫자_에러_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(46))));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers("1,1,3,4,5,45"));
    }

    @Test
    void 로또번호_숫자갯수_에러_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5))));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6), LottoNumber.of(7))));

        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers("1,1,3,4,5,6,7"));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers("1,1,3,4,5"));
    }

    @Test
    void 불변객체_학습테스트() {
        List<LottoNumber> numberList = new ArrayList<>();
        numberList.add(LottoNumber.of(1));
        numberList.add(LottoNumber.of(2));
        numberList.add(LottoNumber.of(3));
        numberList.add(LottoNumber.of(4));
        numberList.add(LottoNumber.of(5));
        numberList.add(LottoNumber.of(6));
        LottoNumbers lottoNumbers = new LottoNumbers(numberList);

        assertThrows(UnsupportedOperationException.class, () -> lottoNumbers.lottoNumbers().add(LottoNumber.of(7)));
        assertThat(numberList.contains(7)).isFalse();
        assertThat(lottoNumbers.lottoNumbers().contains(7)).isFalse();
        assertThat(numberList).isNotSameAs(lottoNumbers.lottoNumbers());
    }

    private static Stream<Arguments> provideListAndExpectedNumber() {
        return Stream.of(
                Arguments.of(new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))), 6),
                Arguments.of(new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(16))), 5),
                Arguments.of(new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(15), LottoNumber.of(16))), 4),
                Arguments.of(new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(14), LottoNumber.of(15), LottoNumber.of(16))), 3),
                Arguments.of(new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(13), LottoNumber.of(14), LottoNumber.of(15), LottoNumber.of(16))), 2),
                Arguments.of(new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(12), LottoNumber.of(13), LottoNumber.of(14), LottoNumber.of(15), LottoNumber.of(16))), 1),
                Arguments.of(new LottoNumbers(Arrays.asList(LottoNumber.of(11), LottoNumber.of(12), LottoNumber.of(13), LottoNumber.of(14), LottoNumber.of(15), LottoNumber.of(16))), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideListAndExpectedNumber")
    void 일치하는_숫자_리턴_테스트(LottoNumbers lottoNumbers, int expectedMatchCount) {
        LottoNumbers winningLottoNumbers = new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
        assertThat(lottoNumbers.matchingNumberCount(winningLottoNumbers)).isEqualTo(expectedMatchCount);
    }
}
