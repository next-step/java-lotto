package step3;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Print {
    public static void inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void result(List<Lotto> result) {
        for (Lotto lotto : result) {
            System.out.println(lotto);
        }
    }

    public static void winningNumber() {
        newLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void newLine() {
        System.out.println();
    }

    public static void rateOfWin(int amount, Map<Operator, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---------------");
        double rate = 0d;
        Set<Map.Entry<Operator, Integer>> entries = results.entrySet();
        for (Map.Entry<Operator, Integer> entry : entries) {
            rate = printPrize(rate, entry);
        }
        System.out.println("총 수익률은 " + String.format("%.2f", (rate / amount)) + "입니다.");
    }

    private static double printPrize(double rate, Map.Entry<Operator, Integer> entry) {
        if (entry.getKey() != null) {
            rate += entry.getKey().getWinning() * entry.getValue();
            System.out.println(checkBonus(entry));
        }
        return rate;
    }

    private static String checkBonus(Map.Entry<Operator, Integer> entry) {
        if (entry.getKey().equals(Operator.FIVE_BONUS)) {
            return
                    "5개 일치, 보너스 볼 일치 (" + entry.getKey().getWinning() + "원)- " + entry.getValue() + "개";
        }
        if (entry.getKey().getCount() == 0) {
            return "";
        }
        return entry.getKey().getCount() + "개 일치 (" + entry.getKey().getWinning() + "원)- " + entry.getValue() + "개";
    }

    public static void bonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void manualLotto() {
        newLine();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void makeManualLotto() {
        newLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void howManyBuyLotto(int manual, int auto, List<Lotto> combineLotto) {
        result(combineLotto);
        System.out.println("수동으로 " + manual + "장, 자동으로 " + auto + "개를 구매했습니다.");
    }
}
