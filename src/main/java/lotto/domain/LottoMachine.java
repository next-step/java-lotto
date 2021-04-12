package lotto.domain;

import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private List<LottoNumber> lottoNumbers;

    private static final Number threeNumber = new Number(3);
    private static final Number fourNumber = new Number(4);
    private static final Number fiveNumber = new Number(5);
    private static final Number sixNumber = new Number(6);

    private Number threeWinnerCnt = new Number(0);
    private Number fourWinnerCnt = new Number(0);
    private Number fiveWinnerCnt = new Number(0);
    private Number sixWinnerCnt = new Number(0);

    private Money expense;

    public LottoMachine(final List<LottoNumber> lottoNumbers, Money expense) {
        this.lottoNumbers = lottoNumbers;
        this.expense = expense;
    }

    public void startLottoGame() {
        printLotto();
    }

    public OutputData showResult(List<Integer> lottoNumberList) {

        List<Number> numberList = new ArrayList<>();

        for (int number : lottoNumberList) {
            numberList.add(new Number(number));
        }

        LottoNumber lottoNumber = new LottoNumber(numberList);
        WinLottoNumber winLottoNumber = new WinLottoNumber(lottoNumber);


        for (LottoNumber purchasedLottoNumber : this.lottoNumbers) {
            Rank rank = winLottoNumber.duplicationLotto(purchasedLottoNumber);
//            plusCount(resultCount);
        }

        OutputData result = new OutputData(threeWinnerCnt, fourWinnerCnt, fiveWinnerCnt, sixWinnerCnt, expense);
        result.calculateRate();
        return result;
    }


    private void plusCount(Rank rank) {
//        if (rank.FIFTH.) {
//            threeWinnerCnt = new Number(threeWinnerCnt.number() + 1);
//        }
//
//        if (resultCount == Rank.FOURTH.getCountOfMatch()) {
//            fourWinnerCnt = new Number(fourWinnerCnt.number() + 1);
//        }
//
//        if (resultCount == Rank.THIRD.getCountOfMatch()) {
//            fiveWinnerCnt = new Number(fiveWinnerCnt.number() + 1);
//        }
//
//        if (resultCount == Rank.FIRST.getCountOfMatch()) {
//            sixWinnerCnt = new Number(sixWinnerCnt.number() + 1);
//        }
    }


    private void printLotto() {

        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.toString());
        }
    }

}
