package view;

import controller.WinningStatistic;
import lotto.Lotto;
import lotto.type.WinningLevel;

import java.util.List;

public class Renderer {
    private Renderer() {
    }

    public static void simplePrint(String message) {
        System.out.println(message);
    }

    public static void printLotto(Lotto lotto) {
        List<Integer> numberList = lotto.toList();

        System.out.print("[");

        for (int i = 0; i < numberList.size()-1; i++) {
            System.out.print(numberList.get(i));
            System.out.print(", ");
        }
        System.out.print(numberList.get(numberList.size()-1));

        System.out.println("]");
    }

    public static void printResult(WinningStatistic result) {
        simplePrint("당첨 통계");
        simplePrint("--------------");

        for (WinningLevel rank : WinningLevel.values()) {
            simplePrint(rankRule(rank) + " (" + rankAmount(rank) + ")-" + result.getOccurs(rank) + "개");
        }
    }

    private static String rankRule(WinningLevel rank) {
        return rank.getDescription();
    }

    private static String rankAmount(WinningLevel rank) {
        return rank.getAmount() + "원";
    }

    public static void printRatio(double ratio) {
        if (ratio < 1.0) {
            simplePrint("총 수익률은 " + ratio + "입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
            return;
        }
        simplePrint("총 수익률은 " + ratio + "입니다.");
    }
}
