package step3.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLong();
    }

    public int[] inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return parseNumbers(scanner.nextLine());
    }

    private int[] parseNumbers(String numbers) {
        String[] textNumbers = numbers.split(",");
        int[] resultNumbers = new int[textNumbers.length];
        for(int i=0; i<textNumbers.length; i++) {
            resultNumbers[i] = Integer.parseInt(textNumbers[i]);
        }

        return resultNumbers;
    }

    public void close() {
        scanner.close();
    }
}
