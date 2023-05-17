package lottoauto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lottoauto.model.Lotto;

public class InputView {

    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "보너스 숫자를 입력해 주세요";
    private static final String LOTTO_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요";
    private static final String LOTTO_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요";
    private static final Scanner scanner = new Scanner(System.in);

    public static int price() {
        System.out.println(INPUT_PRICE);
        return convertInteger(scanner.nextLine());
    }

    public static List<Integer> winningNumber() {
        System.out.println(LAST_WINNING_NUMBER);
        return Arrays.stream(scanner.nextLine()
                        .split(OutputView.DELIMITER))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public static int bonus() {
        System.out.println(INPUT_BONUS);
        return convertInteger(scanner.nextLine());
    }

    public static int lotteryManual() {
        System.out.println(LOTTO_MANUAL_COUNT);
        return convertInteger(scanner.nextLine());
    }

    public static List<Lotto> inputManualNumber(int count) {
        List<Lotto> manualLottery = new ArrayList<>();
        System.out.println(LOTTO_MANUAL_NUMBER);
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.manual(scanner.nextLine());

            manualLottery.add(lotto);
        } 
        return manualLottery;
    }

    private static int convertInteger(String text) {
        return Integer.parseInt(text);
    }

}
