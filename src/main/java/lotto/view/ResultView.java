package lotto.view;

import lotto.data.Lotto;
import lotto.data.LottoCount;
import lotto.data.LottoWinningPrice;
import lotto.data.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lotto.data.LottoWinningPrice.getLottoNumberByNumber;

public class ResultView {

    private ResultView(){
        //
    }

    public static void viewAmount(LottoCount manulLottoCounts, LottoCount autoLottoCounts){
        StringBuilder builder = new StringBuilder();
        builder.append("수동으로 ").append(manulLottoCounts.getCount() + "장, ").append("자동으로 ").append(autoLottoCounts.getCount() + "개를 구매했습니다.");
        System.out.println();
        System.out.println(builder.toString());
    }

    public static void viewLottoList(Lottos manualLottoList, List<Lotto> autoLottoList) {
        for (Lotto lotto : manualLottoList.getLottos()) {
            System.out.println(lotto.getNumbers().toString());
        }

        for (Lotto lotto : autoLottoList) {
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
