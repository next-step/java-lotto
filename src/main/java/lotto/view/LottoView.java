package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoView {
    private static final int LOTTO_NUM_COUNT = 6;

    public static int buyLotto() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int number = scanner.nextInt();

        if (number == 0) {
            throw new IllegalArgumentException("돈을 넣으세요.");
        }

        if (number < 1000) {
            throw new IllegalArgumentException("돈을 더 넣으세요.");
        }

        System.out.println(number/1000 + "개를 구매했습니다.");

        return number/1000;
    }

    public static void showBuyLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    public static String inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String[] splitWinningNumbers(String inputValue) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^([0-9]+,\\s)+[0-9]+$");
        Matcher matcher = pattern.matcher(inputValue.trim());
        if (!matcher.find()) {
            throw new IllegalArgumentException("패턴 불일치");
        }

        String[] winningNumbers = inputValue.split(", ");

        if (winningNumbers.length != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("당첨숫자 개수 안맞음");
        }

        return winningNumbers;
    }


    public static void showWinningStatistics(List<Lotto> lottos) {
        System.out.println();
        System.out.println("당첨 통계\n---------");

        int threeMatchCnt = 0;
        int fourMatchCnt = 0;
        int fiveMatchCnt = 0;
        int sixMatchCnt = 0;

        for (Lotto lotto : lottos) {
            if (lotto.getMatchCount() == 3) {
                threeMatchCnt++;
            } else if (lotto.getMatchCount() == 4) {
                fourMatchCnt++;
            } else if (lotto.getMatchCount() == 5) {
                fiveMatchCnt++;
            } else if (lotto.getMatchCount() == 6) {
                sixMatchCnt++;
            }
        }

        System.out.println("3개 일치 (5000원)- " + threeMatchCnt + "개");
        System.out.println("4개 일치 (50000원)- " + fourMatchCnt + "개");
        System.out.println("5개 일치 (1500000원)- " + fiveMatchCnt + "개");
        System.out.println("6개 일치 (2000000000원)- " + sixMatchCnt + "개");
        System.out.println("총 수익률은 "
                + (5000 * threeMatchCnt + 50000 * fourMatchCnt + 1500000 * fiveMatchCnt + 2000000000 * sixMatchCnt)/(lottos.size()*1000)*1.0d
                + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
