package view;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printPurchasedLottoCount(int count) {
        printMessage(count + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        printMessage(arrayToString(lottoNumbers));
    }

    public static void printMatchCount(int matchCount, int price, int count) {
        printMessage(matchCount + "개 일치 (" + price + "원)- " + count + "개");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static String arrayToString(List<Integer> array) {
        return "[" + array.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
