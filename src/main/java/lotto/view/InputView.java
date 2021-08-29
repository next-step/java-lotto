package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String DELIMITER = ",";

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> readLottoNumbers() {
        return readNumbers("지난 주 당첨 번호를 입력해 주세요.");
    }

    private static List<Integer> readNumbers(String message) {
        System.out.println(message);

        List<Integer> numbers = Collections.emptyList();
        while (numbers.size() != Lotto.LOTTO_NUMBER_SIZE) {
            String raw = getRawString("(1 ~ 45 사이의 distinct 한 6개 숫자로 입력)");
            numbers = translateNumbers(raw);
        }

        return numbers;
    }

    private static String getRawString (String message) {
        String raw = null;
        while (raw == null || raw.isEmpty()) {
            System.out.println(message);
            raw = scanner.nextLine();
        }
        return raw;
    }

    private static List<Integer> translateNumbers(String raw) {
        return Arrays.stream(raw.split(DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .distinct()
            .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        String raw = getRawString("보너스 볼을 입력해 주세요.");

        return Integer.parseInt(raw);
    }

    public static List<List<Integer>> readManualNumbers() {
        int manualNumbersSize = readManualNumbersSize();

        List<List<Integer>> manualNumbersList = new ArrayList<>();
        for (int i = 0; i < manualNumbersSize; i++) {
            manualNumbersList.add(readNumbers("수동으로 구매할 번호를 입력해 주세요."));
        }

        return manualNumbersList;
    }

    private static int readManualNumbersSize() {
        String raw = getRawString("수동으로 구매할 로또 수를 입력해 주세요.");

        return Integer.parseInt(raw);
    }
}
