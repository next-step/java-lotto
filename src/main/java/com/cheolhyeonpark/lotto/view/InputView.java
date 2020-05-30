package com.cheolhyeonpark.lotto.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String inputWinningNumber() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine().trim();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    @Override
    protected void finalize() throws Throwable {
        scanner.close();
        super.finalize();
    }
}
