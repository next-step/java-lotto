package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public class ResultView {

    public static void printLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원)- " + result.getThreeMatches() + "개");
        System.out.println("4개 일치 (50,000원)- " + result.getFourMatches() + "개");
        System.out.println("5개 일치 (1,500,000원)- " + result.getFiveMatches() + "개");
        System.out.println("6개 일치 (2,000,000,000원)- " + result.getSixMatches() + "개");
        System.out.printf("총 수익률은 %,.2f입니다.%n", result.getRate());
    }
}
