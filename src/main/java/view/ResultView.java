package view;

import java.util.List;
import java.util.stream.Collectors;

import domain.Lotto;
import domain.LottoStatics;

import static domain.LottoStatics.PROFIT_STANDARD;

public class ResultView {

    private static void print(Lotto lotto) {
        String formatted = lotto.getNumList().stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));

        System.out.println("[" + formatted + "]");
    }

    public static void print(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            print(lotto);
        }
    }

    public static void print(LottoStatics lottoStatics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + LottoStatics.HIT_3_WINNING_AMOUNT + "원)- " + lottoStatics.getHit3Count() + "개");
        System.out.println("4개 일치 (" + LottoStatics.HIT_4_WINNING_AMOUNT + "원)- " + lottoStatics.getHit4Count() + "개");
        System.out.println("5개 일치 (" + LottoStatics.HIT_5_WINNING_AMOUNT + "원)- " + lottoStatics.getHit5Count() + "개");
        System.out.println("6개 일치 (" + LottoStatics.HIT_6_WINNING_AMOUNT + "원)- " + lottoStatics.getHit6Count() + "개");

        System.out.println("총 수익률은 " + lottoStatics.getProfitRate()
            + "입니다.(기준이 " + PROFIT_STANDARD
            + "이기 때문에 결과적으로 "
            + (lottoStatics.isProfit() ? "이익" : "손해" + "라는 의미임"));
    }
}
