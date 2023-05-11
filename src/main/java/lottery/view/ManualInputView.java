package lottery.view;

import static lottery.domain.Lottery.lotteryFactory;
import static lottery.view.BlankPrintView.printBlank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lottery.domain.Lotteries;
import lottery.domain.Lottery;

public class ManualInputView {

    private static final String MANUAL_INPUT_MSG = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Lottery> manualInput(int manualNumber) {
        printSource(MANUAL_INPUT_MSG);
        List<Lottery> manualLotteries = new ArrayList<>();
        while (manualLotteries.size() != manualNumber) {
            manualLotteries.add(lotteryFactory(SCANNER.nextLine()));
        }

        printBlank();
        return manualLotteries;
    }

    private static void printSource(String source) {
        System.out.println(source);
    }
}
