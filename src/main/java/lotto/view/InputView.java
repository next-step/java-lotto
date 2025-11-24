package lotto.view;

import lotto.model.PurchaseAmount;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static PurchaseAmount readBudgetInput() {
        Scanner scanner = new Scanner(System.in);
        print("구입금액을 입력해 주세요.");
        return new PurchaseAmount(scanner.nextInt());
    }

    public static Lotto readWinningLottoInput() {
        Scanner scanner = new Scanner(System.in);
        print("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputs = scanner.nextLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            int number = Integer.parseInt(input.trim());
            numbers.add(number);
        }
        return new Lotto(numbers);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
