package lotto.view;

import lotto.domain.Amount;
import lotto.domain.Winning;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printLottoNumbers(Map<Integer, List<Integer>> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");

        for (Integer integer : lottoNumbers.keySet()) {
            System.out.println(lottoNumbers.get(integer));
        }

        System.out.println();
    }

    public void printStatistics(Winning winning, int inputBuyAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Integer integer : winning.getWinning().keySet()) {
            System.out.println(integer + "개 일치 (" + Amount.getWinningMoney(integer) + "원)-" + winning.getWinning().get(integer) + "개");
        }

        int totalAmount = winning.getSumAmount();
        System.out.printf("총 수익률은 " + "%.2f" + "입니다.", totalAmount / (double) inputBuyAmount);
    }
}
