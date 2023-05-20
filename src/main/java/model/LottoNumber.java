package model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private static final int LOTTO_NUMS = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String LOTTO_COUNT_ERORR_MESSAGE = "로또의 개수가 " + LOTTO_NUMS + "개가 아닙니다.";
    private static final String LOTTO_BOUND_ERORR_MESSAGE = MIN_NUM + "에서 " + MAX_NUM + "까지 범위가 아닙니다.";
    private static final String BONUS_BOUND_ERORR_MESSAGE = MIN_NUM + "에서 " + MAX_NUM + "까지 범위가 아닙니다.";
    private List<Integer> lottoNumber = new ArrayList<>();
    private int bonus;

    public LottoNumber(List<Integer> numbers) {
        isValidLottoCount(numbers);
        isValidLottoRange(numbers);

        this.lottoNumber = numbers;
    }

    public LottoNumber(List<Integer> numbers, int bonus) {
        isValidLottoCount(numbers);
        isValidLottoRange(numbers);
        isValidBonusRange(bonus);

        this.lottoNumber = numbers;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public int getBonus() {
        return bonus;
    }

    private static void isValidLottoRange(List<Integer> numbers) {
        boolean isValidRange = numbers.stream()
                .allMatch(number -> number >= MIN_NUM && number <= MAX_NUM);

        if (!isValidRange) {
            throw new RuntimeException(LOTTO_BOUND_ERORR_MESSAGE);
        }
    }

    private static void isValidBonusRange(int bonus) {
        boolean isValidRange = bonus >= MIN_NUM && bonus <= MAX_NUM;

        if (!isValidRange) {
            throw new RuntimeException(LOTTO_BOUND_ERORR_MESSAGE);
        }
    }

    private static void isValidLottoCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMS) {
            throw new RuntimeException(LOTTO_COUNT_ERORR_MESSAGE);
        }
    }

}
