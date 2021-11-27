package lotto.view;

import lotto.model.ticket.LotteryTicket;
import lotto.model.domain.Lotto;
import lotto.model.domain.PurchaseInfo;
import util.NumberUtils;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static PurchaseInfo getPurchaseInfo() {
        int amount = getIntValue("구입금액을 입력해 주세요.");
        int manualCount = getIntValue("수동으로 구매할 로또 수를 입력해 주세요.");
        return new PurchaseInfo(amount, manualCount);
    }

    public static LotteryTicket getTicket(String message) {
        List<Integer> numbers = InputView.getCommaSplitIntList(message);
        Collections.sort(numbers);
        return new LotteryTicket(numbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    public static Lotto getBonusLotto() {
        return new Lotto(InputView.getIntValue("보너스 볼을 입력해 주세요."));
    }

    private static int getIntValue(String message){
        String input = getInput(message);
        if(!NumberUtils.isIntValue(input)) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
        return Integer.parseInt(input);
    }

    private static String getInput(String message) {
        System.out.println(message);
        return scanner.next();
    }

    private static List<Integer> getCommaSplitIntList(String message){
        String[] list = getInput(message).split(",");
        checkAllInt(list);
        return Arrays.stream(list)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void checkAllInt(String[] list) {
        boolean allInt = Arrays.stream(list).allMatch(NumberUtils::isIntValue);
        if(!allInt) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
    }
}