package mission.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int intputPay() {
        System.out.println("구입 금액을 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        return money;
    }

    public static List<Integer> lastWinNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        List<Integer> numbers = new ArrayList<>();
        int count = 0;

        try (Scanner scanner = new Scanner(System.in).useDelimiter(",\\s*|\r?\n")){
            while (count < 6 && scanner.hasNextInt()) {
                int number = scanner.nextInt();
                numbers.add(number);
                count++;
            }
        }
        return numbers;
    }
}
