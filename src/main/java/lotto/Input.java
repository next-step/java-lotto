package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public static String getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return scanner.nextLine();
    }

    public static boolean isValidNumbers(List<Integer> numbers) {
        return numbers.size() == 6 && isInRange(numbers) && isDistinctNumbers(numbers);
    }

    private static boolean isInRange(List<Integer> numbers) {
        List<Integer> validNumRangeNumbers = IntStream.rangeClosed(LottoNumGenerator.MAX_INT, LottoNumGenerator.MAX_INT)
                .boxed().collect(Collectors.toList());

        return Collections.disjoint(numbers, validNumRangeNumbers);
    }

    private static boolean isDistinctNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() == 6;

    }


}
