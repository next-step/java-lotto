package lotto.io;

import lotto.exception.InvalidLottoNumbersException;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String WINNING_NUMBER_DELIMITER = ", ";

    @Override
    public long getPurchaseAmountFromUser() {
        String userInput = SCANNER.nextLine();
        return Long.parseLong(userInput);
    }

    @Override
    public List<Integer> getLottoNumbersFromUser() {
        String[] split = SCANNER.nextLine().split(WINNING_NUMBER_DELIMITER);
        List<String> numbers = getTrimmedStringNumbers(split);

        validateLottoNumbers(numbers);

        return toIntegers(numbers);
    }

    private List<Integer> toIntegers(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public int getOneNumberFromUser() {
        String userInput = SCANNER.nextLine();
        return Integer.parseInt(userInput);
    }

    @Override
    public List<List<Integer>> getManualPurchaseLottoNumbers(int manualLottoPurchaseCount) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < manualLottoPurchaseCount; i++) {
            List<Integer> lottoNumbersFromUser = getLottoNumbersFromUser();
            lottoNumbers.add(lottoNumbersFromUser);
        }

        return lottoNumbers;
    }

    private List<String> getTrimmedStringNumbers(String[] split) {
        return Arrays.stream(split)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateLottoNumbers(List<String> lottoNumbers) {
        if (hasDifferentSize(lottoNumbers)) {
            throw new InvalidLottoNumbersException();
        }
    }

    private boolean hasDifferentSize(List<String> lottoNumbers) {
        return new HashSet<>(lottoNumbers).size() != lottoNumbers.size();
    }

}
