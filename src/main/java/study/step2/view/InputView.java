package study.step2.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Integer> lastWeekLottoNumbers = new ArrayList<>();

    private InputView() {
    }

    public static String inputLottoPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        return scanner.nextLine();
    }

    public static List<Integer> inputLastWeekLottoNumber() {
        System.out.println(INPUT_LAST_WEEK_NUMBER_MESSAGE);
        Arrays.stream(scanner.nextLine().split(", "))
                .forEach(element -> lastWeekLottoNumbers.add(Integer.parseInt(element)));
        return lastWeekLottoNumbers;
    }
}
