package step2.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    public static int inputPrice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int[] inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        return Arrays.stream(scanner.nextLine().split(", "))
            .mapToInt(Integer::parseInt)
            .toArray();
    }
}
