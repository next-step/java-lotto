package Lotto.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public int[] getWinnerNumbers(){
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = scanner.nextLine();
        int[] numbers = Arrays.stream(line.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        return numbers;
    }
}
