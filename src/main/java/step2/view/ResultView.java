package step2.view;

import step2.domain.PrizeMoney;

import java.util.List;

public class ResultView {

    private static final int MINIMUM_MATH_COUNT = 3;
    private static final int MAXIMUM_MATH_COUNT = 6;

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static <E> void printList(List<E> list) {
        for (E element : list) {
            System.out.println(element);
        }
        printBlankLine();
    }

    public static void printResultReport(int[] lottoReport) {
        for (int i = MINIMUM_MATH_COUNT; i < MAXIMUM_MATH_COUNT + 1; i++) {
            printMessage(i + "개 일치 (" + PrizeMoney.toPrizeMoney(i).getPrizeMoney() + ") - " + lottoReport[i] + "개");
        }
    }
}
