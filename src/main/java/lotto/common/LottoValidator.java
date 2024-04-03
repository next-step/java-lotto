package lotto.common;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {

    private static final int NUMBER_SIZE = 6;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private LottoValidator() {
    }

    public static void validatePurchase(int money, int price, int manualCount) {
        if (manualCount * price > money) {
            throw new IllegalArgumentException(
                String.format("%s개의 로또를 사기 위해서는 최소 %s원이 필요합니다", manualCount, manualCount * price));
        }

        if (money < price) {
            throw new IllegalArgumentException(String.format("로또의 가격은 %s 입니다.", price));
        }
    }

    public static void validateLottoNumber(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format("당첨 번호는 %s개 입니다.", NUMBER_SIZE));
        }

        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public static void validateLottoNumberRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Lotto 숫자 범위는 %s~%s 입니다.", MIN_VALUE, MAX_VALUE));
        }
    }
}
