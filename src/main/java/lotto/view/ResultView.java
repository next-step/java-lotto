package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.enumerate.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printResult(Result result) {
        for(Rank rank : Rank.values()){
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + result.getWinCount(rank) + "개");
        }
        System.out.println("총 수익률은 " + result.getRateOfIncome() + "입니다");
    }

    public void printLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumber(lotto);
        }
    }

    private void printLottoNumber(Lotto lotto) {
        System.out.println("[" + lotto.getNumbers().stream().map(Object::toString).collect(Collectors.joining(", ")) + "]");
    }

}