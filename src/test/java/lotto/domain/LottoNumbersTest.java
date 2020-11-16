package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoNumbersTest {

    @Test
    @DisplayName("로또 넘버 일급객체에 6개 이상의 LottoNumber 가 적재될 경우 예외 상황발생 ")
    void lottoNumbers_OverSizeNumbers_ThrownByException() {
        List<LottoNumber> numbers = IntStream.rangeClosed(1,7)
                .mapToObj(LottoNumber::get)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> {
            LottoNumbers lottoNumbers = LottoNumbers.set(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
