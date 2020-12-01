package lotto.automatic.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNums {

    private final List<LottoNumber> nums;
    private final LottoNumber bonusNumber;

    public LottoWinningNums(String rawNumberString, int bonusNumber) {
        String[] numberStrings = rawNumberString.split(",");

        List<LottoNumber> nums = new ArrayList<>();

        for (String numString : numberStrings) {
            nums.add(new LottoNumber(Integer.parseInt(numString.trim())));
        }

        this.nums = nums;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return nums;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
