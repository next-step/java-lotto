package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.enumerate.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printResult(Result result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.getOrderedRanks()) {
            System.out.println(rank.getCountOfMatch() + "개 일치" + getBonusString(rank) + "(" + rank.getWinningMoney() + "원)- " + result.getWinCount(rank) + "개");
        }
        System.out.println("총 수익률은 " + result.getRateOfIncome() + "입니다");
    }

    private String getBonusString(Rank rank) {
        if (Rank.SECOND == rank) {
            return ", 보너스 볼 일치";
        }
        return " ";
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