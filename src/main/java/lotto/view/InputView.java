package lotto.view;

import lotto.exception.LottoIllegalArgumentException;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_AMOUNT = "구매 금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요..";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String COMMA_DELIMITER = ",";
    private final Scanner scanner = new Scanner(System.in);

    public int getAmountFromUser() {
        System.out.println(INPUT_AMOUNT);
        return parseToInt(scanner.nextLine());
    }

    public int getManualLottoCountFromUser() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT);
        return parseToInt(scanner.nextLine());
    }

    public List<List<Integer>> getManualLottoNumbers(int manualLottoCount) {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBERS);

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String inputLine = scanner.nextLine();

            manualLottoNumbers.add(splitByComma(inputLine));
        }

        return manualLottoNumbers;
    }

    public List<Integer> getWinningNumbersFromUser() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return splitByComma(scanner.nextLine());
    }

    public Integer getBonusNumberFromUser() {
        System.out.println(INPUT_BONUS_NUMBER);
        String inputLine = scanner.nextLine();
        return parseToInt(inputLine);
    }

    private int parseToInt(String text) {
        return Optional.ofNullable(text)
                .filter(str -> isPresent(text))
                .map(String::trim)
                .flatMap(this::tryParseInt)
                .orElseThrow(() -> LottoIllegalArgumentException.INVALID_PARSE_TO_INT);
    }

    private List<Integer> splitByComma(String text) {
        return Optional.ofNullable(text)
                .filter(str -> isPresent(text))
                .map(str -> Arrays.stream(text.split(COMMA_DELIMITER))
                        .map(String::trim)
                        .map(this::parseToInt)
                        .collect(Collectors.toUnmodifiableList()))
                .orElseThrow(() -> LottoIllegalArgumentException.INVALID_PARSE_TO_INT);
    }

    private Optional<Integer> tryParseInt(String text) {
        try {
            return Optional.of(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    private boolean isPresent(String str) {
        return str != null && !str.isBlank();
    }
}
