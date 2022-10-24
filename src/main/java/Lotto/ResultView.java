package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String LAST_WEEK_WINNER_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";

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

    public static void result(List<Rank> ranking) {
        for (Rank rank : ranking) {
            String msg = String.format(
                    "%s개 일치 (%s원)- %s개",
                    rank.getCorrectCount(),
                    rank.getPrize(),
                    rank.getCount()
            );
            System.out.println(msg);
        }
    }

    public static void printLine() {
        System.out.println();
    }
}
