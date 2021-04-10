package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoMachineTest {

    private List<Number> winLottoNumbersList = new ArrayList<>();
    private List<Number> lottoNumberList = new ArrayList<>();
    private LottoNumber lottoNumber;
    private LottoNumbers lottoNumbers;

    @BeforeEach
    private void SetUp() {

        Number number1 = new Number(3);
        Number number2 = new Number(11);
        Number number3 = new Number(12);
        Number number4 = new Number(31);
        Number number5 = new Number(34);
        Number number6 = new Number(41);


        winLottoNumbersList.add(number1);
        winLottoNumbersList.add(number2);
        winLottoNumbersList.add(number3);
        winLottoNumbersList.add(number4);
        winLottoNumbersList.add(number5);
        winLottoNumbersList.add(number6);


        Number number7 = new Number(40);
        lottoNumberList.add(number1);
        lottoNumberList.add(number2);
        lottoNumberList.add(number3);
        lottoNumberList.add(number4);
        lottoNumberList.add(number5);
        lottoNumberList.add(number7);
        lottoNumber = new LottoNumber(lottoNumberList);

        LottoNumber lottoNumber = new LottoNumber(lottoNumberList);

        List<LottoNumber> lottoNumberList = new ArrayList<>();

        lottoNumberList.add(lottoNumber);
        lottoNumbers = new LottoNumbers(lottoNumberList);
    }

    @Test
    @DisplayName("로또번호를 몇개나 맞추었는지 비교 테스트 ")
    void winLottoTest() {

        LottoMachine lottoMachine = new LottoMachine(lottoNumbers,new Money(2000));

        LottoNumber winLottoNumber = new LottoNumber(winLottoNumbersList);

        OutputData outputData = lottoMachine.showResult(winLottoNumber);

        assertThat(outputData.fiveWin().number()).isEqualTo(1);


    }
}
