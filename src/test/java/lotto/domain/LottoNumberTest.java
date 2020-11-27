package lotto.domain;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    public void createLottoNumber() {
        //Given & When
        LottoNumber lottoNumber =LottoNumber.from(new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 10)));

        //Then
        assertThat(lottoNumber.getLottoNumber()).contains(1, 3, 5, 6, 7, 10);
    }

    @ParameterizedTest
    @MethodSource("notValidLottoNumber")
    public void notValidLottoNumberTest(Set<Integer> numbers){
        assertThatThrownBy(() ->
               LottoNumber.from(numbers)
        ).isInstanceOf(NotValidLottoNumberException.class)
        .hasMessage(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());

    }

    private static Stream<Arguments> notValidLottoNumber(){
        return Stream.of(
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 6, 13))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 55, 60)))
        );
    }
}
