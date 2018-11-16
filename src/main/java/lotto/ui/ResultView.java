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

    public static void printResultLottoReword(LottoGameResult lottoGameResult, float earningsRate) {
        Map<LottoReword, Integer> reword = lottoGameResult.getResults();

        for(LottoReword lottoReword : LottoReword.values() ) {
            System.out.println(lottoReword.getPrint() + " - "  + reword.get(lottoReword) + "개");
        }
        System.out.println("총 수익률은 " + earningsRate + "입니다.");
    }
}
