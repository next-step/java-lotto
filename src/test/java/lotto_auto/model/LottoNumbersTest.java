package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
                    LottoNumbers lottoNumbers = new LottoNumbers(null);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개가 아닐때 예외 발생 테스트")
    @Test
    public void lottoNumberCountExceptionTest() {

        List<Integer> numberList  = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        assertThatThrownBy(
                () -> {
                    LottoNumbers lottoNumbers = new LottoNumbers(numberList);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 중복 예외 발생 테스트")
    @Test
    public void lottoNumberDuplicateExceptionTest() {

        List<Integer> numberList  = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(5);
        assertThatThrownBy(
                () -> {
                    LottoNumbers lottoNumbers = new LottoNumbers(numberList);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 일치 테스트")
    @Test
    public void lottoNumberMatchTest() {

        List<Integer> numberList  = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(6);
        LottoNumbers lottoNumbers = new LottoNumbers(numberList);

        List<Integer> numberList2  = new ArrayList<>();
        numberList2.add(1);
        numberList2.add(2);
        numberList2.add(3);
        numberList2.add(4);
        numberList2.add(5);
        numberList2.add(6);
        LottoNumbers lottoNumbers2 = new LottoNumbers(numberList2);

        assertThat(lottoNumbers.computeMatchCount(lottoNumbers2)).isEqualTo(6);
    }

}
