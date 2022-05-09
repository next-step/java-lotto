package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperationUtil {

    private OperationUtil() {
        throw new AssertionError("유틸 클래스는 인스턴스화를 할 수 없습니다.");
    }

    public static int getNumberOfPurchasedTickets(int amount) {
        return amount / 1000;
    }

    public static List<Integer> createLottoRangeNumbers() {
        return IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> splitStringToNumbers(String line) {
        return Arrays.stream(line.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static double getRateOfReturn(int prizeAmount, int purchasedAmount) {
        return ((double) prizeAmount / (double) purchasedAmount);
    }
}
