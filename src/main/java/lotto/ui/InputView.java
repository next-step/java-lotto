package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int readAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        return readInt();
    }

    public static List<Integer> readWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return readIntegerList();
    }

    private static int readInt() {
        return SCANNER.nextInt();
    }

    private static List<Integer> readIntegerList() {
        List<Integer> numbers = new ArrayList<>();
        SCANNER.useDelimiter(",");
        while (SCANNER.hasNext()) {
            if (SCANNER.hasNextInt()) {
                numbers.add(SCANNER.nextInt());
            } else {
                SCANNER.next();
            }
        }
        return numbers;
    }

}
