package lotto.automatic.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNums {

    private final List<Integer> nums;

    public LottoWinningNums(String rawNumberString) {

        String[] numberStrings = rawNumberString.split(",");

        List<Integer> nums = new ArrayList<>();

        for (String numString : numberStrings) {
            nums.add(Integer.parseInt(numString.trim()));
        }

        this.nums = nums;
    }

    public Lotto getWinningLotto() {
        return new Lotto(this.nums);
    }
}
