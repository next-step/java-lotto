package lotto;

import exception.CustomException;
import lotto.exception.LottoErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoNumberTest {

    @Test
    @DisplayName("로또는 정해진 수안의 값만 뽑아낼 수 있다")
    void LottoNumberValue() {
        List<LottoNumber> lottoNumbersRange = LottoNumber.getLottoNumbersRange();

        int max = lottoNumbersRange.stream()
                .mapToInt(LottoNumber::getNumber)
                .max()
                .getAsInt();

        int min = lottoNumbersRange.stream()
                .mapToInt(LottoNumber::getNumber)
                .max()
                .getAsInt();

        assertAll(
                () -> assertThat(max).isLessThanOrEqualTo(LottoNumber.MAXIMUM_VALUE),
                () -> assertThat(min).isGreaterThanOrEqualTo(LottoNumber.MINIMUM_VALUE)
        );
    }

    @Test
    @DisplayName("int 타입으로 로또 숫자를 생성한다")
    void fromInt() {
        final int number = 5;
        LottoNumber lottoNumber = LottoNumber.from(number);
        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @Test
    @DisplayName("로도 숫자 객체로 로또 숫자를 생성한다")
    void fromLottoNumber() {
        LottoNumber lottoNumber = LottoNumber.from(5);
        LottoNumber fromLottoNumber = LottoNumber.from(lottoNumber);
        assertThat(lottoNumber).isEqualTo(fromLottoNumber);
    }

    @Test
    @DisplayName("문자열 배열로 로또 숫자를 생성한다")
    void fromLottoStringArray() {
        String[] stringLottoNumbers = {"1", "2", "3", "4", "5", "6"};
        List<Integer> intLottoNumbers = Arrays.stream(stringLottoNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        List<LottoNumber> fromLottoNumbers = LottoNumber.from(stringLottoNumbers);

        assertThat(fromLottoNumbers).extracting("number")
                .usingRecursiveComparison()
                .isEqualTo(intLottoNumbers);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 55})
    @DisplayName("로또 숫자의 범위를 넘어서는 수로는 로또 숫자를 생성할 수 없다")
    void maxValueFail(int num) {
        assertThatThrownBy(() -> LottoNumber.from(num))
                .isInstanceOf(CustomException.class)
                .hasMessage(LottoErrorCode.LOTTO_NUMBER_BAD_REQUEST.getMessage());
    }
}
