package autolotto;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private static final String START_WORDING = "구입금액을 입력해주세요";
    private static final String LOTTO_BUY_WORDING = "%s개를 구매했습니다.";
    private static final String LAST_WEEK_WIN_NUMBER_WORDING = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_WIN_RESULT_WORDING = "당첨 통계\n---------";

    public static int getBuyingMoney() {
        System.out.println(START_WORDING);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public static void outBuyingCount(int num) {
        System.out.println(String.format(LOTTO_BUY_WORDING, num));
    }

    public static void outputLottoList(Lotto[] lottoList) {
        for (int i = 0; i < lottoList.length; i++) {
            List<Integer> lottoNum = lottoList[i].lottoNum();
            Collections.sort(lottoNum);
            System.out.println(lottoNum);
        }
    }

    public static String getLastWeekWinNumber() {
        System.out.println(LAST_WEEK_WIN_NUMBER_WORDING);
        String input = scanner.nextLine();
        return input;
    }

    public static void outputWinResult(String winResult) {
        System.out.println(LOTTO_WIN_RESULT_WORDING);
        System.out.println(winResult);
    }
}
