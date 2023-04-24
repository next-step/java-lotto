package lotto.view;

import lotto.data.Lotto;
import lotto.data.LottoNumber;

import java.util.List;
import java.util.Map;

import static lotto.data.LottoNumber.getLottoNumberByNumber;

public class ResultView {

    private ResultView(){
        //
    }

    public static void viewAmount(int amount){
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void viewLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.println();
    }

    public static void viewWinningNumberList(Map<Integer, Integer> winningNumberList) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Integer matchedWinningNumbers : winningNumberList.keySet()) {
            viewWinningNumber(matchedWinningNumbers, winningNumberList.get(matchedWinningNumbers));
        }
    }

    private static void viewWinningNumber(int matchedWinningNumbers, int matchedWinningNumberCount) {
        LottoNumber lottoNumber = getLottoNumberByNumber(matchedWinningNumbers);
        if (lottoNumber.getWinningPrice() > 0) {
            System.out.println(lottoNumber.getMatchedNumber() + "개 일치 (" + lottoNumber.getWinningPrice() + "원)- "
                    + matchedWinningNumberCount + "개");
        }
    }

    public static void viewRateOfReturn(String rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
