package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.lotto.wrapper.LottoNumber.*;

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

    public void validateLottoNumbers(String input, String delimiter) {
        validateDelimiter(input, delimiter);
        String[] numbersString = input.split(delimiter);

        List<Integer> numbers = Arrays.stream(numbersString)
            .map(this::validateParseInt)
            .collect(Collectors.toUnmodifiableList());

        numbers.forEach(number -> validateRangeOfNumber(number, MIN, MAX));
        validateDuplicate(numbers);
    }

    private void validateDelimiter(String input, String delimiter) {
        if (!input.contains(delimiter)) {
            throw new IllegalArgumentException("입력하는 숫자는 ','(쉼표)로 구분해야 합니다.");
        }
    }

    private int validateParseInt(String numberString) {
        int number;

        try {
            number = Integer.parseInt(numberString);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("로또 번호는 정수를 입력해야 합니다.");
        }

        return number;
    }

    private void validateRangeOfNumber(Integer number, int min, int max) {
        if (isOutOfRange(number, min, max)) {
            throw new IllegalArgumentException(String.format("숫자의 범위는 %d ~ %d입니다.", min, max));
        }
    }

    private boolean isOutOfRange(int number, int min, int max) {
        return number < min || number > max;
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> distinct = numbers.stream()
            .distinct()
            .collect(Collectors.toUnmodifiableList());

        validateAmountOfNumbers(distinct);
    }

    private void validateAmountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개가 입력되어야 합니다.");
        }
    }

    public void validateBonusNumber(String input, Set<Integer> winningNumbers) {
        int number = (int) validateParseLong(input);

        validateRangeOfNumber(number, MIN, MAX);
        validateDuplicate(winningNumbers, number);
    }

    private void validateDuplicate(Set<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복이 되면 안됩니다.");
        }
    }

    public void validateCountOfManual(String input, int numOfLotto) {
        int countOfManual = validateParseInt(input);

        validateRangeOfNumber(countOfManual, 0, numOfLotto);
    }
}
