package lotto.view;

import lotto.domain.LottoCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INSERT_PRICE = "구입금액을 입력해 주세요.";
    private static final String INSERT_ANSWER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS = "보너스 볼을 입력해 주세요.";
    private static final String INSERT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INSERT_MANUAL_INPUT = "수동으로 구매할 번호를 입력해 주세요.";

    private InputView() {
    }

    public static String questionPrice() {
        System.out.println(INSERT_PRICE);
        return getInputValue();
    }

    public static String questionAnswer() {
        System.out.println(INSERT_ANSWER);
        return getInputValue();
    }

    public static String questionBonus() {
        System.out.println(INSERT_BONUS);
        return getInputValue();
    }

    public static String questionManualCount() {
        System.out.println(INSERT_MANUAL_COUNT);
        return getInputValue();
    }

    public static List<String> questionManualInput(LottoCount count) {
        System.out.println(INSERT_MANUAL_INPUT);
        List<String> manualList = new ArrayList<>();
        for (int i = 0; i < count.getCount(); i++) {
            manualList.add(getInputValue());
        }
        return manualList;
    }

    private static String getInputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
