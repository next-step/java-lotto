package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int inputPay(Scanner scanner) {
        System.out.println("구입 금액을 입력하세요.");
        return scanner.nextInt();
    }

    public static List<Integer> lastWinNumbers(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        List<Integer> numbers = new ArrayList<>();
        inputLastNumbers(numbers, 0, scanner);
        return numbers;
    }

    public static int inputBonusNumber(Scanner scanner) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    private static void inputLastNumbers(List<Integer> numbers, int count, Scanner scanner) {
        while (count < 6 && scanner.hasNextInt()) {
            int number = scanner.nextInt();
            numbers.add(number);
            count++;
        }
    }

    public static int inputCount(Scanner scanner) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<List<Integer>> inputManualNumbers(int manualCount, Scanner scanner) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> numberList = new ArrayList<>();
        for(int i=0; i<manualCount; i++){
            int count = 0;
            List<Integer> lottoNumbers = new ArrayList<>();
            while(count < 6 && scanner.hasNextInt()){
                int number = scanner.nextInt();
                lottoNumbers.add(number);
                count++;
            }
            numberList.add(lottoNumbers);
        }

        return numberList;
    }
}
