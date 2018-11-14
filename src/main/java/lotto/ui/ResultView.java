package lotto.ui;

import enums.LottoReword;
import lotto.model.Lotto;
import lotto.model.LottoGameResult;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ResultView {
    public static void printBuyLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto ->
                System.out.println(lotto.getNumbers()));
    }

    public static void printResultLottoReword(LottoGameResult lottoGameResult, float earningsRate) {
        LottoReword[] lottoRewords = LottoReword.values();

        Map<Integer, Integer> reword = lottoGameResult.getResults();
        reword.entrySet().stream().filter(e -> e.getKey() >= 3).forEach( e -> {
            System.out.println(e.getKey() + "개 일치 ("
                         + lottoRewords[e.getKey()].getReword() + ") - "  +e.getValue() + "개");
        });

        System.out.println("총 수익률은 " + earningsRate + "입니다.");
    }
}
