package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int PRICE_PER_LOTTO = 1000;
    private static final String ERROR_INVALID_PURCHASE_AMOUNT =
            "금액은 " + PRICE_PER_LOTTO + "원 단위로 입력해야 합니다.";

    public static List<Integer> generateLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static List<List<Integer>> generateLottos(int money) {
        validateMoney(money);
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < money / PRICE_PER_LOTTO; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public static int countMatches(List<Integer> lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : lotto) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static void validateMoney(int money) {
        if (money < PRICE_PER_LOTTO || money % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_AMOUNT);
        }
    }
}
