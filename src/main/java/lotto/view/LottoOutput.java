package lotto.view;

import lotto.model.*;
import lotto.model.constants.Dividend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoOutput {

    public static final int RANK_NUMBER = Dividend.values().length - 2;

    public void viewLottoCount(TotalLottos totalLottos) {
        System.out.println(totalLottos.lottoCount() + "개를 구매했습니다.");
    }

    public void viewManualAndAutoCount(LottoFactory lottoFactory){
        System.out.println("수동으로 " + lottoFactory.manualLottoCount() + "장, 자동으로 " + lottoFactory.autoLottoCount() + "개를 구매했습니다.");
    }

    public void viewLottosDetail(TotalLottos totalLottos) {
        for (Lotto lotto : totalLottos.lottoList()) {
            System.out.println("[" + getLottoDetail(lotto) + "]");
        }
        System.out.println();
    }

    private String getLottoDetail(Lotto lotto) {
        List<String> list = new ArrayList<>();
        for (LottoNumber number : lotto.numbers()) {
            list.add(Integer.toString(number.number()));
        }
        return String.join(", ", list);
    }

    public void viewTotalIncomeRatio(Lottery lottery) {
        System.out.println("총 수익률은 " + String.format("%.2f", lottery.getInvestment()) + "입니다.");
    }

    public void viewCorrectLottos(Lottery lottery) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<Dividend, Integer> correctDetails = lottery.totalCorrect();
        for (int count = RANK_NUMBER; count >= 0; count--) {
            viewCorrectLotto(Dividend.values()[count], correctDetails.getOrDefault(Dividend.values()[count], 0));
        }

    }


    public void viewCorrectLotto(Dividend dividend, int count) {
        if (dividend.equals(Dividend.SECOND)) {
            System.out.println(dividend.correctCount() + "개 일치, 보너스 볼 일치(" + dividend.dividendAmount() + "원) - " + count + "개");
            return;
        }
        System.out.println(dividend.correctCount() + "개 일치 (" + dividend.dividendAmount() + "원) - " + count + "개");
    }
}
