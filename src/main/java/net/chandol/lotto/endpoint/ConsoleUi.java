package net.chandol.lotto.endpoint;

import net.chandol.lotto.domain.Lotto;
import net.chandol.lotto.domain.LottoGameResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static net.chandol.lotto.domain.LottoPrize.*;
import static net.chandol.lotto.util.ConsoleUiUtil.formatLotto;

public class ConsoleUi {

    public static Integer getInputNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }

    public static String getInputString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }


    public static List<String> getInputStringArrays(int count, String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        List<String> results = new ArrayList<>();

        for (int idx = 0; idx < count; idx++) {
            String line = scanner.nextLine();
            results.add(line);
        }

        return results;
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            String formattedLottoNumber = formatLotto(lotto);
            System.out.println(formattedLottoNumber);
        }
    }

    public static void printLottoPurchaseCount(int directCount, int autoCount) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", directCount, autoCount));
    }

    public static void printLottoGameResult(LottoGameResult lottoGameResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println(lottoGameResult.getFormattedResult(_5));
        System.out.println(lottoGameResult.getFormattedResult(_4));
        System.out.println(lottoGameResult.getFormattedResult(_3));
        System.out.println(lottoGameResult.getFormattedResult(_2));
        System.out.println(lottoGameResult.getFormattedResult(_1));

        Double profitRate = lottoGameResult.getProfitRate();
        System.out.println(String.format("총 수익률은 %.2f 입니다", profitRate));
    }
}
