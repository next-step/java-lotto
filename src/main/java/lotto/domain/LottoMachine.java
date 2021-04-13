package lotto.domain;

import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoMachine {

    private List<LottoNumber> lottoNumbers;
    private HashMap<Rank, Integer> winCountMap = new HashMap<>();
    private Money expense;

    public LottoMachine(final List<LottoNumber> lottoNumbers, Money expense) {
        this.lottoNumbers = lottoNumbers;
        this.expense = expense;
        makeWinCountMap();
    }

    private void makeWinCountMap() {
        for (Rank rank : Rank.values()) {
            winCountMap.put(rank, 0);
        }
    }

    public void startLottoGame() {
        printLotto();
    }

    public OutputData showResult(List<Integer> lottoNumberList, Number bonusNumber) {

        WinLottoNumber winLottoNumber = new WinLottoNumber(changedListIntegerToLottoNumber(lottoNumberList), bonusNumber);

        for (LottoNumber purchasedLottoNumber : this.lottoNumbers) {
            Rank rank = winLottoNumber.duplicationLottoRank(purchasedLottoNumber);
            countWinner(rank);
        }

        return new OutputData(winCountMap, expense);
    }


    private void countWinner(Rank rank) {
        boolean existWinner = winCountMap.containsKey(rank);
        if (existWinner) {
            int existCount = winCountMap.get(rank);
            winCountMap.put(rank, existCount++);
        }

        if (!existWinner) {
            winCountMap.put(rank, 1);
        }
    }


    private int sumWinAmount(Rank rank) {
        return rank.getWinningMoney();
    }

    private float calculateRate(Money winAmount, Money expense) {
        return winAmount.won() / expense.won();
    }

    private LottoNumber changedListIntegerToLottoNumber(List<Integer> lottoNumberList) {
        List<Number> numberList = new ArrayList<>();

        for (int number : lottoNumberList) {
            numberList.add(new Number(number));
        }
        return new LottoNumber(numberList);
    }


    private void printLotto() {

        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.toString());
        }
    }

}
