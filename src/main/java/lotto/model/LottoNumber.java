package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    private List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public RewardStatus getRewardStatus(String[] winningNumber, int bonus) {
        int matchingCount = 0;
        for (int i = 0; i < winningNumber.length; i++) {
            matchingCount += (numbers.contains(Integer.parseInt(winningNumber[i]))) ? 1 : 0;
        }
        return new RewardStatus(matchingCount, numbers.contains(bonus));
    }

    public List<Integer> getLottoNumber() {
        return numbers;
    }

}
