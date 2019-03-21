package lotto.view;

import lotto.domain.LuckyLotto;
import lotto.domain.MyLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int input() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static LuckyLotto inputLuckyNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(", ");

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        return new LuckyLotto(parseInt(numbers), bonusNumber);
    }

    private static List<Integer> parseInt(String[] numbers) {
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            luckyNumbers.add(Integer.parseInt(numbers[i]));
        }
        return luckyNumbers;
    }
}
