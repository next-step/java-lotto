package lotto.view;

import lotto.data.Lotto;
import lotto.data.LottoWinningPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lotto.data.LottoWinningPrice.getLottoNumberByNumber;

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

    public static void viewWinningNumberList(Map<LottoWinningPrice, Integer> winningNumberList) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoWinningPrice lottoWinningPrice : winningNumberList.keySet()) {
            viewWinningNumber(lottoWinningPrice, winningNumberList.get(lottoWinningPrice));
        }
    }

    private static void viewWinningNumber(LottoWinningPrice lottoWinningPrice, int matchedWinningNumberCount) {
        if (lottoWinningPrice.getWinningPrice() > 0) {
            String bonusView = getBonusView(lottoWinningPrice.getMatchedBonusNumber());
            System.out.println(lottoWinningPrice.getMatchedNumber() + "개 일치" + bonusView + " (" + lottoWinningPrice.getWinningPrice() + "원)- "
                    + matchedWinningNumberCount + "개");
        }
    }

    private static String getBonusView(boolean matchedBonusNumber){
        if(matchedBonusNumber){
            return ", 보너스 볼 일치";
        }

        return "";
    }

    public static void viewRateOfReturn(String rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
