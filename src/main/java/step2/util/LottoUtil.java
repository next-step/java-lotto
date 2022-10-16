package step2.util;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Integer> splitStringToNumbers(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(SPLIT_COMMA_SPACE);
        List<Integer> numbers = new ArrayList<>();

        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber));
        }
        verifyLottoNumbers(numbers);

        return numbers;
    }

    private static void verifyLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또는 6개의 숫자를 입력하셔야 합니다.");
        }
    }

    public static void verifyInputNumber(int value) {
        if (!isPurchasable(value)) {
            throw new IllegalArgumentException(value + "원으로 로또를 구매할 수 없습니다.");
        }
    }

    private static boolean isPurchasable(int paidAmount) {
        return paidAmount >= 1000;
    }
}
