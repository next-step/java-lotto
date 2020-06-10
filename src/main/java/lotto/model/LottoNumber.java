package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    private List<Integer> numberlist;

    public LottoNumber(List<Integer> numberlist) {
        this.numberlist = numberlist;
    }

    public RewardStatus getRewardStatus(String[] winningNumber, int bonus) {
        int matchingCount = 0;
        for (int i = 0; i < winningNumber.length; i++) {
            matchingCount += (numberlist.contains(Integer.parseInt(winningNumber[i]))) ? 1 : 0;
        }
        return new RewardStatus(matchingCount, numberlist.contains(bonus));
    }

    public String getLottoNumbertoString() {
        return numberlist.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
