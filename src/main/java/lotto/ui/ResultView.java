package lotto.ui;

import lotto.enums.LottoReword;
import lotto.model.Lotto;
import lotto.model.LottoGameResult;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printBuyLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto ->
                System.out.println(lotto.getNumbers()));
    }

    public static void printBuyLottos(int manualCount, int autoCount) {
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "개를 구매했습니다.");
    }

    public static void printResultLottoReword(LottoGameResult lottoGameResult, float earningsRate) {
        Map<LottoReword, Integer> reword = lottoGameResult.getResults();

        for(LottoReword lottoReword : LottoReword.values() ) {
            System.out.println(lottoReword.getPrint() + " - "  + reword.get(lottoReword) + "개");
        }
        System.out.println("총 수익률은 " + earningsRate + "입니다.");
    }
}
