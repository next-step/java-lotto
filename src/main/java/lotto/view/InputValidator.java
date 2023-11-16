package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public void validatePurchaseMoney(String purchase, int lottoPrice) {
        long purchaseMoney = validateParseLong(purchase);
        validateMinimum(purchaseMoney, lottoPrice);
        validatePurchaseUnit(purchaseMoney, lottoPrice);
    }

    private long validateParseLong(String purchase) {
        long purchaseMoney;

        try {
            purchaseMoney = Long.parseLong(purchase);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 양의 정수만 입력 가능합니다.");
        }

        return purchaseMoney;
    }

    private void validateMinimum(long purchaseMoney, int lottoPrice) {
        if (purchaseMoney < lottoPrice) {
            throw new IllegalArgumentException("구입 금액은 천원 이하가 될 수 없습니다.");
        }
    }

    private void validatePurchaseUnit(long purchaseMoney, int lottoPrice) {
        if (purchaseMoney%lottoPrice != 0) {
            throw new IllegalArgumentException("구입 금액은 천원 단위이어야 합니다.");
        }
    }

    public void validateWinningNumbers(String input, String delimiter) {
        validateDelimiter(input, delimiter);
        String[] numbersString = input.split(delimiter);

        List<Integer> numbers = validateParseInt(numbersString);
        validateNegative(numbers);
        validateDuplicate(numbers);
    }

    private void validateDelimiter(String input, String delimiter) {
        if (!input.contains(delimiter)) {
            throw new IllegalArgumentException("입력하는 숫자는 ','(쉼표)로 구분해야 합니다.");
        }
    }

    private List<Integer> validateParseInt(String[] numbersString) {
        List<Integer> numbers;

        try {
            numbers = Arrays.stream(numbersString)
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toUnmodifiableList());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("당첨 번호는 정수를 입력해야 합니다.");
        }

        return numbers;
    }

    private void validateNegative(List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException("숫자의 범위는 1~45입니다.");
        }
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
            .anyMatch(number -> number < 1 || number > 45);
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> distinct = numbers.stream()
            .distinct()
            .collect(Collectors.toUnmodifiableList());

        validateAmountOfNumbers(distinct);
    }

    private void validateAmountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 당첨 번호는 6개가 입력되어야 합니다.");
        }
    }
}
