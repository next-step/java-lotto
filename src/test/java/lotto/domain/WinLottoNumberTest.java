package lotto.domain;

import lotto.enums.Rank;
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
        Number bonusNumber = new Number(13);

        List<Number> winLottoNumberList = new ArrayList<>();
        winLottoNumberList.add(number1);
        winLottoNumberList.add(number2);
        winLottoNumberList.add(number3);
        winLottoNumberList.add(number4);
        winLottoNumberList.add(number5);
        winLottoNumberList.add(number6);

        LottoNumber lottoNumber = new LottoNumber(winLottoNumberList);
        winLottoNumber = new WinLottoNumber(lottoNumber, bonusNumber);

    }

    @Test
    @DisplayName("로또 번호 1등 TEST")
    public void checkWinFirstLottoTest() {

        Number number1 = new Number(3);
        Number number2 = new Number(11);
        Number number3 = new Number(12);
        Number number4 = new Number(31);
        Number number5 = new Number(34);
        Number number6 = new Number(41);

        List<Number> numberList = new ArrayList<>();

        numberList.add(number1);
        numberList.add(number2);
        numberList.add(number3);
        numberList.add(number4);
        numberList.add(number5);
        numberList.add(number6);

        LottoNumber lottoNumber = new LottoNumber(numberList);

        Rank resultRank = winLottoNumber.duplicationLottoRank(lottoNumber);

        assertThat(resultRank).isEqualTo(Rank.FIRST);


    }


    @Test
    @DisplayName("보너스 번호까지 2등 나오는지 확인 TEST")
    public void checkWinSecondLottoTest() {
        //given
        Number number1 = new Number(3);
        Number number2 = new Number(11);
        Number number3 = new Number(12);
        Number number4 = new Number(31);
        Number number5 = new Number(34);
        Number bonusNumber = new Number(13);

        //when
        List<Number> numberList = new ArrayList<>();

        numberList.add(number1);
        numberList.add(number2);
        numberList.add(number3);
        numberList.add(number4);
        numberList.add(number5);
        numberList.add(bonusNumber);

        LottoNumber lottoNumber = new LottoNumber(numberList);
        Rank resultRank = winLottoNumber.duplicationLottoRank(lottoNumber);

        //result
        assertThat(resultRank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("로또 번호 3등 TEST")
    public void checkWinThirdLottoTest() {

        //given
        Number number1 = new Number(3);
        Number number2 = new Number(11);
        Number number3 = new Number(12);
        Number number4 = new Number(31);
        Number number5 = new Number(34);
        Number number6 = new Number(44);

        //when
        List<Number> numberList = new ArrayList<>();

        numberList.add(number1);
        numberList.add(number2);
        numberList.add(number3);
        numberList.add(number4);
        numberList.add(number5);
        numberList.add(number6);

        LottoNumber lottoNumber = new LottoNumber(numberList);
        Rank resultRank = winLottoNumber.duplicationLottoRank(lottoNumber);

        //result
        assertThat(resultRank).isEqualTo(Rank.THIRD);

    }

    @Test
    @DisplayName("로또 번호 4등 TEST")
    public void checkWinFourthLottoTest() {

        //given
        Number number1 = new Number(3);
        Number number2 = new Number(11);
        Number number3 = new Number(12);
        Number number4 = new Number(31);
        Number number5 = new Number(35);
        Number number6 = new Number(44);

        //when
        List<Number> numberList = new ArrayList<>();

        numberList.add(number1);
        numberList.add(number2);
        numberList.add(number3);
        numberList.add(number4);
        numberList.add(number5);
        numberList.add(number6);

        LottoNumber lottoNumber = new LottoNumber(numberList);
        Rank resultRank = winLottoNumber.duplicationLottoRank(lottoNumber);

        //result
        assertThat(resultRank).isEqualTo(Rank.FOURTH);

    }

    @Test
    @DisplayName("로또 번호 5등 TEST")
    public void checkWinFifthLottoTest() {

        //given
        Number number1 = new Number(3);
        Number number2 = new Number(11);
        Number number3 = new Number(12);
        Number number4 = new Number(32);
        Number number5 = new Number(35);
        Number number6 = new Number(44);

        //when
        List<Number> numberList = new ArrayList<>();

        numberList.add(number1);
        numberList.add(number2);
        numberList.add(number3);
        numberList.add(number4);
        numberList.add(number5);
        numberList.add(number6);

        LottoNumber lottoNumber = new LottoNumber(numberList);
        Rank resultRank = winLottoNumber.duplicationLottoRank(lottoNumber);

        //result
        assertThat(resultRank).isEqualTo(Rank.FIFTH);

    }

    @Test
    @DisplayName("로또 번호 꽝 TEST")
    public void checkWinMissLottoTest() {

        /*
        Number number1 = new Number(3);
        Number number2 = new Number(11);
        Number number3 = new Number(12);
        Number number4 = new Number(31);
        Number number5 = new Number(34);
        Number number6 = new Number(41);
         */
        //given
        Number number1 = new Number(1);
        Number number2 = new Number(3);
        Number number3 = new Number(13);
        Number number4 = new Number(30);
        Number number5 = new Number(35);
        Number number6 = new Number(44);

        //when
        List<Number> numberList = new ArrayList<>();

        numberList.add(number1);
        numberList.add(number2);
        numberList.add(number3);
        numberList.add(number4);
        numberList.add(number5);
        numberList.add(number6);

        LottoNumber lottoNumber = new LottoNumber(numberList);
        Rank resultRank = winLottoNumber.duplicationLottoRank(lottoNumber);

        //result
        assertThat(resultRank).isEqualTo(Rank.MISS);
    }

}
