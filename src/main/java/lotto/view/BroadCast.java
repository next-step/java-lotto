package lotto.view;

import lotto.model.Win;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BroadCast {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_REGEX = ", ";

    public static List<Integer> pickNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winNumberString = scanner.nextLine();
        return Arrays.stream(winNumberString.split(SPLIT_REGEX)).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static void showResult(Map<Win, Integer> winTotal) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 0; i < Win.values().length; i++) {
            System.out.println(Win.values()[i].getPoints() + "개 일치 (" + Win.values()[i].getPrize() + "원)- " + winTotal.get(Win.values()[i]));
        }
    }
}
