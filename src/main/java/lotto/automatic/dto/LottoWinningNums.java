package lotto.automatic.dto;

import lotto.automatic.domain.Lotto;
import lotto.automatic.domain.LottoNumber;
import lotto.automatic.domain.WinningLotto;

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

    public WinningLotto getWinningLotto() {
        return new WinningLotto(new Lotto(nums), bonusNumber);
    }
}
