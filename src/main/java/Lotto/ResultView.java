package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String LAST_WEEK_WINNER_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String STATS_RESULT = "당첨 통계";
    private static final String INDICATOR = "----------";

    public static void inputAmount() { System.out.println(AMOUNT_INPUT); }

    public static void purchased(int count) {
        String purchasedMsg = String.format("%s개를 구매했습니다.", count);
        System.out.println(purchasedMsg);
    }

    public static void showLottoNumbers(List<LottoNumber> numbers) {
        String msg = numbers
                .stream()
                .map(v -> v.getNumber())
                .map(v -> v.toString())
                .collect(Collectors.joining(", "));
        System.out.println(msg);
    }

    public static void inputWinnerLotto() {
        System.out.println(LAST_WEEK_WINNER_LOTTO);
    }

    public static void inputBonusNumber() {
        System.out.println(BONUS_NUMBER);
    }

    public static void result(MyRank myRank) {
        System.out.println(STATS_RESULT);
        System.out.println(INDICATOR);
        for (Rank rank : myRank.all()) {
            String msg = String.format(
                    "%s개 일치 (%s원)- %s개",
                    rank.getCorrectCount(),
                    rank.getPrize(),
                    myRank.getCount(rank)
            );
            System.out.println(msg);
        }
    }

    public static void printLine() {
        System.out.println();
    }

    public static void profit(double profit) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", profit));
    }
}
