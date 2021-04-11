package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WinLottoNumberTest {

    private WinLottoNumber winLottoNumber;

    @BeforeEach
    void SetUp() {

        Number number1 = new Number(3);
        Number number2 = new Number(11);
        Number number3 = new Number(12);
        Number number4 = new Number(31);
        Number number5 = new Number(34);
        Number number6 = new Number(41);

        List<Number> winLottoNumberList = new ArrayList<>();
        winLottoNumberList.add(number1);
        winLottoNumberList.add(number2);
        winLottoNumberList.add(number3);
        winLottoNumberList.add(number4);
        winLottoNumberList.add(number5);
        winLottoNumberList.add(number6);

        LottoNumber lottoNumber = new LottoNumber(winLottoNumberList);
        winLottoNumber = new WinLottoNumber(lottoNumber);

    }

    @Test
    @DisplayName("로또 번호 몇개를 맞추었는지 확인 TEST")
    public void checkDuplicationLottoTest() {

        Number number1 = new Number(3);
        Number number2 = new Number(11);
        Number number3 = new Number(12);
        Number number4 = new Number(31);
        Number number5 = new Number(34);
        Number number6 = new Number(39);
        List<Number> numberList = new ArrayList<>();

        numberList.add(number1);
        numberList.add(number2);
        numberList.add(number3);
        numberList.add(number4);
        numberList.add(number5);
        numberList.add(number6);

        LottoNumber lottoNumber = new LottoNumber(numberList);

        int resultNumber = winLottoNumber.duplicationLotto(lottoNumber);

        assertThat(resultNumber).isEqualTo(5);


    }

}
