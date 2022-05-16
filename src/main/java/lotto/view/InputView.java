package lotto.view;

import lotto.controller.LotteryController;
import lotto.model.Lottery;
import lotto.model.LotteryNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String scanWithPayload(String payload) {
        System.out.println(payload);
        return scanner.nextLine();
    }

    public static String scan() {
        return scanner.nextLine();
    }


}
