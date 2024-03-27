package lotto.view;

import lotto.constant.Constant;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultView {
    public static void printPurchase(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            printLottoNumbers(lotto.getLotto());
        }
    }

    private static void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        String[] lottoList = new String[lottoNumbers.size()];

        for (int i = 0; i < lottoNumbers.size(); i++) {
            lottoList[i] = parseString(lottoNumbers.get(i).getLottoNumber());
        }
        System.out.println("[" + String.join(", ", lottoList) + "]");
    }

    private static String parseString(int lottoNumber) {
        return String.valueOf(lottoNumber);
    }

    public static void printResult(HashMap<Integer, Integer> matchResult, double revenue) {
        System.out.println("당첨 통계\n"+"-".repeat(9));
        System.out.println("3개 일치 (5000원) - " + matchResult.get(Rank.FIFTH.getPrize()) + "개");
        System.out.println("4개 일치 (50000원) - " + matchResult.get(Rank.FOURTH.getPrize()) + "개");
        System.out.println("5개 일치 (1500000원) - " + matchResult.get(Rank.THIRD.getPrize()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원) - " + matchResult.get(Rank.SECOND.getPrize()) + "개");
        System.out.println("6개 일치 (2000000000원) - " + matchResult.get(Rank.FIRST.getPrize()) + "개");
        System.out.println("총 수익률은 " + revenue + "입니다.");
    }
}
