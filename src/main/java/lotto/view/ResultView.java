package lotto.view;

import lotto.domain.prize.LottoMatch;
import lotto.domain.LottoNumber;
import lotto.domain.code.LottoMatchPrize;
import lotto.domain.prize.Prize;

import java.util.List;

public class ResultView {

    private static final String PURCHASE_NUMBER = "개를 구매했습니다";
    private static final String STATISTIC = "총 수익률은 %.2f 입니다";
    private static final String MATCH_COUNT = "%d개 일치";
    private static final String PRIZE_AMOUNT = "(%d원)";
    private static final String USER_MATCH_COUNT = "- %d개";

    private ResultView() {}

    public static void printLotto(List<LottoNumber> lotto) {
        print(lotto.size() + PURCHASE_NUMBER);
        printLottoNumbers(lotto);
    }

    public static void printWinningInfo(Prize prize) {
        printPrize(prize.getLottoMatch());
        printStatistic(prize.getEarningRatio());
    }

    private static void printLottoNumbers(List<LottoNumber> lotto) {
        for (LottoNumber lottoNumber : lotto) {
            print(lottoNumber.getNumbers().toString());
        }
    }

    private static void printPrize(LottoMatch match) {
        print("당첨 통계");
        print("-----------");
        printMatchInfo(match);
    }

    private static void printMatchInfo(LottoMatch match) {
        for (LottoMatchPrize prize : match.getMatches()) {
            printf(MATCH_COUNT, prize.getMatchCount());
            printf(PRIZE_AMOUNT, prize.getMoney());
            printf(USER_MATCH_COUNT, match.getMatchCount(prize));
            print("");
        }
    }

    private static void printStatistic(float earningRatio) {
        printf(STATISTIC, earningRatio);
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void printf(String formatString, Object formatValue) {
        System.out.printf(formatString, formatValue);
    }

}
