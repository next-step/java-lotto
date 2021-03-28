package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LottoNumbersTest {

    @DisplayName("번호 생성 후 일치 테스트")
    @Test
    void lottoNumberMatchGeneratedNumber() {
        Set<Integer> numbers =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .collect(Collectors.toSet());
        LottoNumber lottoNumbers = new LottoNumber(numbers);

        Set<Integer> winnerNumber =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .collect(Collectors.toSet());
        LottoNumber winnerLottoNumbers = new LottoNumber(winnerNumber);

        assertEquals(lottoNumbers.getMatchCount(winnerLottoNumbers), 6);
    }

    @DisplayName("null 입력시 익셉션 발생")
    @Test
    void LottoNumberNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoNumber(null));
    }

    @DisplayName("값이 6자리가 아닐시 익셉션 발생")
    @Test
    void lottoNumberNotEqualsSize6() {
        Set<Integer> numbers =
                Stream.of(1, 2, 3, 4, 5)
                        .collect(Collectors.toSet());
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoNumber(numbers));
    }

    @DisplayName("로또번호가 1~45의 값을 벗어났을때 익셉션 발생")
    @Test
    void lottoNumberRangeOverTest() {
        Set<Integer> numbers =
                Stream.of(1, 2, 3, 4, 55)
                        .collect(Collectors.toSet());
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoNumber(numbers));
    }

}
