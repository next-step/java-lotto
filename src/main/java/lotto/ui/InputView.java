package lotto.ui;

import java.util.Scanner;

public class InputView {
    public void exec() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much will you pay?");
        int money = scanner.nextInt();

        // TODO : get lottoCount with money
        int lottoCount = 0;
        System.out.printf("You got %d lottos\n", lottoCount);
        // TODO : print lotto with numbers

        System.out.println("Input winning numbers of last week");
        String strWinningNumbers = scanner.next();
        // TODO : parse strWinningNumbers

        System.out.println("Input bonus ball number");
        int bonusNumber = scanner.nextInt();
    }
}
