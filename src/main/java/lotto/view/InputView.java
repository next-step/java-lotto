package lotto.view;

import lotto.controller.LotteryController;
import lotto.model.Lottery;
import lotto.model.LotteryNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String scan(String payload) {
        System.out.println(payload);
        return scanner.nextLine();
    }

    public static List<Lottery> scanMultiLine(String payload) {
        List<Lottery> scannedNumbers = new ArrayList<>();
        System.out.println(payload);
        return scanALine(scannedNumbers);
    }

    private static List<Lottery> scanALine(List<Lottery> lotteries) {
        String scanned = scanner.nextLine();
        if (scanned.length() > 0) {
            List<LotteryNumber> lotteryNumbers = LotteryController.parseNumbers(scanned);
            lotteries.add(new Lottery(lotteryNumbers));
            scanALine(lotteries);
        }
        return lotteries;
    }
}
