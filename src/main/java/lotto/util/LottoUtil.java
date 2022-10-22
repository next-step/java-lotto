package lotto.util;

import lotto.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoUtil {

    public static final int LOTTO_NUMBERS = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final String SPLIT_COMMA_SPACE = "[ ,]+";

    private LottoUtil() {

    }

    public static int getNumOfTickets(int paidAmount) {
        verifyInputNumber(paidAmount);
        return paidAmount / LOTTO_PRICE;
    }

    private static void verifyInputNumber(int value) {
        if (!isPurchasable(value)) {
            throw new IllegalArgumentException(value + "원으로 로또를 구매할 수 없습니다.");
        }
    }

    private static boolean isPurchasable(int paidAmount) {
        return paidAmount >= 1000;
    }

    public static List<Number> splitStringToNumbers(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(SPLIT_COMMA_SPACE);
        List<Number> numbers = new ArrayList<>();

        for (String splitNumber : splitNumbers) {
            numbers.add(new Number(Integer.parseInt(splitNumber)));
        }
        verifyLottoNumbers(numbers);

        return numbers;
    }

    private static void verifyLottoNumbers(List<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또는 6개의 숫자를 입력하셔야 합니다.");
        }
    }

    public static List<Integer> convertToIntegers(List<Number> numbers) {
        return numbers.stream()
                .map(Number::getNumber)
                .collect(Collectors.toList());
    }
}
