package lotto.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ", ";

    public static int inputTotalPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return getInputInteger();
    }

    public static List<Set<Integer>> inputManualLotteries() {
        int manualLottoAmount = inputManualLottoAmount();
        return inputAndParseManualLottoNumbersList(manualLottoAmount);
    }

    public static Set<Integer> inputLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = getInputString();

        return parseStringToIntegerSet(inputWinningNumbers);
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return getInputInteger();
    }

    private static int getInputInteger() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            return 0;
        }
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int inputManualLottoAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return getInputInteger();
    }

    private static List<Set<Integer>> inputAndParseManualLottoNumbersList(int manualLottoAmount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<String> manualLottoNumbersList = inputManualLottoNumbersList(manualLottoAmount);
        return parseStringsToIntegerSetList(manualLottoNumbersList);
    }

    private static List<String> inputManualLottoNumbersList(int manualLottoAmount) {
        List<String> inputManualLottoNumbersList = new ArrayList<>();
        for (int i = 0; i < manualLottoAmount; i++) {
            String inputManualLottoNumbers = getInputString();
            inputManualLottoNumbersList.add(inputManualLottoNumbers);
        }
        return inputManualLottoNumbersList;
    }

    private static List<Set<Integer>> parseStringsToIntegerSetList(List<String> strings) {
        return strings.stream()
                .map(InputView::parseStringToIntegerSet)
                .collect(Collectors.toList());
    }

    private static Set<Integer> parseStringToIntegerSet(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
    }
}
