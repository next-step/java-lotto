package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_PRICE_PHRASE = "구입금액을 입력해 주세요.";
    private static final String WINNING_TICKET_PHRASE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PHRASE = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO_SIZE_PHRASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_PHRASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public int getPurchasePrice() {
        System.out.println(PURCHASE_PRICE_PHRASE);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> getWinningNumbers() {
        System.out.println(WINNING_TICKET_PHRASE);
        String input = scanner.nextLine();
        System.out.println(input);
        return parseIntegerList(input);
    }

    public int getBonusNumber() {
        System.out.println(BONUS_NUMBER_PHRASE);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<List<Integer>> getManualLottoNumbers(int manualCount) {
        System.out.println(MANUAL_LOTTO_NUMBER_PHRASE);
        List<String> inputs = new ArrayList<>();
        for (int i = 0 ; i < manualCount; i++){
            inputs.add(scanner.nextLine());
        }

        return inputs.stream()
                .map(this::parseIntegerList)
                .collect(Collectors.toList());
    }

    private List<Integer> parseIntegerList(String input) {
        return Arrays.stream(input.replaceAll(" ", "").split(LOTTO_NUMBER_DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public int getManualSize() {
        System.out.println(MANUAL_LOTTO_SIZE_PHRASE);
        return Integer.parseInt(scanner.nextLine());
    }
}
