package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @DisplayName("로또 번호가 null 일때 예외 발생 테스트")
    @Test
    public void lottoNumberNullExceptionTest() {
        assertThatThrownBy(
                () -> {
                    LottoNumbers lottoNumbers = new LottoNumbers((List<LottoNumber>) null);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 문자열이 null or em일때 예외 발생 테스트")
    @Test
    public void lottoNumberNullOrEmptyExceptionTest() {
        assertThatThrownBy(
                () -> {
                    LottoNumbers lottoNumbers = new LottoNumbers((String) null);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개가 아닐때 예외 발생 테스트")
    @Test
    public void lottoNumberCountExceptionTest() {

        List<LottoNumber> numberList  = new ArrayList<>();
        numberList.add(new LottoNumber(1));
        numberList.add(new LottoNumber(2));
        numberList.add(new LottoNumber(3));
        numberList.add(new LottoNumber(4));
        numberList.add(new LottoNumber(5));
        assertThatThrownBy(
                () -> {
                    LottoNumbers lottoNumbers = new LottoNumbers(numberList);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 중복 예외 발생 테스트")
    @Test
    public void lottoNumberDuplicateExceptionTest() {

        List<LottoNumber> numberList  = new ArrayList<>();
        numberList.add(new LottoNumber(1));
        numberList.add(new LottoNumber(2));
        numberList.add(new LottoNumber(3));
        numberList.add(new LottoNumber(4));
        numberList.add(new LottoNumber(5));
        numberList.add(new LottoNumber(5));
        assertThatThrownBy(
                () -> {
                    LottoNumbers lottoNumbers = new LottoNumbers(numberList);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 일치 테스트")
    @Test
    public void lottoNumberMatchTest() {

        List<LottoNumber> numberList  = new ArrayList<>();
        numberList.add(new LottoNumber(1));
        numberList.add(new LottoNumber(2));
        numberList.add(new LottoNumber(3));
        numberList.add(new LottoNumber(4));
        numberList.add(new LottoNumber(5));
        numberList.add(new LottoNumber(6));
        LottoNumbers lottoNumbers = new LottoNumbers(numberList);

        List<LottoNumber> numberList2  = new ArrayList<>();
        numberList2.add(new LottoNumber(1));
        numberList2.add(new LottoNumber(2));
        numberList2.add(new LottoNumber(3));
        numberList2.add(new LottoNumber(4));
        numberList2.add(new LottoNumber(5));
        numberList2.add(new LottoNumber(6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(numberList2);

        assertThat(lottoNumbers.computeMatchCount(lottoNumbers2)).isEqualTo(6);
    }

    @DisplayName("로또 번호 문자열로 생성할때 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(
            strings = {
                    "1,2,3,4,5,49",
                    "123,4,5,6",
                    "-1,2,3,4,5,6",
            }
    )
    public void lottoNumberCreateTest(String lottoNumberString) {
        assertThatThrownBy(() -> {
            LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberString);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
