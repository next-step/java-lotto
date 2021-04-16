package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("로또번호 6자리가 아닐 경우 테스트")
    void inputNumberTest(){

        Number number1 = new Number(3);
        Number number2 = new Number(11);
        Number number3 = new Number(12);
        Number number4 = new Number(31);
        Number number5 = new Number(34);
        Number number6 = new Number(35);
        Number number7 = new Number(36);

        List<Number> numberList = new ArrayList<>();

        numberList.add(number1);
        numberList.add(number2);
        numberList.add(number3);
        numberList.add(number4);
        numberList.add(number5);

        assertThatThrownBy(()-> new LottoNumber(numberList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 6자리 숫자를 입력해야합니다.");

        numberList.add(number5);
        numberList.add(number6);
        assertThatThrownBy(()-> new LottoNumber(numberList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 6자리 숫자를 입력해야합니다.");

    }


}
