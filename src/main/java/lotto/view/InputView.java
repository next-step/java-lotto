package lotto.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    
    public static int inputTryNo(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
    
    public static String inputTryLine(String message) {
        System.out.println(message);
        return scanner.next();
    }

    public static String[] inputTryLines(String message, int tryManualLottoCount) {
        if (tryManualLottoCount > 0) {
            System.out.println(message);
            String[] lines = new String[tryManualLottoCount];
            for (int i = 0; i < tryManualLottoCount; i++) {
                lines[i] = scanner.next();
            }
            return lines;
        }
        return null;
    }
}
