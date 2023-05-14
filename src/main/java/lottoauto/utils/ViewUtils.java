package lottoauto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lottoauto.model.Lotto;
import lottoauto.model.LottoResult;
import lottoauto.model.Lottos;

public class ViewUtils {

    public static class Input {

        public static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
        public static final String LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
        public static final String INPUT_BONUS = "보너스 숫자를 입력해 주세요";
        private static final Scanner scanner = new Scanner(System.in);

        public static int amount() {
            System.out.println(INPUT_PRICE);
            return convertInteger(scanner.nextLine());
        }

        public static List<Integer> winningNumber() {
            System.out.println(LAST_WINNING_NUMBER);
            return Arrays.stream(scanner.nextLine()
                            .split(","))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
        }

        public static int bonus() {
            System.out.println(INPUT_BONUS);
            return convertInteger(scanner.nextLine());
        }

        private static int convertInteger(String text) {
            return Integer.parseInt(text);
        }

    }

    public static class Output {

        public static final String OPEN_SQUARE_BRACKET = "[";
        public static final String CLOSE_SQUARE_BRACKET = "]";
        public static final String DELEGATOR = ",";

        public static void lottos(Lottos lottos) {
            System.out.println(lottos.getSize() + "개를 구매했습니다.");
            for (Lotto lotto : lottos.getLottos()) {
                System.out.println(winningNumber(lotto));
            }
        }

        private static String winningNumber(Lotto lotto) {
            return lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(DELEGATOR, OPEN_SQUARE_BRACKET, CLOSE_SQUARE_BRACKET));
        }

        public static void statistics(LottoResult lottoResult, int amount) {
            System.out.println("당첨 통계");
            System.out.println("----------");

            lottoResult.getMatchFrequency().forEach((match, count) -> {
                if (match.getBonus()) {
                    System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n", match.getMatchCount(), match.getReward(), count);
                    return;
                }
                System.out.printf("%d개 일치 (%d원) - %d개\n", match.getMatchCount(), match.getReward(), count);
            });

            System.out.printf("총 수익률은 %f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임.)", lottoResult.getRate(amount));

        }
    }

}
