package lotto.view;

import lotto.controller.LotteryController;
import lotto.model.Lottery;
import lotto.model.LotteryNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Optional<String> scanWithPayload(String payload) {
        System.out.println(payload);
        String scanned = scanner.nextLine();
        if (scanned.equals("")) {
            scanned = null;
        }
        return Optional.ofNullable(scanned);
    }

    public static Optional<String> scan() {
        String scanned = scanner.nextLine();
        if (scanned.equals("")) {
            scanned = null;
        }
        return Optional.ofNullable(scanned);
    }
}
