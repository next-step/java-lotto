package lotto.view;

import stringcalculator.exception.StringCalculatorIllegalArgumentException;
import stringcalculator.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String COMMA_DELIMITER = ",";
    public static final String EMPTY_INPUT = "입력값이 비어있습니다.";

    private final Scanner scanner = new Scanner(System.in);

    public int getAmountFromUser() {
        System.out.println("구매금액을 입력해 주세요.");

        String inputLine = scanner.nextLine();

        if (StringUtil.isBlank(inputLine)) {
            throw new StringCalculatorIllegalArgumentException(EMPTY_INPUT);
        }

        return Integer.parseInt(inputLine);
    }

    public int getManualLottoCountFromUser() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        String inputLine = scanner.nextLine();

        return Integer.parseInt(inputLine);
    }

    public List<List<Integer>> getManualLottoNumbers(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요..");

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String inputLine = scanner.nextLine();

            if (StringUtil.isBlank(inputLine)) {
                throw new StringCalculatorIllegalArgumentException("입력값이 비어있습니다.");
            }
            manualLottoNumbers.add(splitByComma(inputLine));
        }

        return manualLottoNumbers;
    }

    public List<Integer> getWinningNumbersFromUser() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String inputLine = scanner.nextLine();

        if (StringUtil.isBlank(inputLine)) {
            throw new StringCalculatorIllegalArgumentException("입력값이 비어있습니다.");
        }

        return splitByComma(inputLine);
    }

    public Integer getBonusNumberFromUser() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private List<Integer> splitByComma(String text) {
        return Arrays.stream(text.split(COMMA_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }
}
