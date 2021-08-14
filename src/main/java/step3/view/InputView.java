package step3.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void print(String input) {
        System.out.println(input);
    }

    public int receiveInput() {
        int input = SCANNER.nextInt();
        return input;
    }

    public int[] receiveLastWeekWinningNumber() {
        String input = SCANNER.next();
        String[] split = input.replaceAll("\\s", "").split(",");
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int receiveBonusNumber() {
        return SCANNER.nextInt();
    }

    public void close() {
        SCANNER.close();
    }
}
