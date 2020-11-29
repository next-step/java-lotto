package lotto.automatic.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNums {

    private final List<LottoNumber> nums;

    public LottoWinningNums(String rawNumberString) {

        String[] numberStrings = rawNumberString.split(",");

        List<LottoNumber> nums = new ArrayList<>();

        for (String numString : numberStrings) {
            nums.add(new LottoNumber(Integer.parseInt(numString.trim())));
        }

        this.nums = nums;
    }

    public List<LottoNumber> getLottoNumbers() {
        return nums;
    }
}
