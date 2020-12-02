package lotto.domain;

import lotto.domain.exception.NotValidLottoNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 10})
    public void createLottoNumber(int number) {
        //Given & When
        LottoNumber lottoNumber = LottoNumber.from(number);

        //Then
        assertThat(lottoNumber).isEqualTo(LottoNumber.from(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 50})
    public void notValidLottoNumber(int number) {
        assertThatThrownBy(() ->
                LottoNumber.from(number)
        ).isInstanceOf(NotValidLottoNumberException.class);
    }

    @Test
    public void findAllLottoNumbersMapToList() {
        //Given & When
        List<Integer> result = LottoNumber.findAllLottoNumbers();

        //Then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(45);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "2:2:2", "3:3:3"}, delimiter = ':')
    public void equalsTest(int number1, int number2, int number3) {
        //Given
        LottoNumber lottoNumber1 = LottoNumber.from(number1);
        LottoNumber lottoNumber2 = LottoNumber.from(number2);
        LottoNumber lottoNumber3 = LottoNumber.from(number3);

        assertThat(lottoNumber1).isEqualTo(lottoNumber2).isEqualTo(lottoNumber3);
    }

}
