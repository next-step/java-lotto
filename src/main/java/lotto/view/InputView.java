package lotto.view;

import lotto.domain.model.LottoRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static LottoRequest getLottoRequest() {
        int purchaseAmount = getPurchaseAmount();
        int manualLottoCount = getManualLottoCount();

        LottoRequest request = new LottoRequest(purchaseAmount);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualLottoCount; i ++) {
            String stringInput = scanner.nextLine();
            List<Integer> manualNumbers = parseIntFromString(stringInput);
            request.addRequest(manualNumbers);
        }

        return request;
    }

    public static List<Integer> getWinNumbers() {
        String stringInput = getStringInput("지난 주 당첨 번호를 입력해 주세요.");
        return parseIntFromString(stringInput);
    }

    public static int getBonusNumber() {
        return getIntInput("보너스 볼을 입력해 주세요.");
    }

    private static int getPurchaseAmount() {
        return getIntInput("구입금액을 입력해 주세요.");
    }

    private static int getManualLottoCount() {
        return getIntInput("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    private static List<Integer> parseIntFromString(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int getIntInput(String message) {
        String stringInput = getStringInput(message);
        return Integer.parseInt(stringInput);
    }

    private static String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
